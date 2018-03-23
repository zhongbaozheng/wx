package com.zhongbao.weixin.utils;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.util.Arrays;

public class CheckUtils {

    private static final String token ="mytoken";

    public static boolean checkSignature(String signature,String timestamp,String nonce){

        String array[] = new String[]{token,timestamp,nonce};
        //排序
        Arrays.sort(array);

        //生成字符串
        StringBuffer content = new StringBuffer();
        for(int i=0;i<array.length;i++){
            content.append(array[i]);
        }

        //sha1加密
        String tempStr = getSha1(content.toString());

        return tempStr.equals(signature);

    }

    public static String getSha1(String str){
        if(str==null||str.length()==0){
            return null;
        }
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j*2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            // TODO: handle exception
            return e.getMessage();
        }
    }

}
