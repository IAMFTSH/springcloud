package learn.spring.exclude;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.plaf.basic.BasicDesktopIconUI;

/**
 * @author 邝明山
 * on 2020/10/11 21:36
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
