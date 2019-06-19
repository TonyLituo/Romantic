package com.lt.app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lt.app.presenter.NormalPresenter;
import com.lt.app.view.INormaView;
import com.lt.mvp.MvpActivity;

public class MainActivity extends MvpActivity<INormaView, NormalPresenter> implements INormaView, View.OnClickListener {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = this.findViewById(R.id.tv);
        mTextView.setOnClickListener(this);
    }

    @Override
    protected NormalPresenter createPresenter() {
        return new NormalPresenter();
    }


    @Override
    public void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        mPresenter.login("zhangsan", "1234");
    }
}
