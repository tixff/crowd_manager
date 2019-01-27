package com.ti.crowd_manager.service.impl;

import com.ti.crowd_manager.domain.Item;
import com.ti.crowd_manager.domain.ItemExample;
import com.ti.crowd_manager.mapper.ItemMapper;
import com.ti.crowd_manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ti
 * @date 2019/1/24
 */

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper mapper;

    @Override
    public Integer addItem(Item item) {
        int id = mapper.insert(item);
        return id;
    }

    @Override
    public Item findItemById(Integer id) {
        Item item = mapper.selectByPrimaryKey(id);
        return item;
    }

    @Override
    public Integer findIdByName(String name) {
        int id = mapper.selectIdByName(name);
        return id;
    }

    @Override
    public ArrayList<Item> getAllItem() {
        List<Item> items = mapper.selectByExample(new ItemExample());
        return (ArrayList<Item>) items;
    }

    @Override
    public void deleteItemById(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateItem(Item item) {
        mapper.updateByPrimaryKey(item);
    }
}
