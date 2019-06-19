package com.lt.mvp;

import android.support.annotation.UiThread;

/**
 * Create by Lituo on 2019/6/19  20:53
 */

public interface IPresenter<V extends IView> {
    /**
     * set or attach the view to this presenter
     * @param view
     */
    @UiThread
    void attachView(V view);

    /**
     * Will be called is the view has been destoryed.Typically this moethod will be invked from
     * <code> Activity.detachView()  or  Fragment.onDesroyView()<code/>
     */
    @UiThread
    void detachView();

}
