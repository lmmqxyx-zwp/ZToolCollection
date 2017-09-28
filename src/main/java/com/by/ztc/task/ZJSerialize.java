package com.by.ztc.task;

import com.by.ztc.common.ZTC$Constant;
import com.by.ztc.common.ZTC$SystemFunction;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by byvai on 2017/9/26.
 *
 * Java 序列化 不允许被序列化的字段 关键字transient
 * 用例：序列化与反序列化实验
 * 状态：《实验结束》
 *
 * ZjsA 实现了Serialize接口，可以被序列化、反序列化
 * ZjsB 没有实现Serialize接口，不能被序列化、反序列化
 *
 * 序列化的作用：
 * 
 *
 * @author zwp
 */
public class ZJSerialize {

    public static void main(String[] args) throws Exception{
        // 1、实现序列化存储到文件，再从文件中读取出来
        // 使用 临时目录
        // 临时文件 ZjsA.out
        String fileName = ZTC$SystemFunction._getJVMSystemPropertiesValue(
                ZTC$Constant.USER_DIR) + ZTC$Constant.ZTC_TEMP_DIR
                + File.separator + "ZjsA.out";
        File zjsAFile = new File(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(zjsAFile));
        ZjsA zjsa = new ZjsA(1,"zjsa", new Date(), "zwp", "序列化到文件");
        oos.writeObject(zjsa);
        // 编译之后 ZjsA.class 3kb
        // 序列化之后 ZjsA.out 1kb

/*        // 下面序列化的对象并没有实现Serializable接口
        fileName = ZTC$SystemFunction._getJVMSystemPropertiesValue(
                ZTC$Constant.USER_DIR) + ZTC$Constant.ZTC_TEMP_DIR
                + File.separator + "ZjsB.out";
        File zjsBFile = new File(fileName);
        ZjsB zjsb = new ZjsB(1,"zjsb", new Date(), "zwp", "序列化到文件");
        oos.writeObject(zjsb);
        //Exception in thread "main" java.io.NotSerializableException: com.by.ztc.task.ZjsB
        //at java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1184)
        //at java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:348)
        //at com.by.ztc.task.ZJSerialize.main(ZJSerialize.java:39)
*/
        // 不实现Serializable接口不能被序列化

        //反序列化得到对象
        System.out.println(ZTC$Constant.ZTC_PARTING_LINE);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(zjsAFile));
        Object o = ois.readObject();
        System.out.println(o.getClass());
        System.out.println(o);
        System.out.println(((ZjsA)o).getName());
        System.out.println(((ZjsA)o).getRemarks()); // 得到null

        // 以上 《结束》
        // 用处：用文件来存储对象 此对象1kb
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
    // 备注 若有敏感信息不允许序列化 则使用transient修饰
    private transient String remarks;

    public ZjsA() {
        System.out.println("无参构造方法 ZjsA");
    }

    public ZjsA(Integer id, String name, Date createDate, String author, String remarks) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.author = author;
        this.remarks = remarks;
        System.out.println("带参数的构造方法 ZjsA");
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

class ZjsB {

    // ZTC UID 唯一
    //private static final int serialVersionUID = 0X03;

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

    public ZjsB() {
        System.out.println("无参构造方法 ZjsB");
    }

    public ZjsB(Integer id, String name, Date createDate, String author, String remarks) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.author = author;
        this.remarks = remarks;
        System.out.println("带参数的构造方法 ZjsB");
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