package com.lt.mvp;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

/**
 * Create by Lituo on 2019/6/19  20:56
 */

public class MvpPresenter<V extends IView> implements IPresenter<V> {

    //view 接口软引用
    protected Reference<V> mViewRef;

    @Override
    public void attachView(V view) {
        mViewRef = new SoftReference<V>(view);
    }


    public V getView() {
        return null == mViewRef ? null : mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    @Override
    public void detachView() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
        }

    }
}
