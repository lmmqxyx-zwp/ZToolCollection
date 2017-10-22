package com.by.ztc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static final String ZTC_PARTING_LINE = "ZTC $ --- $ --- $ --- $ --- $ --- $ --- $ CTZ";

    public static void main(String[] args) {
//        systemEnv();
        testStringToIO();

    }

    // System ENV
    // windows 下使用： set 变量名=变量值 是不行的，读取的还是环境变量中设置的值
    // TODO linux下 用export命令导入《未尝试》
    public static void systemEnv() {
        Map<String,String> m = System.getenv();
        Set<String> s = m.keySet();
        for (String k: s
             ) {
            System.out.println(k + " - " + m.get(k));
        }
        System.out.println("count - " + m.size());
        System.out.println(ZTC_PARTING_LINE);
    }

    /**
     * 字符串转流
     */
    public static void testStringToIO() {
        String str = "testString";
        ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
        System.out.println(bais);
    }

}


class GrabMobile{
    public String grabMobileLocation(String m)throws Exception{
        String strUrl = "http://www.ip138.com:8080/search.asp?action=mobile&mobile=" + m;
        URL url = new URL(strUrl) ;
        HttpURLConnection httpUrlCon = (HttpURLConnection)url.openConnection() ;
        InputStreamReader inRead = new InputStreamReader(httpUrlCon.getInputStream(),"GBK") ;
        BufferedReader bufRead = new BufferedReader(inRead) ;
        StringBuffer strBuf = new StringBuffer() ;
        String line = "" ;
        while ((line = bufRead.readLine()) != null) {
            strBuf.append(line);
        }
        String strStart = "卡号归属地" ;
        String strEnd = "卡 类 型";
        String strAll = strBuf.toString() ;

        int start = strAll.indexOf(strStart) ;

        int end = strAll.indexOf(strEnd) ;

        String result = strAll.substring(start+42,end-33) ;
        result = drawChMob(result) ;
        return result ;
    }
    public String grabMobileType(String m)throws Exception{
        String strUrl = "http://www.ip138.com:8080/search.asp?action=mobile&mobile=" + m;
        URL url = new URL(strUrl) ;
        HttpURLConnection httpUrlCon = (HttpURLConnection)url.openConnection() ;
        InputStreamReader inRead = new InputStreamReader(httpUrlCon.getInputStream(),"GBK") ;
        BufferedReader bufRead = new BufferedReader(inRead) ;
        StringBuffer strBuf = new StringBuffer() ;
        String line = "" ;
        while ((line = bufRead.readLine()) != null) {
            strBuf.append(line);
        }
        String strStart = "卡 类 型" ;
        String strEnd = "<TD align=\"center\">区 号</TD>";
        String strAll = strBuf.toString() ;

        int start = strAll.indexOf(strStart) ;

        int end = strAll.indexOf(strEnd) ;

        String result = strAll.substring(start+12,end) ;
        result = drawChMob(result) ;
        result = result.substring(1) ;
        return result ;
    }
    public String grabMobilePost(String m)throws Exception{
        String strUrl = "http://www.ip138.com:8080/search.asp?action=mobile&mobile=" + m;
        URL url = new URL(strUrl) ;
        HttpURLConnection httpUrlCon = (HttpURLConnection)url.openConnection() ;
        InputStreamReader inRead = new InputStreamReader(httpUrlCon.getInputStream(),"GBK") ;
        BufferedReader bufRead = new BufferedReader(inRead) ;
        StringBuffer strBuf = new StringBuffer() ;
        String line = "" ;
        while ((line = bufRead.readLine()) != null) {
            strBuf.append(line);
        }
        String strStart = "邮 编" ;
        String strEnd = "更详细的..";
        String strAll = strBuf.toString() ;

        int start = strAll.indexOf(strStart) ;

        int end = strAll.indexOf(strEnd) ;

        String result = strAll.substring(start+40,end-55) ;
        return result ;
    }
    public String drawChMob(String str){
        StringBuffer strBuf = new StringBuffer() ;
        String regex="([\u4e00-\u9fa5]+)";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        while(matcher.find()){
            strBuf.append(matcher.group(0)).toString() ;
        }
        return strBuf.toString() ;
    }
}