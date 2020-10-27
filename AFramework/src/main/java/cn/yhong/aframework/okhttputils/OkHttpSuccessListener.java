package cn.yhong.aframework.okhttputils;

import android.text.TextUtils;

import cn.yhong.aframework.app.AfApplication;
import cn.yhong.aframework.utils.AtyUtils;
import cn.yhong.aframework.utils.JsonUtils;
import cn.yhong.aframework.view.IBaseView;
import okhttp3.Call;

/**
 * Created by 17639 on 2020/6/8.
 */

public abstract class OkHttpSuccessListener extends BaseOkHttpListener {

    public OkHttpSuccessListener(IBaseView mView) {
        super(mView);
    }

    public OkHttpSuccessListener(IBaseView mView, String tag) {
        super(mView, tag);
    }

    public OkHttpSuccessListener(IBaseView mView, String tag, int messageType) {
        super(mView, tag, messageType);
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        onErrorResponse();
        if (mView != null) {
            mView.dismissLoading();
            AtyUtils.e(tag, e);
        }
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
                onSuccessResponse(response);
            } else {
                if (messageType == 2) {
                    JsonUtils.showErrorMsg(AfApplication.appContext, response);
                }
            }
        }
    }


    /**
     * 成功的回调
     *
     * @param response
     */
    public abstract void onSuccessResponse(String response);

    /**
     * 失败的回调
     */
    public abstract void onErrorResponse();
}
