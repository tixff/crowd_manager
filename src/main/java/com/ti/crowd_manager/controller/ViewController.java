package com.ti.crowd_manager.controller;

import com.ti.crowd_manager.domain.Item;
import com.ti.crowd_manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * @author Ti
 * @date 2019/1/24
 */
@Controller
public class ViewController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/welcome.html")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/project-list.html")
    public String itemList(Model model) {
        ArrayList<Item> items = itemService.getAllItem();
        model.addAttribute("items",items);
        return "project-list";
    }

    @GetMapping("/project-edit.html")
    public String updateItem(Model model,Integer id){
        Item item = itemService.findItemById(id);
        item.setImage("/static/"+item.getImage());
        item.setLinkmanQrCode("/static/"+item.getLinkmanQrCode());
        model.addAttribute("item",item);
        return "project-edit";
    }
}
