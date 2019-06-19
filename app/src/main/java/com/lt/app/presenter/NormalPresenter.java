package com.lt.app.presenter;

import com.lt.app.view.INormaView;
import com.lt.mvp.MvpPresenter;

/**
 * Create by Lituo on 2019/6/19  23:52
 */

public class NormalPresenter extends MvpPresenter<INormaView> {


    public void login(String username, String pwd) {
        String content = "login:" + username + "," + pwd;
        getView().showToast(content);
    }
}
