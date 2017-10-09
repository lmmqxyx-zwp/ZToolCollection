package com.by.ztc.mvc.controller;

import com.by.ztc.common.ZTC$Function;
import com.by.ztc.common.exception.ZTC$MVCException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by byvai on 2017/10/8.
 *
 * 转往ZTC主页面
 *
 * @author zwp
 *
 */
@Controller
@RequestMapping("/ztc")
public class ZtcController {


    Logger logger = Logger.getLogger(ZtcController.class);
    /**
     * 主页
     * @param request
     * @return
     * @throws ZTC$MVCException session出现null异常
     */
    @RequestMapping("/index")
    public String list(HttpServletRequest request) throws ZTC$MVCException{
        logger.info("欢迎使用ZTC系统");
        ZTC$Function.ztcSystemInfo();
        if (ZTC$Function.isObjectNull(request.getSession())) {
            throw new ZTC$MVCException("session is null 错误");// 配置文件读取
        } else {
            request.getSession().setAttribute("ztcHttp", request.getContextPath());
            request.getSession().setAttribute("ztcIcon", this.icon(request));
        }
        // ztcHttp 是用来在JSP页面使用
        // 一旦丢失、则出现异常、说明SESSION超时
        return "ztcIndex";
    }

    private String icon(HttpServletRequest request) {
        String requestUrl = request.getRequestURL().toString();
        String servletPath = request.getServletPath();
        String icon = requestUrl.substring(0, requestUrl.length() - servletPath.length());
        return icon;
    }
}
