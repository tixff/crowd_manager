package com.ti.crowd_manager.service;

import com.ti.crowd_manager.domain.ItemCat;
import com.ti.crowd_manager.domain.parameter.ItemCateParameter;
import com.ti.crowd_manager.result.ItemCatTreeNode;

import java.util.ArrayList;

/**
 * @author Ti
 * @date 2019/1/26
 */
public interface ItemCatService {
    ArrayList<ItemCatTreeNode> getAllItemCat();

    void addItemCat(ItemCateParameter param);

    ItemCat findItemCatById(Integer id);

    void updateItemCat(ItemCat itemCat);
}
