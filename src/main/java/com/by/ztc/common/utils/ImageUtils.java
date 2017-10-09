package com.by.ztc.common.utils;

import com.by.ztc.common.exception.ZTC$UtilsException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

// 此类属于jdk自带、但是在eclipse中不能正常导入
// 配置修改：右键项目->properties->java bulid path->libraries->jre System Library->access rules->resolution选择accessible，下面填上** 点击确定即可！！！

/**
 * 图像处理工具类
 *
 * @author zwp
 */
public class ImageUtils {

    public static BASE64Encoder encoder = new BASE64Encoder();
    public static BASE64Decoder decoder = new BASE64Decoder();

    /**
     * 图片转换成二进制
     *
     * @param o             图片对象 类型：文件 | 文件路径
     * @param imageFormater 图片格式化 示例： "jpg"、"png"...
     * @return 二进制数组
     */
    public static byte[] imageToBinary(Object o, String imageFormater) throws ZTC$UtilsException {
        File imageFile = null;
        if (o instanceof String) {
            imageFile = new File((String) o);
        } else if (o instanceof File) {
            imageFile = (File) o;
        } else {
            throw new ZTC$UtilsException("参数o传递有误");
        }

        BufferedImage bi;
        byte[] b = null;
        try {
            bi = ImageIO.read(imageFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, imageFormater, baos);
            b = baos.toByteArray();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return b;
    }

    /**
     * 二进制转换成图片
     *
     * @param b 图片二进制数组
     * @param path 输出文件路径
     * @param imageFormater 图片格式化 示例： "jpg"、"png"...
     * @return 图片对象
     */
    public static void binaryToImage(byte[] b, String path, String imageFormater) {
        String base64String = new String(b);
        try {
            byte[] temp = decoder.decodeBuffer(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(temp);
            BufferedImage bi = ImageIO.read(bais);
            File image = new File(path);
            ImageIO.write(bi, imageFormater, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
