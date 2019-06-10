package com.lt.okhttp;

/**
 * Create by Lituo on 2019/6/10  23:17
 */

public interface IHttpRequest {

    void setUrl(String url);

    void setData(byte[] data);

    void setListener(CallbackListener listener);

    void excute();
}
