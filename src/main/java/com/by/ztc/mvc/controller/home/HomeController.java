package com.by.ztc.mvc.controller.home;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by byvai on 2017/10/4.
 */
@Controller
@RequestMapping("/ztcHome")
public class HomeController {

    Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String ztcHomeIndex() {
        logger.info("ZTC | 前台主页");
        return "home/index";
    }


}
