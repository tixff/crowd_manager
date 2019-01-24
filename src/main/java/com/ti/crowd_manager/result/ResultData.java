package com.ti.crowd_manager.result;

import lombok.Data;

/**
 * @author Ti
 * @date 2019/1/24
 */
@Data
public class ResultData {
    private String message;
    private Object data;

    private ResultData() {
    }

    public static ResultData createResultData() {
        return new ResultData();
    }
}
