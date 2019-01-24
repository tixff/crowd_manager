package com.ti.crowd_manager.service.impl;

import com.ti.crowd_manager.domain.ItemCat;
import com.ti.crowd_manager.domain.ItemCatExample;
import com.ti.crowd_manager.mapper.ItemCatMapper;
import com.ti.crowd_manager.result.ItemCatTreeNode;
import com.ti.crowd_manager.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ti
 * @date 2019/1/26
 */

@Service
public class ItemCatServiceImpl implements ItemCatService {
    private static Logger logger = LoggerFactory.getLogger(ItemCatServiceImpl.class);

    @Autowired
    private ItemCatMapper mapper;

    @Override
    public ArrayList<ItemCatTreeNode> getAllItemCat() {
        List<ItemCat> itemCats = mapper.selectByExample(new ItemCatExample());
        ArrayList<ItemCatTreeNode> itemCatTreeNodes = toFormatTreeDept(itemCats);
        return itemCatTreeNodes;
    }

    @Override
    public Integer addItemCat(ItemCat itemCat) {
        int itemcatId = mapper.insert(itemCat);
        return itemcatId;
    }

    private ArrayList<ItemCatTreeNode> toFormatTreeDept(List<ItemCat> list) {
        if (list == null || list.size() < 1) {
            return null;
        }
        ArrayList<ItemCat> treeList = new ArrayList<>();
        //获取所有的一级部门
        list.forEach(o -> {
            if (o.getParentId() == 0) {
                treeList.add(o);
            }
        });
        ArrayList<ItemCatTreeNode> depts = new ArrayList<>();
        treeNode(treeList, list, depts);
        return depts;
    }

    private void treeNode(ArrayList<ItemCat> nodes, List<ItemCat> list, ArrayList<ItemCatTreeNode> rootDepts) {
        if (nodes == null || nodes.size() < 1) {
            return;
        }

        for (int i = 0; i < nodes.size(); i++) {
            ItemCat node = nodes.get(i);
            ItemCatTreeNode itemCatTreeNode = new ItemCatTreeNode();
            if (node.getIsParent() != 1) {
                itemCatTreeNode.setText(node.getName());
                itemCatTreeNode.setId(node.getId());
                rootDepts.add(itemCatTreeNode);
                continue;
            }


            Integer id = node.getId();
            itemCatTreeNode.setText(node.getName());
            itemCatTreeNode.setId(id);
            ArrayList<ItemCatTreeNode> children = new ArrayList<>();
            ArrayList<ItemCat> sonList = new ArrayList<>();
            list.forEach(o -> {
                if (o.getParentId() == id) {
                    sonList.add(o);
                }
            });
            itemCatTreeNode.setChildren(children);
            rootDepts.add(itemCatTreeNode);
            treeNode(sonList, list, children);
        }
    }
}
