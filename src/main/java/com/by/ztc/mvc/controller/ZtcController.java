package com.by.ztc.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by byvai on 2017/10/8.
 */
@Controller
@RequestMapping("/ztc")
public class ZtcController {

    @RequestMapping("/index")
    public String list(HttpServletRequest request){
        request.getSession().setAttribute("ztcHttp", request.getContextPath());
        return "ztcIndex";
    }

}
