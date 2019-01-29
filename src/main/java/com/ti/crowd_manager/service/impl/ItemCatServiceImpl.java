package com.ti.crowd_manager.service.impl;

import com.ti.crowd_manager.domain.ItemCat;
import com.ti.crowd_manager.domain.ItemCatExample;
import com.ti.crowd_manager.domain.parameter.ItemCateParameter;
import com.ti.crowd_manager.mapper.ItemCatMapper;
import com.ti.crowd_manager.result.ItemCatTreeNode;
import com.ti.crowd_manager.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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

    @Transactional
    @Override
    public void addItemCat(ItemCateParameter param) {
        if (ItemCateParameter.SON_LEVEL.equals(param.getAddway())) {
            ItemCat parent = mapper.selectByPrimaryKey(param.getParentId());
            if (parent.getIsParent() == 0) {
                parent.setIsParent(1);
                mapper.updateByPrimaryKey(parent);
            }
            mapper.insert(param);
        }

        if (ItemCateParameter.SAME_LEVEL.equals(param.getAddway())) {
            Integer id = param.getParentId();
            ItemCat currentLevle = mapper.selectByPrimaryKey(id);
            Integer parentId = currentLevle.getParentId();
            param.setParentId(parentId);
            mapper.insert(param);
        }
    }

    @Override
    public ItemCat findItemCatById(Integer id) {
        ItemCat itemCat = mapper.selectByPrimaryKey(id);
        return itemCat;
    }

    @Transactional
    @Override
    public void updateItemCat(ItemCat itemCat) {
        if (itemCat.getName() == null) {//删除操作
            Integer id = itemCat.getId();
            ItemCatExample example = new ItemCatExample();
            example.createCriteria().andParentIdEqualTo(id);
            //删除子类目
            mapper.deleteByExample(example);

            //获得当前类目
            ItemCat currentItemCat = mapper.selectByPrimaryKey(id);
            Integer parentId = currentItemCat.getParentId();

            //删除当前类目
            mapper.deleteByPrimaryKey(id);

            //查找删除类目的同级类目
            ItemCatExample itemCatExample = new ItemCatExample();
            itemCatExample.createCriteria().andParentIdEqualTo(parentId);
            List<ItemCat> itemCats = mapper.selectByExample(itemCatExample);

            //如果没有兄弟类目  修改父类目的isParent属性为0
            if (itemCats == null || itemCats.size() < 1) {
                ItemCat parentItemCat = mapper.selectByPrimaryKey(parentId);
                parentItemCat.setIsParent(0);
                parentItemCat.setUpdateTime(new Date());
                mapper.updateByPrimaryKey(parentItemCat);
            }

        } else {//修改操作
            mapper.updateById(itemCat);
        }
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
