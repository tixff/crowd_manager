package com.ti.crowd_manager.result;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author Ti
 * @date 2019/1/28
 */
@Data
public class PageResult<T> {
    private Long currentPage;
    private Long totalCount;
    private Long totalPage;
    private ArrayList<T> data;

}
