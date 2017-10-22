package com.by.ztc.mvc.controller.app;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * app 使用的接口
 *
 * @author zwp
 */
@Controller
@RequestMapping("/ztcApp")
public class AppController {


    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public void uploadImage(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(4*1024);
        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setSizeMax(100*1024*1024);
        String suffixatt;

        List<FileItem> itemList;

        // 创建上传临时目录
        String uploadPath = "E:/temp/android/uploadImage/";
        File dir = new File(uploadPath);

        try {

            if (!dir.exists()) {
                dir.mkdirs();
            }
            itemList = upload.parseRequest(request);

            for (FileItem item: itemList
                 ) {
                System.out.println(item.getFieldName());
                // 上传文件
                String fileName = item.getName(); //图片的名字
                InputStream in = item.getInputStream();
                File file = new File(dir + "/" + fileName);
                FileOutputStream fos = new FileOutputStream(file);
                int _byte;
                while((_byte=in.read()) != -1) {
                    fos.write(_byte);
                }

                fos.flush();
                fos.close();
                in.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        System.out.println("GET");
    }

}
