package com.ti.crowd_manager.controller;

import com.ti.crowd_manager.domain.ItemCat;
import com.ti.crowd_manager.domain.parameter.ItemCateParameter;
import com.ti.crowd_manager.result.ItemCatTreeNode;
import com.ti.crowd_manager.result.ResultData;
import com.ti.crowd_manager.service.ItemCatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Ti
 * @date 2019/1/26
 */


@RestController
@RequestMapping("/itemCat")
@Api(value = "类目管理", tags = "类目管理")
public class ItemCatController {

    @Autowired
    private ItemCatService service;

    @ApiOperation(value = "树形结构类目", notes = "树形结构类目")
    @GetMapping("all")
    public ArrayList<ItemCatTreeNode> getTreeItemCat() {
        ArrayList<ItemCatTreeNode> allItemCat = service.getAllItemCat();
        return allItemCat;
    }

    @PostMapping("add")
    public ResultData addItemCat(ItemCateParameter param) {
        ResultData resultData = ResultData.createResultData();
        param.setCreateTime(new Date());
        param.setIsParent(0);
        param.setStatus(0);
        try {
            service.addItemCat(param);
            resultData.setMessage("添加成功");
        } catch (Exception e) {
            resultData.setMessage("添加失败");
        }

        return resultData;
    }

    @PostMapping("update")
    public ResultData updateItemCat(ItemCat itemCat) {
        ResultData resultData = ResultData.createResultData();
        itemCat.setUpdateTime(new Date());
        try {
            service.updateItemCat(itemCat);
            resultData.setMessage("更新类目成功");
        } catch (Exception e) {
            resultData.setMessage("更新类目失败");
        }

        return resultData;
    }
}
