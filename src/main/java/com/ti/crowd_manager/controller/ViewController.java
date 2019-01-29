package com.ti.crowd_manager.controller;

import com.ti.crowd_manager.domain.Item;
import com.ti.crowd_manager.domain.ItemCat;
import com.ti.crowd_manager.domain.ItemDetail;
import com.ti.crowd_manager.domain.parameter.PageQuery;
import com.ti.crowd_manager.result.PageResult;
import com.ti.crowd_manager.service.ItemCatService;
import com.ti.crowd_manager.service.ItemDetailService;
import com.ti.crowd_manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ti
 * @date 2019/1/24
 */
@Controller
public class ViewController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemDetailService itemDetailService;

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/welcome.html")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/project-list.html")
    public String itemList(Model model, PageQuery query) {
        PageResult<Item> itemPage = itemService.getItemPage(query);
        model.addAttribute("itemPage", itemPage);
        return "project-list";
    }

    @GetMapping("/project-edit.html")
    public String updateItem(Model model, Integer id) {
        Item item = itemService.findItemById(id);
        ItemDetail itemDetail = itemDetailService.findByItemId(id);
        if (itemDetail != null) {
            item.setItemDetail(itemDetail.getContent());
        }
        model.addAttribute("item", item);
        return "project-edit";
    }

    @GetMapping("/cate-add.html")
    public String getItemCat(Model model, Integer id) {
        ItemCat itemCat = itemCatService.findItemCatById(id);
        model.addAttribute("itemCat", itemCat);
        return "cate-add";
    }

    @GetMapping("/cate-update.html")
    public String updateItemCat(Model model, Integer id) {
        ItemCat itemCat = itemCatService.findItemCatById(id);
        model.addAttribute("itemCat", itemCat);
        return "cate-update";
    }
}
