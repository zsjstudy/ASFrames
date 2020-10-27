package com.yhong.asframe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.yhong.asframe.R;
import com.yhong.asframe.base.BaseActivity;
import com.yhong.asframe.fragment.SmartRefreshGridViewFragment;
import com.yhong.asframe.fragment.SmartRefreshListViewFragment;
import com.yhong.asframe.fragment.SmartRefreshRecyclerViewFragment;
import com.yhong.asframe.fragment.SmartRefreshScrollViewFragment;

import cn.yhong.aframework.titlebar.BaseTitlebar;
import cn.yhong.aframework.titlebar.DefaultTitlebar;

/**
 * 下拉刷新列表
 */
public class SmartRefreshActivity extends BaseActivity {

    private int type;
    private String title;

    @Override
    public void initIntent(Intent intent) {
        type = intent.getIntExtra("type", 1);
        title = intent.getStringExtra("title");
    }

    private boolean isGrid;

    @Override
    public BaseTitlebar initTitlebar() {
        DefaultTitlebar.Builder builder = new DefaultTitlebar.Builder(this)//
                .setTitle(title)//
                .setBackImage(R.drawable.back_white)//
                .setLineHeight(0.0f);
        if (type == 4) {
            builder.setMenuImage(R.drawable.icon_list)//
                    .setMenuListener(new BaseTitlebar.OnClickMenuListener() {
                        @Override
                        public void onClickMenu(View view) {
                            isGrid = !isGrid;
                            ((DefaultTitlebar) titlebar).iv_menu
                                    .setImageResource(isGrid ? R.drawable.icon_grid : R.drawable.icon_list);
                            ((SmartRefreshRecyclerViewFragment) fragment).updataListGrid(isGrid);
                        }
                    });
        }
        return builder.create();
    }

    @Override
    public void initContent(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        super.initView();
    }

    private Fragment fragment = null;

    @Override
    public void initData() {
        switch (type) {
            case 1:
                fragment = new SmartRefreshScrollViewFragment();
                break;
            case 2:
                fragment = new SmartRefreshListViewFragment();
                break;
            case 3:
                fragment = new SmartRefreshGridViewFragment();
                break;
            case 4:
                fragment = new SmartRefreshRecyclerViewFragment();
                break;
        }
        if (fragment != null) {
            mFragmentManager.beginTransaction().replace(R.id.fl_fragment, fragment).commit();
        }
    }

    public View getTitlebar() {
        return ((DefaultTitlebar) titlebar).layout;
    }
}
