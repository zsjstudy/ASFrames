package cn.yhong.aframework.presenter;

import android.text.TextUtils;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Map;

import cn.yhong.aframework.R;
import cn.yhong.aframework.app.AfApplication;
import cn.yhong.aframework.utils.AtyUtils;
import okhttp3.Call;


public class PullToRefreshOkGoPresenter extends PullToRefreshPresenter {

    @Override
    public void getData(String url, Map<String, String> params) {
        if (mIPullToRefreshView == null) {
            return;
        }

        mIPullToRefreshView.showLoading(AfApplication.appContext.getString(R.string.loading));
        OkHttpUtils.post()
                .url(url)
                .params(params)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mIPullToRefreshView.dismissLoading();
                        Throwable throwable = e;
                        if (throwable != null) {
                            String message = e.toString();
                            if (!TextUtils.isEmpty(throwable.getMessage())) {
                                message = throwable.getMessage();
                                mIPullToRefreshView.onFailedResponse(message);
                            }
                            AtyUtils.i("onErrorResponse", message);
                        }
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        mIPullToRefreshView.dismissLoading();
                        if (!TextUtils.isEmpty(response)) {
                            AtyUtils.i("onSuccessResponse", response);
                            mIPullToRefreshView.onSuccessResponse(response);
                        }
                    }
                });
    }
}
