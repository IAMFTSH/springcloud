package learn.spring.cloud;

import learn.spring.exclude.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 邝明山
 * on 2020/10/9 16:42
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="payment-service",configuration = MyselfRule.class)
public class ConsumerOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain80.class,args);
    }
}
