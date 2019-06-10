package com.lt.okhttp;

import java.io.InputStream;

/**
 * Create by Lituo on 2019/6/10  23:20
 */

public interface CallbackListener {

    void onSuccess(InputStream inputStream);

    void onFailure();

}
