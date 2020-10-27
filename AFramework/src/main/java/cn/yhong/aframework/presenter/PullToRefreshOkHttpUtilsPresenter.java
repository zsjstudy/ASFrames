package cn.yhong.aframework.presenter;

import android.text.TextUtils;

import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Map;

import cn.yhong.aframework.okhttputils.MyOkHttpUtils;
import cn.yhong.aframework.utils.AtyUtils;
import okhttp3.Call;

/**
 * Created by 17639 on 2020/6/9.
 */

public class PullToRefreshOkHttpUtilsPresenter extends PullToRefreshPresenter {

    @Override
    public void getData(String url, Map<String, String> params) {
        if (mIPullToRefreshView == null) {
            return;
        }
        mIPullToRefreshView.showLoading("...");
        MyOkHttpUtils.post_NoCallBack(url, params, null).execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                mIPullToRefreshView.dismissLoading();
                mIPullToRefreshView.onFailedResponse(e.toString());
                AtyUtils.i("onErrorResponse", e.toString());
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
