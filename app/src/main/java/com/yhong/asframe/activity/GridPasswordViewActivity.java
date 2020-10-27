package com.yhong.asframe.activity;

import android.os.Bundle;

import com.yhong.asframe.R;
import com.yhong.asframe.base.BaseActivity;

import cn.yhong.aframework.titlebar.BaseTitlebar;
import cn.yhong.aframework.titlebar.DefaultTitlebar;
import cn.yhong.aframework.utils.AtyUtils;
import cn.yhong.aframework.widget.gridpassword.GridPasswordView;

/**
 * 支付密码输入框
 */
public class GridPasswordViewActivity extends BaseActivity {

    @Override
    public BaseTitlebar initTitlebar() {
        return new DefaultTitlebar.Builder(this).setTitle("GridPasswordView")
                .setBackImage(R.drawable.back_white).create();
    }

    @Override
    public void initContent(Bundle savedInstanceState) {
        setContent(R.layout.activity_grid_password_view);
    }

    private cn.yhong.aframework.widget.gridpassword.GridPasswordView mGridPasswordView;

    @Override
    public void initView() {
        super.initView();
        mGridPasswordView = (cn.yhong.aframework.widget.gridpassword.GridPasswordView) findViewById(R.id.mGridPasswordView);
        //是否显示密码
        //mGridPasswordView.setPasswordVisibility(true);
        //其他设置看GitHub上说明
    }

    @Override
    public void initData() {
        //事件监听
        mGridPasswordView.setOnPasswordChangedListener(new GridPasswordView.OnPasswordChangedListener() {
            @Override
            public void onTextChanged(String psw) {
                //文字改变
            }

            @Override
            public void onInputFinish(String psw) {
                //输入完成
                AtyUtils.showShort(mActivity, psw, true);
                //清空输入框
                //mGridPasswordView.clearPassword();
            }
        });
        //自动弹起键盘
        mGridPasswordView.setForceInputViewGetFocus();
    }

}
