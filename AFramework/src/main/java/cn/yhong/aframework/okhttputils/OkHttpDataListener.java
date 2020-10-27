package cn.yhong.aframework.okhttputils;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;

import cn.yhong.aframework.app.AfApplication;
import cn.yhong.aframework.utils.AtyUtils;
import cn.yhong.aframework.utils.JsonUtils;
import cn.yhong.aframework.view.IBaseView;
import okhttp3.Call;

/**
 * Created by 17639 on 2020/6/8.
 */

public abstract class OkHttpDataListener<T> extends BaseOkHttpListener {

    protected Class<T> clazz;

    public OkHttpDataListener(IBaseView mView, Class<T> clazz) {
        super(mView);
        this.clazz = clazz;
    }

    public OkHttpDataListener(IBaseView mView, String tag, Class<T> clazz) {
        super(mView, tag);
        this.clazz = clazz;
    }

    public OkHttpDataListener(IBaseView mView, String tag, int messageType, Class<T> clazz) {
        super(mView, tag, messageType);
        this.clazz = clazz;
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        onErrorResponse();
    }

    @Override
    public void onResponse(String response, int id) {
        if (mView != null) {
            mView.dismissLoading();
            if (!TextUtils.isEmpty(tag)) {
                AtyUtils.i(tag, response);
            }
            if (JsonUtils.isErrorCode(response)) {
                mView.onErrorCodeResponse(JsonUtils.getMsg(response));
                return;
            }
            if (messageType == 3) {
                JsonUtils.showMsg(AfApplication.appContext, response);
            }
            if (JsonUtils.filterJson(response)) {
                if (messageType == 1) {
                    JsonUtils.showSuccessMsg(AfApplication.appContext, response);
                }
                if (JsonUtils.checkJson(response)) {//code为200，但是返回data为空
                    if (clazz != null) {
                        onDatasResponse(JSON.parseObject(JsonUtils.parseGson(response).toString(), clazz));
                    }
                } else {
                    onErrorResponse();
                }
            } else {
                if (messageType == 2) {
                    JsonUtils.showErrorMsg(AfApplication.appContext, response);
                }
                onErrorResponse();
            }
        }
    }


    /**
     * 解析的回调
     *
     * @param t
     */
    public abstract void onDatasResponse(T t);


    /**
     * 失败的回调
     */
    public abstract void onErrorResponse();
}
