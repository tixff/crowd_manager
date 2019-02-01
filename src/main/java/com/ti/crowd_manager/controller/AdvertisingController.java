package com.ti.crowd_manager.controller;

import com.ti.crowd_manager.domain.Advertisement;
import com.ti.crowd_manager.result.ResultData;
import com.ti.crowd_manager.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Ti
 * @date 2019/1/30
 */
@RestController
@RequestMapping("/advertising")
public class AdvertisingController {

    @Autowired
    private AdvertiseService service;

    @PostMapping("add")
    public ResultData addAdvertising(Advertisement ad) {
        ad.setCreateTime(new Date());
        ResultData resultData = ResultData.createResultData();
        try {
            service.addAdvertise(ad);
            resultData.setMessage("添加成功");
        } catch (Exception e) {
            resultData.setMessage("添加失败");
        }
        return resultData;
    }
}
