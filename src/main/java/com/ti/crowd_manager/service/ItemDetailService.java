package com.ti.crowd_manager.service;

import com.ti.crowd_manager.domain.ItemDetail;
import com.ti.crowd_manager.domain.parameter.QueryParameter;

/**
 * @author Ti
 * @date 2019/1/27
 */
public interface ItemDetailService {
    Integer addItemDetail(ItemDetail itemDetail);

    void batchRemoveItemDetail(QueryParameter parameter);

    void deleteItemDetailByItemId(Integer id);

    ItemDetail findByItemId(Integer id);

    void updateByItemId(ItemDetail detail);
}
