package com.ti.crowd_manager.controller;

import com.ti.crowd_manager.result.ItemCatTreeNode;
import com.ti.crowd_manager.service.ItemCatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Ti
 * @date 2019/1/26
 */


@RestController
@RequestMapping("/itemCat")
@Api(value = "类目管理",tags = "类目管理")
public class ItemCatController {

    @Autowired
    private ItemCatService service;

    @ApiOperation(value = "树形结构类目",notes = "树形结构类目")
    @GetMapping("all")
    public ArrayList<ItemCatTreeNode> getTreeItemCat() {
        ArrayList<ItemCatTreeNode> allItemCat = service.getAllItemCat();
        return allItemCat;
    }
}
