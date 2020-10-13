package learn.spring.cloud.controller;

import learn.spring.cloud.common.ConstantUrl;
import learn.spring.cloud.common.JsonResult;
import learn.spring.cloud.common.vo.PaymentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author 邝明山
 * on 2020/10/11 20:53
 */
@Slf4j
@RestController("/RestTemplate")
public class RestTemplateController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping(value = "getForObject/getPayment/{id}")
    public JsonResult<PaymentVo> getForObject(@PathVariable("id") Long id){
        log.info("地址"+ ConstantUrl.PAYMENT_URL+"getPayment/"+id);
        return restTemplate.getForObject(ConstantUrl.PAYMENT_URL+"getPayment/"+id,JsonResult.class);
    }
    @GetMapping(value = "getForEntity/getPayment/{id}")
    public JsonResult<PaymentVo> getForEntity(@PathVariable("id") Long id){
        log.info("地址"+ ConstantUrl.PAYMENT_URL+"getPayment/"+id);
        ResponseEntity<JsonResult> responseEntity = restTemplate.getForEntity(ConstantUrl.PAYMENT_URL + "getPayment/" + id, JsonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            return JsonResult.success(responseEntity);
        }else {
            return JsonResult.error();
        }
    }
    @PostMapping("/postForObject/insertPayment")
    public JsonResult<PaymentVo> postForObjectInsert(@RequestBody PaymentVo paymentVo){
        log.info(paymentVo.toString());
        return restTemplate.postForObject(ConstantUrl.PAYMENT_URL+"insertPayment",paymentVo,JsonResult.class);
    }
    @PostMapping("/responseEntity/insertPayment")
    public JsonResult<PaymentVo> responseEntityInsert(@RequestBody PaymentVo paymentVo){
        log.info(paymentVo.toString());
        ResponseEntity<JsonResult> responseEntity = restTemplate.postForEntity(ConstantUrl.PAYMENT_URL + "insertPayment", paymentVo, JsonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            return JsonResult.success(responseEntity);
        }else {
            return JsonResult.error();
        }
    }
    @PutMapping("/put/updatePaymentById")
    public void update(@RequestBody PaymentVo paymentVo){
        log.info("修改"+paymentVo.toString());
        restTemplate.put(ConstantUrl.PAYMENT_URL+"updatePaymentById",paymentVo);
    }
    @DeleteMapping("/delete/deletePaymentById/{id}")
    public void delete(@PathVariable("id") Long id){
        restTemplate.delete(ConstantUrl.PAYMENT_URL+"deletePaymentById/"+id);
    }
}
