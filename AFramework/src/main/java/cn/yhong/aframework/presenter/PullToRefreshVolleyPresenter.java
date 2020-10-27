package cn.yhong.aframework.presenter;

import android.text.TextUtils;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Map;

import cn.yhong.aframework.R;
import cn.yhong.aframework.app.AfApplication;
import cn.yhong.aframework.utils.AtyUtils;
import zm.http.volley.ZmVolley;
import zm.http.volley.request.ZmStringRequest;

public class PullToRefreshVolleyPresenter extends PullToRefreshPresenter {

    @Override
    public void getData(String url, Map<String, String> params) {
        if (mIPullToRefreshView == null)
            return;
        if (ZmVolley.isNetworkConnect(AfApplication.appContext)) {
            mIPullToRefreshView.showLoading(AfApplication.appContext.getString(R.string.loading));
            ZmVolley.request(new ZmStringRequest(url, params, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    AtyUtils.i("onSuccessResponse", response);
                    mIPullToRefreshView.dismissLoading();
                    mIPullToRefreshView.onSuccessResponse(response);
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    AtyUtils.e("onErrorResponse", error);
                    mIPullToRefreshView.dismissLoading();
                    String message = error.toString();
                    if (!TextUtils.isEmpty(error.getMessage())) {
                        message = error.getMessage();
                    }
                    if (error.networkResponse != null && error.networkResponse.data != null) {
                        message = new String(error.networkResponse.data);
                    }
                    mIPullToRefreshView.onFailedResponse(message);
                }
            }), mIPullToRefreshView.getRequestTag());
        } else {
            mIPullToRefreshView.onFailedResponse(AfApplication.appContext.getString(R.string.connect_error));
        }
    }

}
