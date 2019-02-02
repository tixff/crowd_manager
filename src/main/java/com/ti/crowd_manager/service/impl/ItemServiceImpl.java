package com.ti.crowd_manager.service.impl;

import com.ti.crowd_manager.domain.Item;
import com.ti.crowd_manager.domain.ItemExample;
import com.ti.crowd_manager.domain.User;
import com.ti.crowd_manager.domain.UserExample;
import com.ti.crowd_manager.domain.parameter.PageQuery;
import com.ti.crowd_manager.domain.parameter.QueryParameter;
import com.ti.crowd_manager.mapper.ItemMapper;
import com.ti.crowd_manager.mapper.UserMapper;
import com.ti.crowd_manager.result.PageResult;
import com.ti.crowd_manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
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
    @Transactional
    public void deleteItemById(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void updateItem(Item item) {
        mapper.updateByPrimaryKey(item);
    }

    @Override
    public PageResult<Item> getItemPage(PageQuery query) {
        PageResult<Item> pageResult = new PageResult<>();
        QueryParameter param = new QueryParameter();
        long start = (query.getCurrentPage() - 1) * query.getRows();
        long end = query.getRows();
        param.setStart(start);
        param.setEnd(end);
        ItemExample itemExample = new ItemExample();
        long totalCount = mapper.countByExample(itemExample);
        ArrayList<Item> items = mapper.selectByLimit(param);

        pageResult.setCurrentPage(query.getCurrentPage());
        pageResult.setTotalCount(totalCount);
        pageResult.setData(items);
        long totalPage = (totalCount % query.getRows()) > 0 ? totalCount / query.getRows() + 1 : totalCount / query.getRows();
        pageResult.setTotalPage(totalPage);

        return pageResult;
    }

    @Override
    @Transactional
    public void bathRemoveItem(QueryParameter parameter) {
        mapper.deleteItemByIds(parameter);
    }

    @Transactional
    @Override
    public int updateItemCurrentMoneyAndContibuteNum(Item item) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(item.getUserName());
        List<User> userList = userMapper.selectByExample(example);
        if(userList!=null&&userList.size()>0){
            User user = userList.get(0);
            user.setMoney(user.getMoney()-item.getCurrentMoney());
            userMapper.updateByPrimaryKey(user);
            mapper.updateItemMoney(item);
            return 1;
        }else {
            return 0;
        }
    }
}
