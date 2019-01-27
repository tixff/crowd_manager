package com.ti.crowd_manager.service;

import com.ti.crowd_manager.domain.Item;

import java.util.ArrayList;

public interface ItemService {
    Integer addItem(Item item);

    Item findItemById(Integer id);

    Integer findIdByName(String name);

    ArrayList<Item> getAllItem();

    void deleteItemById(Integer id);

    void updateItem(Item item);
}
