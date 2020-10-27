package com.yhong.asframe.activity;

import android.os.Bundle;

import com.yhong.asframe.R;
import com.yhong.asframe.base.BaseActivity;

import cn.yhong.aframework.titlebar.BaseTitlebar;
import cn.yhong.aframework.titlebar.DefaultTitlebar;

/**
 * Activity常用方法封装
 */
public class AtyUtilsActivity extends BaseActivity {

    @Override
    public BaseTitlebar initTitlebar() {
        return new DefaultTitlebar.Builder(this).setTitle("AtyUtils")
                .setBackImage(R.drawable.back_white).create();
    }

    @Override
    public void initContent(Bundle savedInstanceState) {
        setContent(R.layout.activity_aty_utils);
    }

    @Override
    public void initData() {

    }
}
