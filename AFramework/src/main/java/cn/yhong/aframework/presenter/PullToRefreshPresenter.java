package cn.yhong.aframework.presenter;

import java.util.Map;

import cn.yhong.aframework.view.IBaseView;
import cn.yhong.aframework.view.IPullToRefreshView;

public abstract class PullToRefreshPresenter extends BasePresenter {

    protected IPullToRefreshView mIPullToRefreshView;

    @Override
    public void onAttach(IBaseView view) {
        if (view instanceof IPullToRefreshView) {
            mIPullToRefreshView = (IPullToRefreshView) view;
        }
    }

    @Override
    public void onDetach() {
        if (mIPullToRefreshView != null) {
            mIPullToRefreshView = null;
        }
    }

    /**
     * 获取数据
     *
     * @param url
     * @param params
     */
    public abstract void getData(String url, Map<String, String> params);

}
