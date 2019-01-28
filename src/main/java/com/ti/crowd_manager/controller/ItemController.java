package com.ti.crowd_manager.controller;

import com.ti.crowd_manager.domain.Item;
import com.ti.crowd_manager.domain.ItemDetail;
import com.ti.crowd_manager.domain.parameter.QueryParameter;
import com.ti.crowd_manager.result.ResultData;
import com.ti.crowd_manager.service.ItemDetailService;
import com.ti.crowd_manager.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author Ti
 * @date 2019/1/24
 */

@RestController
@RequestMapping("/item")
public class ItemController {
    private static Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService service;

    @Autowired
    private ItemDetailService itemDetailService;


    @PostMapping("add")
    public Object addItem(Item item, String itemDetail) {
        ResultData resultData = ResultData.createResultData();
        item.setCreateTime(new Date());
        ItemDetail detail = new ItemDetail();
        detail.setContent(itemDetail);
        try {
            service.addItem(item);
            Integer itemId = service.findIdByName(item.getName());
            detail.setItemId(itemId);
            itemDetailService.addItemDetail(detail);
            resultData.setMessage("添加成功");
        } catch (Exception e) {
            resultData.setMessage("添加失败");
            logger.info("添加失败：{}", e.getStackTrace());
        }
        return resultData;
    }

    @GetMapping("find")
    public ResultData findItemById(Integer id) {
        ResultData resultData = ResultData.createResultData();
        try {
            Item item = service.findItemById(id);
            resultData.setMessage("查找成功");
            resultData.setData(item);
            resultData.setStatus(ResultData.SUCCESS);
        } catch (Exception e) {
            resultData.setMessage("查找失败");
            logger.info("查找失败：{}", e.getStackTrace());
        }
        return resultData;
    }

    @GetMapping("delete")
    public ResultData deleteItemById(Integer id) {
        ResultData resultData = ResultData.createResultData();
        try {
            service.deleteItemById(id);
            itemDetailService.deleteItemDetailByItemId(id);
            resultData.setMessage("删除成功");
            resultData.setStatus(ResultData.SUCCESS);
        } catch (Exception e) {
            resultData.setMessage("删除失败");
            resultData.setStatus(ResultData.FAIL);
        }
        return resultData;
    }

    @PostMapping("update")
    public ResultData updateItem(Item item) {
        ResultData resultData = ResultData.createResultData();
        ItemDetail detail = new ItemDetail();
        try {
            service.updateItem(item);
            detail.setItemId(item.getId());
            detail.setContent(item.getItemDetail());
            itemDetailService.updateByItemId(detail);
            resultData.setMessage("更新成功");
        } catch (Exception e) {
            resultData.setMessage("更新失败");
        }
        return resultData;
    }

    @PostMapping("batchRemove")
    public ResultData batchRemove(@RequestParam(value = "ids[]") Integer[] ids) {

        ResultData resultData = ResultData.createResultData();
        if (ids == null) {
            resultData.setMessage("批量删除失败");
            return resultData;
        }
        QueryParameter param = new QueryParameter();
        param.setIds(ids);
        try {
            service.bathRemoveItem(param);
            itemDetailService.batchRemoveItemDetail(param);
            resultData.setMessage("批量删除成功");
            resultData.setStatus(ResultData.SUCCESS);
        } catch (Exception e) {
            resultData.setMessage("批量删除失败");
            resultData.setStatus(ResultData.FAIL);
        }

        return resultData;
    }
}
