package com.yhong.asframe.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.yhong.asframe.R;
import com.yhong.asframe.base.BaseActivity;
import com.yhong.asframe.fragment.NoScrollViewFragment;

import java.util.ArrayList;
import java.util.List;

import cn.yhong.aframework.adapter.ZmPagerAdapter;
import cn.yhong.aframework.titlebar.BaseTitlebar;
import cn.yhong.aframework.titlebar.DefaultTitlebar;
import cn.yhong.aframework.utils.AtyUtils;

/**
 * ScrollView嵌套滑动布局
 */
public class NoScrollViewActivity extends BaseActivity
        implements CompoundButton.OnCheckedChangeListener {

    @Override
    public BaseTitlebar initTitlebar() {
        return new DefaultTitlebar.Builder(this).setTitle("ScrollView嵌套滑动布局")
                .setBackImage(R.drawable.back_white).create();
    }

    @Override
    public void initContent(Bundle savedInstanceState) {
        setContent(R.layout.activity_no_scroll_view);
    }

    private RadioButton btn_can_scroll;
    private RadioButton btn_no_scroll;
    private cn.yhong.aframework.widget.noscroll.NoScrollViewPager mViewPager;


    @Override
    public void initView() {
        super.initView();
        btn_can_scroll = (RadioButton) findViewById(R.id.btn_can_scroll);
        btn_no_scroll = (RadioButton) findViewById(R.id.btn_no_scroll);
        mViewPager = (cn.yhong.aframework.widget.noscroll.NoScrollViewPager) findViewById(R.id.mViewPager);

        btn_can_scroll.setChecked(true);
        btn_can_scroll.setOnCheckedChangeListener(this);
        btn_no_scroll.setOnCheckedChangeListener(this);
    }

    @Override
    public void initData() {
        //TODO 模拟数据
        List<Fragment> listFragment = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listFragment.add(new NoScrollViewFragment());
        }
        mViewPager.setAdapter(new ZmPagerAdapter(mFragmentManager, listFragment));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                AtyUtils.showShort(mActivity, position + 1 + "", false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.btn_can_scroll:
                    mViewPager.setNoScroll(false);
                    break;
                case R.id.btn_no_scroll:
                    mViewPager.setNoScroll(true);
                    break;
            }
        }
    }

}
