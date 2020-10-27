package com.yhong.asframe.activity;

import android.os.Bundle;

import com.yhong.asframe.R;
import com.yhong.asframe.base.BaseActivity;
import com.yhong.asframe.fragment.MyShakeFragment;


/**
 * 微信摇一摇
 */
public class ZmShakeActivity extends BaseActivity {

    @Override
    public void initContent(Bundle savedInstanceState) {

    }

    private MyShakeFragment fragment;

    @Override
    public void initData() {
        fragment = new MyShakeFragment();
        mFragmentManager.beginTransaction().replace(R.id.fl_fragment, fragment).commit();
    }
}
