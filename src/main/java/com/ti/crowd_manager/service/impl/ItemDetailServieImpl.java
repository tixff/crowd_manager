package com.ti.crowd_manager.service.impl;

import com.ti.crowd_manager.domain.ItemDetail;
import com.ti.crowd_manager.mapper.ItemDetailMapper;
import com.ti.crowd_manager.service.ItemDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ti
 * @date 2019/1/27
 */

@Service
public class ItemDetailServieImpl implements ItemDetailService {
    @Autowired
    private ItemDetailMapper mapper;

    @Override
    public Integer addItemDetail(ItemDetail itemDetail) {
        int id = mapper.insert(itemDetail);
        return id;
    }
}
