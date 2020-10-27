package com.yhong.asframe.activity;

import android.os.Bundle;

import com.yhong.asframe.R;
import com.yhong.asframe.base.BaseActivity;

import cn.yhong.aframework.titlebar.BaseTitlebar;
import cn.yhong.aframework.titlebar.DefaultTitlebar;

/**
 * android自动生成表格框架
 */
public class SmartTableActivity extends BaseActivity {

    @Override
    public BaseTitlebar initTitlebar() {
        return new DefaultTitlebar.Builder(this).setTitle("SmartTable")
                .setBackImage(R.drawable.back_white).create();
    }

    @Override
    public void initContent(Bundle savedInstanceState) {
        setContent(R.layout.activity_smart_table);
    }

    @Override
    public void initData() {

    }
}
