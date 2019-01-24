package com.ti.crowd_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ti
 * @date 2019/1/24
 */
@Controller
public class ViewController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/welcome.html")
    public String welcome(){
        return "welcome";
    }
}
