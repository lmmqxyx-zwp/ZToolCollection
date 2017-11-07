package com.by.ztc.mvc.controller.home;

import org.apache.commons.net.util.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;

/**
 * 用来测试小功能的Controller
 *
 * @author zwp
 */

@Controller
@RequestMapping("/testFunction")
public class TestFunctionController {

    /**
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {

        System.out.println("1111");

        return "home/testFunction/testFunctionIndex";
    }

    /**
     * @return
     */
    @RequestMapping(value = "html2canvas", method = RequestMethod.GET)
    public String html2canvas(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "home/testFunction/html2canvas";
    }

    @RequestMapping(value = "ctxImage", method = RequestMethod.POST)
    public String ctxImage(HttpServletRequest request, HttpServletResponse response, Model model) {

        String serverPath = request.getSession().getServletContext().getRealPath("/");
        serverPath = "E:\\gitClient\\ZToolCollection\\src\\main\\resources\\ztctemp\\";
        Base64 base64 = new Base64();
        try {

            String data = request.getParameter("data");

            //注意点：实际的图片数据是从 data:image/jpeg;base64, 后开始的
            byte[] k = base64.decode(data.substring("data:image/jpeg;base64,"
                    .length()));
            InputStream is = new ByteArrayInputStream(k);
            String fileName = UUID.randomUUID().toString();
//            String imgFilePath = serverPath + "\\static\\usertemp\\" + fileName + ".jpg";
            String imgFilePath = serverPath + fileName + ".jpg";

            //以下其实可以忽略，将图片压缩处理了一下，可以小一点

            double ratio = 1.0;
            BufferedImage image = ImageIO.read(is);
            int newWidth = (int) (image.getWidth() * ratio);
            int newHeight = (int) (image.getHeight() * ratio);
            Image newimage = image.getScaledInstance(newWidth, newHeight,
                    Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(newWidth, newHeight,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(newimage, 0, 0, null);
            g.dispose();
            ImageIO.write(tag, "jpg", new File(imgFilePath));
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

}
