package com.zhongbao.weixin.utils;

import java.io.*;

public class FileUtils {

    public static String[] getAccessTokenFile() throws IOException{

        File file = new File("");
        BufferedReader reader = new BufferedReader(new FileReader(file.getCanonicalPath()+"/src/main/java/com/zhongbao/weixin/doc/accesstoken.txt"));

        String line=null;
        String str = "";
        while ((line = reader.readLine())!=null){
            str = str + line;
        }

        String[] strArray = str.split(",");
        strArray[0] = strArray[0].substring(13);
        strArray[1] = strArray[1].substring(11);
        strArray[2] = strArray[2].substring(11);
        reader.close();

        return strArray;
    }


    public static void reBuildAccessTokenFile(String access_token,String expires_in,String createtime) throws IOException{

        File file = new File("");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file.getCanonicalFile()+"/src/main/java/com/zhongbao/weixin/doc/accesstoken.txt"));
        writer.write("access_token="+access_token+",");
        writer.newLine();
        writer.write("expires_in="+expires_in+",");
        writer.newLine();
        writer.write("createtime="+createtime);
        writer.close();
        System.out.println("重建文件完毕");

    }


}
