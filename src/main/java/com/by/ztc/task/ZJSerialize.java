package com.by.ztc.task;

import com.by.ztc.common.ZTC$Constant;
import com.by.ztc.common.ZTC$SystemFunction;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by byvai on 2017/9/26.
 *
 * Java 序列化
 *
 * @author zwp
 */
public class ZJSerialize {

    public static void main(String[] args) throws Exception{
        // 1、实现序列化存储到文件，再从文件中读取出来
        // 使用 临时目录
        // 临时文件 ZjsA.out
        File zjsAFile = new File(ZTC$Constant.ZTC_TEMP_DIR + File.separator + "ZjsA.out");
        System.out.println(File.separator);
        System.out.println(zjsAFile.getPath());
        ZTC$SystemFunction._systemPropertys();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(zjsAFile));
        ZjsA zjsa = new ZjsA(1,"zjsa", new Date(), "zwp", "序列化到文件");
        oos.writeObject(zjsa);
    }

}

// zjs A 序列化对象
class ZjsA implements Serializable{

    // ZTC UID 唯一
    private static final int serialVersionUID = 0X02;

    // 唯一索引
    private Integer id;
    // 名字
    private String name;
    // 创建时间
    private Date createDate;
    // 作者
    private String author;
    // 备注
    private String remarks;

    public ZjsA() {
        System.out.println("无参构造方法");
    }

    public ZjsA(Integer id, String name, Date createDate, String author, String remarks) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.author = author;
        this.remarks = remarks;
        System.out.println("带参数的构造方法");
    }

    // -get set 方法


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "[ id : " + this.id + " , name : " + this.name + " , createDate : " + this.formatDateToString(this.createDate) + " , author : " + this.author + " , remarks : " + this.remarks + " ]";
    }

    private String formatDateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(ZTC$Constant.ZTC_FORMAT_YMD);
        return sdf.format(date);
    }
}

// 序列化
// Java平台允许我们在内存中创建可复用的Java对象，但一般情况下，只有当JVM处于运行时，
// 这些对象才可能存在，即，这些对象的生命周期不会比JVM的生命周期更长。但在现实应用中，
// 就可能要求在JVM停止运行之后能够保存(持久化)指定的对象，并在将来重新读取被保存的对象。
// Java对象序列化就能够帮助我们实现该功能。