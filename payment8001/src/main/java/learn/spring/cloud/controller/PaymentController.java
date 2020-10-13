package learn.spring.cloud.controller;


import learn.spring.cloud.common.JsonResult;
import learn.spring.cloud.common.vo.PaymentVo;
import learn.spring.cloud.pojo.Payment;
import learn.spring.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-10-09
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/getPayment/{id}")
    public JsonResult getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        PaymentVo paymentVo=new PaymentVo();
        paymentVo.setId(payment.getId());
        paymentVo.setSerial(payment.getSerial());
        if (payment != null) {
            return JsonResult.success("查询成功"+serverPort,paymentVo);
        } else {
            return JsonResult.error("查询失败，没有对应记录");
        }
    }

    @PostMapping("/insertPayment")
    public JsonResult insertPayment(@RequestBody PaymentVo paymentVo) {
        log.info("插入"+paymentVo.toString());
        Payment payment=new Payment(null,paymentVo.getSerial());
        boolean result = paymentService.save(payment);
        if (true) {
            return JsonResult.success("插入成功");
        } else {
            return JsonResult.error("插入失败");
        }
    }

    @PutMapping("/updatePaymentById")
    public void updatePaymentById(@RequestBody PaymentVo paymentVo) {
        paymentService.updateById(new Payment(paymentVo.getId(),paymentVo.getSerial()));
    }

    @DeleteMapping("deletePaymentById/{id}")
    public void deletePaymentById(@PathVariable("id") Long id) {
        boolean result = paymentService.removeById(id);
/*        if (result) {
            return JsonResult.success("删除成功");
        } else {
            return JsonResult.error("删除失败");
        }*/
    }

    @GetMapping("getServiceInfo")
    public JsonResult getServiceInfo(){
        List<String> discoveryClientServices = discoveryClient.getServices();
        List<ServiceInstance> discoveryClientInstances = new ArrayList<>();
        for(String ServiceName:discoveryClientServices){
            discoveryClientInstances.addAll(discoveryClient.getInstances(ServiceName));
        }
        Map<String,Object> map=new HashMap<>();
        map.put("service",discoveryClientServices);
        map.put("instances",discoveryClientInstances);
        return JsonResult.success(map);
    }
}

