package com.yhong.asframe.utils;

import android.app.Activity;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

/**
 * Created by 17639 on 2020/8/26.
 */

public class InitRefreshView extends DefaultTitleViewBar {

    public InitRefreshView(Activity context) {
        super(context);
    }

    /**
     * 纯滚动view，不能刷新，可上拉拖拽
     *
     * @return
     */
    public SmartRefreshLayout getRefreshEnablePureScrollView() {
        SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(context);
        //这两个属性缺一不可，在代码设置的时候。xml中只需设置第一个
        smartRefreshLayout.setEnablePureScrollMode(true);//是否启用纯滚动模式
        smartRefreshLayout.setEnableOverScrollDrag(true);//是否启用越界拖动（仿苹果效果）V1.0.4
        return smartRefreshLayout;
    }

    /**
     * 可刷新，不可上拉view
     *
     * @param isOpenOverScroll 是否开始越界滚动
     * @return
     */
    public SmartRefreshLayout getEnableRefreshView(boolean isOpenOverScroll) {
        SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(context);
        smartRefreshLayout.setRefreshHeader(new ClassicsHeader(context));
        smartRefreshLayout.setEnableOverScrollDrag(isOpenOverScroll);//是否启用越界拖动（仿苹果效果）V1.0.4
        return smartRefreshLayout;
    }

    /**
     * 可刷新，下拉加载view
     *
     * @param isDisableWhenLoading 是否加载的时候可以操作视图
     * @return
     */
    public SmartRefreshLayout getEnableRefreshAndLoadMoreView(boolean isDisableWhenLoading) {
        SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(context);
        smartRefreshLayout.setRefreshHeader(new ClassicsHeader(context));
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(context));

        smartRefreshLayout.setDisableContentWhenRefresh(isDisableWhenLoading);//是否在刷新的时候禁止内容的一切手势操作（默认false）
        smartRefreshLayout.setDisableContentWhenLoading(isDisableWhenLoading);//是否在加载的时候禁止内容的一切手势操作（默认false）
        return smartRefreshLayout;
    }

}
