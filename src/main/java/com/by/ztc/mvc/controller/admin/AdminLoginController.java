package com.by.ztc.mvc.controller.admin;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by byvai on 2017/10/4.
 *
 * 登录Controller
 * 实现 Spring MVC ■
 *
 * @author zwp
 */
@Controller
@RequestMapping("/ztcAdmin")
public class AdminLoginController {

    Logger logger = Logger.getLogger(AdminLoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String ztcHomeIndex() {
        logger.info("ZTC | 后台主页");
        return "admin/login";
    }

}
