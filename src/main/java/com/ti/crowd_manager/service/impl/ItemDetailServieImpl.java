package com.ti.crowd_manager.service.impl;

import com.ti.crowd_manager.domain.ItemDetail;
import com.ti.crowd_manager.domain.ItemDetailExample;
import com.ti.crowd_manager.domain.parameter.QueryParameter;
import com.ti.crowd_manager.mapper.ItemDetailMapper;
import com.ti.crowd_manager.service.ItemDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Ti
 * @date 2019/1/27
 */

@Service
public class ItemDetailServieImpl implements ItemDetailService {
    @Autowired
    private ItemDetailMapper mapper;

    @Override
    @Transactional
    public Integer addItemDetail(ItemDetail itemDetail) {
        int id = mapper.insert(itemDetail);
        return id;
    }

    @Override
    @Transactional
    public void batchRemoveItemDetail(QueryParameter parameter) {
        mapper.batchRemoveItemDetail(parameter);
    }

    @Override
    @Transactional
    public void deleteItemDetailByItemId(Integer id) {
        mapper.deleteByItemId(id);
    }

    @Override
    public ItemDetail findByItemId(Integer id) {
        ItemDetailExample example = new ItemDetailExample();
        example.createCriteria().andItemIdEqualTo(id);
        List<ItemDetail> itemDetails = mapper.selectByExampleWithBLOBs(example);
        if(itemDetails!=null&&itemDetails.size()>0){
            return itemDetails.get(0);
        }
        return null;
    }

    @Override
    @Transactional
    public void updateByItemId(ItemDetail detail) {
        mapper.updateByItemId(detail);
    }
}
