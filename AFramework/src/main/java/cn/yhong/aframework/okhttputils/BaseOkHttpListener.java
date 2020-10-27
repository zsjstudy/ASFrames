package cn.yhong.aframework.okhttputils;


import com.zhy.http.okhttp.callback.StringCallback;

import cn.yhong.aframework.view.IBaseView;
import okhttp3.Call;

/**
 * Created by 17639 on 2020/6/8.
 */

public class BaseOkHttpListener extends StringCallback {

    protected IBaseView mView;
    protected String tag;
    /**
     * 消息类型 0不显示消息 1只显示成功消息 2只显示失败消息 3显示成功和失败消息
     */
    protected int messageType;

    public BaseOkHttpListener(IBaseView mView) {
        this(mView, null);
    }

    public BaseOkHttpListener(IBaseView mView, String tag) {
        this(mView, tag, 0);
    }

    public BaseOkHttpListener(IBaseView mView, String tag, int messageType) {
        this.mView = mView;
        this.tag = tag;
        this.messageType = messageType;
    }

    @Override
    public void onError(Call call, Exception e, int id) {

    }

    @Override
    public void onResponse(String response, int id) {

    }
}
