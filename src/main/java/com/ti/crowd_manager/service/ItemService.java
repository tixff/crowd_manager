package com.ti.crowd_manager.service;

import com.ti.crowd_manager.domain.Item;

public interface ItemService {
    Integer addItem(Item item);

    Item findItemById(Integer id);

    Integer findIdByName(String name);
}
