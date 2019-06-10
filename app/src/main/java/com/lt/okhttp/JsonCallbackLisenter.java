package com.lt.okhttp;

import android.os.Handler;
import android.os.Looper;

import java.io.InputStream;

/**
 * Create by Lituo on 2019/6/10  23:58
 */

public class JsonCallbackLisenter<T> implements CallbackListener {

    private Class<T> responseClass;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    private IJosnDataListener mJosnDataListener;

    public JsonCallbackLisenter(Class<T> responseClass,IJosnDataListener iJosnDataListener) {
        this.responseClass = responseClass;
        this.mJosnDataListener=iJosnDataListener;
    }

    @Override
    public void onSuccess(InputStream inputStream) {
//将流转化为对象

    }

    @Override
    public void onFailure() {

    }
}
