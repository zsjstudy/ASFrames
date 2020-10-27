package com.yhong.asframe.base;

import android.support.v4.content.ContextCompat;

import com.yhong.asframe.R;

import cn.yhong.aframework.activity.AfActivity;
import cn.yhong.aframework.presenter.BasePresenter;
import cn.yhong.aframework.utils.AtyUtils;

public abstract class BaseActivity<P extends BasePresenter> extends AfActivity<P> {

    @Override
    public boolean enableSliding() {
        //开启侧滑返回
        return true;
    }

    @Override
    public void initView() {
        //沉浸式
        if (titlebar != null) {
            titlebar.setBackgroundColor(ContextCompat.getColor(mActivity, R.color.colorDefaultTitlebarBg));
            AtyUtils.setPaddingTop(mActivity, titlebar);
        }
    }
}
