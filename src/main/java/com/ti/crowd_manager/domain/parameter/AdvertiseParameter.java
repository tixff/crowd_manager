package com.ti.crowd_manager.domain.parameter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Ti
 * @date 2019/1/30
 */
@Data
public class AdvertiseParameter {

    @ApiModelProperty("查询条数")
    private Integer count = 4;

    @ApiModelProperty("广告类型")
    private int status;

}
