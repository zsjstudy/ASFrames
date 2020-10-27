package com.yhong.asframe.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yhong.asframe.R;
import com.yhong.asframe.adapter.RefreshBeanAdapter;
import com.yhong.asframe.base.BaseActivity;
import com.yhong.asframe.bean.RefreshBean;

import java.util.ArrayList;
import java.util.List;

import cn.yhong.aframework.titlebar.BaseTitlebar;
import cn.yhong.aframework.titlebar.DefaultTitlebar;
import cn.yhong.aframework.utils.AtyUtils;

/**
 * 可添加头布局和脚布局的GridView
 */
public class HeaderGridViewActivity extends BaseActivity {

    @Override
    public BaseTitlebar initTitlebar() {
        return new DefaultTitlebar.Builder(this).setTitle("HeaderGridView")
                .setBackImage(R.drawable.back_white).create();
    }

    @Override
    public void initContent(Bundle savedInstanceState) {
        setContent(R.layout.activity_header_grid_view);
    }

    private cn.yhong.aframework.widget.adapterview.HeaderGridView mGridView;

    @Override
    public void initView() {
        super.initView();
        mGridView = (cn.yhong.aframework.widget.adapterview.HeaderGridView) findViewById(R.id.mGridView);
        initHeaderView();
        initFooterView();
    }

    View headerView;

    /**
     * 添加头布局
     */
    private void initHeaderView() {
        if (headerView != null) {
            mGridView.removeHeaderView(headerView);
            headerView = null;
        }
        headerView = View.inflate(mActivity, R.layout.fragment_refresh_test, null);
        TextView tv_refresh_test = (TextView) headerView.findViewById(R.id.tv_refresh_test);
        tv_refresh_test.setText("Header");
        tv_refresh_test.setBackgroundColor(Color.YELLOW);
        tv_refresh_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AtyUtils.showShort(mActivity, "Header", true);
            }
        });
        mGridView.addHeaderView(headerView);
    }

    View footerView;

    /**
     * 添加脚布局
     */
    private void initFooterView() {
        if (footerView != null) {
            mGridView.removeFooterView(footerView);
            footerView = null;
        }
        footerView = View.inflate(mActivity, R.layout.fragment_refresh_test, null);
        TextView tv_refresh_test = (TextView) footerView.findViewById(R.id.tv_refresh_test);
        tv_refresh_test.setText("Footer");
        tv_refresh_test.setBackgroundColor(Color.BLUE);
        tv_refresh_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AtyUtils.showShort(mActivity, "Footer", true);
            }
        });
        mGridView.addFooterView(footerView);
    }

    @Override
    public void initData() {
        //TODO 模拟数据
        List<RefreshBean> datas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            RefreshBean data = new RefreshBean();
            data.ID = i + 1 + "";
            data.Title = "测试标题" + (i + 1);
            datas.add(data);
        }
        RefreshBeanAdapter adapter = new RefreshBeanAdapter(mActivity, datas, R.layout.item_refresh_bean_grid);
        mGridView.setAdapter(adapter);
    }

}
