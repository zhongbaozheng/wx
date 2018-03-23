package com.zhongbao.weixin.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;

public class HttpUtils {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    //get请求，请求url
    public static String doGet(String url) throws IOException{

        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {

            return response.body().string();
        }
    }

    //post请求，提交url和json
    public static String doPost(String url, String json) throws IOException {

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    /**
     * 字符串转化为JSONObject
     * @param jsonStr
     * @return
     */
    public static JSONObject getJsonObject(String jsonStr){

        JSONObject jsonObject = com.alibaba.fastjson.JSON.parseObject(jsonStr);
        return jsonObject;
    }


}
