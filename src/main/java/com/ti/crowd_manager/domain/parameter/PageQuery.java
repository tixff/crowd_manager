package com.ti.crowd_manager.domain.parameter;

import lombok.Data;

/**
 * @author Ti
 * @date 2019/1/28
 */
@Data
public class PageQuery {
    private Long rows = 6l;
    private Long currentPage = 1l;
}
