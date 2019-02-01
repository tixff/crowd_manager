package com.ti.crowd_manager.service.impl;

import com.ti.crowd_manager.domain.Advertisement;
import com.ti.crowd_manager.domain.parameter.AdvertiseParameter;
import com.ti.crowd_manager.mapper.AdvertisementMapper;
import com.ti.crowd_manager.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Ti
 * @date 2019/1/30
 */
@Service
public class AdvertiseServiceImpl implements AdvertiseService {

    @Autowired
    private AdvertisementMapper mapper;

    @Transactional
    @Override
    public void addAdvertise(Advertisement ad) {
        mapper.insert(ad);
    }

    @Override
    public HashMap<String, ArrayList> getAdvertise() {
        HashMap<String, ArrayList> admap = new HashMap<>();
        AdvertiseParameter param = new AdvertiseParameter();
        //次广告位
        param.setStatus(0);
        ArrayList<Advertisement> minorAdvertise = mapper.getAdvertise(param);
        //主广告位
        param.setStatus(1);
        ArrayList<Advertisement> mainAdvertise = mapper.getAdvertise(param);
        admap.put("minor", minorAdvertise);
        admap.put("main", mainAdvertise);
        return admap;
    }
}
