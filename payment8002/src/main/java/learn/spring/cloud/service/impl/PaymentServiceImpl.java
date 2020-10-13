package learn.spring.cloud.service.impl;

import learn.spring.cloud.mapper.PaymentMapper;
import learn.spring.cloud.pojo.Payment;
import learn.spring.cloud.service.PaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 邝明山
 * @since 2020-10-09
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

}
