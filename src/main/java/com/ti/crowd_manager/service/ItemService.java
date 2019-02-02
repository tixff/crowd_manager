package com.ti.crowd_manager.service;

import com.ti.crowd_manager.domain.Item;
import com.ti.crowd_manager.domain.parameter.PageQuery;
import com.ti.crowd_manager.domain.parameter.QueryParameter;
import com.ti.crowd_manager.result.PageResult;

import java.util.ArrayList;

public interface ItemService {
    Integer addItem(Item item);

    Item findItemById(Integer id);

    Integer findIdByName(String name);

    ArrayList<Item> getAllItem();

    void deleteItemById(Integer id);

    void updateItem(Item item);

    PageResult<Item> getItemPage(PageQuery query);

    void bathRemoveItem(QueryParameter parameter);

    Item updateItemCurrentMoneyAndContibuteNum(Item item);
}
