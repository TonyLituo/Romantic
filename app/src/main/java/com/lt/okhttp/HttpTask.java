package com.lt.okhttp;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;

/**
 * Create by Lituo on 2019/6/10  23:22
 */

public class HttpTask<T> implements Runnable{

    public HttpTask(String url,T requestData,IHttpRequest httpRequest,CallbackListener listener){
    httpRequest.setUrl(url);
    httpRequest.setListener(listener);
    String content= JSON.toJSONString(requestData);
        try {
            httpRequest.setData(content.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }
}
