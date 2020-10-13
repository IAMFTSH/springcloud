package learn.spring.cloud.common.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 邝明山
 * on 2020/10/9 21:34
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Payment对象", description="")
public class PaymentVo implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    private String serial;


}
