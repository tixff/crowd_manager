package com.ti.crowd_manager.domain.parameter;

import lombok.Data;

/**
 * @author Ti
 * @date 2019/1/28
 */
@Data
public class QueryParameter {
    private Long start;
    private Long end;
    private Integer[] ids;
}
