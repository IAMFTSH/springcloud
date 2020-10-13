package learn.spring.cloud.controller;

import learn.spring.cloud.common.ConstantUrl;
import learn.spring.cloud.common.JsonResult;
import learn.spring.cloud.common.vo.PaymentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author 邝明山
 * on 2020/10/9 16:50
 */
@Slf4j
@RestController("/controller")
public class OrderController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping(value = "/payment/getPayment/{id}")
    public JsonResult<PaymentVo> get(@PathVariable("id") Long id){
        log.info("地址"+ConstantUrl.PAYMENT_URL+"getPayment/"+id);
        return restTemplate.getForObject(ConstantUrl.PAYMENT_URL+"getPayment/"+id,JsonResult.class);
    }
    @PostMapping("/payment/insertPayment")
    public JsonResult<PaymentVo> insert(@RequestBody PaymentVo paymentVo){
        log.info(paymentVo.toString());
        return restTemplate.postForObject(ConstantUrl.PAYMENT_URL+"insertPayment",paymentVo,JsonResult.class);
    }
    @PutMapping("/payment/updatePaymentById")
    public void update(@RequestBody PaymentVo paymentVo){
        log.info("修改"+paymentVo.toString());
        restTemplate.put(ConstantUrl.PAYMENT_URL+"updatePaymentById",paymentVo);
    }
    @DeleteMapping("/payment/deletePaymentById/{id}")
    public void delete(@PathVariable("id") Long id){
        restTemplate.delete(ConstantUrl.PAYMENT_URL+"deletePaymentById/"+id);
    }
}
