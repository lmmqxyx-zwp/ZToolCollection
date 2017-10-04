package com.by.ztc.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by byvai on 2017/10/4.
 */
@Controller
@RequestMapping("/ztc/ztcHome")
public class HomeController {

    @RequestMapping(value = "ztcHomeIndex", method = RequestMethod.GET)
    public String ztcHomeIndex() {
        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println(c);
        return "home/ztcHomeIndex";
    }


}
