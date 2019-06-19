package com.lt.mvp;

import android.support.v4.app.Fragment;

/**
 * Create by Lituo on 2019/6/19  20:57
 */

public abstract class MvpFragment<V extends IView, P extends IPresenter<V>> extends Fragment implements IView {

    protected P mPresenter;

    protected abstract P createPresenter();

    public P getPresenter() {
        return mPresenter;
    }
}
