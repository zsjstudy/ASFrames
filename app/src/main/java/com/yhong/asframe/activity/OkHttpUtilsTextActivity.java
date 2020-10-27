package com.yhong.asframe.activity;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yhong.asframe.R;
import com.yhong.asframe.base.BaseActivity;
import com.yhong.asframe.bean.AdBean;
import com.yhong.asframe.net.API;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import cn.yhong.aframework.okhttputils.OkHttpDataListener;
import cn.yhong.aframework.okhttputils.OkHttpSuccessListener;
import cn.yhong.aframework.utils.AtyUtils;
import cn.yhong.aframework.okhttputils.MyOkHttpUtils;

/**
 * Created by 17639 on 2020/6/8.
 */

public class OkHttpUtilsTextActivity extends BaseActivity {

    private EditText et1, et2;
    private Button button;

    @Override
    public void initContent(Bundle savedInstanceState) {
        setContent(R.layout.activity_text);
    }

    @Override
    public void initView() {
        super.initView();
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        button = findViewById(R.id.logdin);

    }

    @Override
    public void initData() {
        getAd();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> params = new HashMap<>();
                params.put("phone", AtyUtils.getText(et1));
                params.put("code", AtyUtils.getText(et2));
                params.put("type", "0");
                OkHttpUtils.post().url("http://9y.toushizhiku.com/api/sms_login")
                        .params(params)
                        .headers(getLoginHeads(mActivity))
                        .build().execute(new OkHttpSuccessListener(OkHttpUtilsTextActivity.this, "登录", 3) {
                    @Override
                    public void onSuccessResponse(String response) {
                        if (API.filterJson(response)) {
                            AtyUtils.i("OK值", response);
                        }
                    }

                    @Override
                    public void onErrorResponse() {
                        AtyUtils.i("OK值", "网络异常，请稍后再试");
                    }
                });
            }
        });
    }


    /**
     * 获取设备id
     *
     * @param context
     * @return
     */
    public static String getDeviceID(Context context) {
        if (context == null) {
            return "";
        }
        String android_id = Settings.System.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return android_id == null ? "" : android_id;
    }

    /**
     * 获取登录请求头
     */
    public static Map<String, String> getLoginHeads(Context context) {
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("XX-Token", "");
        headers.put("XX-Device-Type", "android");
        headers.put("XX-Device-ID", getDeviceID(context));
        headers.put("user-agent", "Dalvik/2.1.0 (Linux; U; Android;)");
        return headers;
    }


    /**
     * 开机广告图
     */
    private void getAd() {
        Map<String, String> params = new HashMap<>();
        params.put("phone_brand", EquipmentUtil.getDeviceBrand() == null ? "" : EquipmentUtil.getDeviceBrand());
        params.put("phone_model", EquipmentUtil.getSystemModel() == null ? "" : EquipmentUtil.getSystemModel());
        params.put("phone_system", EquipmentUtil.getSystemVersion() == null ? "" : EquipmentUtil.getSystemVersion());
        params.put("multipart", "1");
//        OkHttpUtils.post().url("http://9y.toushizhiku.com/api/portal/advertisement/index")
//                .params(params)
//                .headers(getLoginHeads(mActivity))
//                .build().execute(new OkHttpSuccessListener(OkHttpUtilsTextActivity.this, "广告图", 3) {
//            @Override
//            public void onSuccessResponse(String response) {
//                if (API.filterJson(response)) {
//                    AtyUtils.i("OK值", response);
//                }
//            }
//
//            @Override
//            public void onErrorResponse() {
//                AtyUtils.i("OK值", "网络异常，请稍后再试");
//            }
//        });

//        MyOkHttpUtils.post_NoCallBack("http://9y.toushizhiku.com/api/portal/advertisement/index", params, getLoginHeads(mActivity))
//                .execute(new OkHttpSuccessListener(OkHttpUtilsTextActivity.this, "广告图", 3) {
//                    @Override
//                    public void onSuccessResponse(String response) {
//
//                    }
//
//                    @Override
//                    public void onErrorResponse() {
//
//                    }
//                });

//        MyOkHttpUtils.post_CallBack("http://9y.toushizhiku.com/api/portal/advertisement/index", params, getLoginHeads(mActivity),
//                new OkHttpSuccessListener(OkHttpUtilsTextActivity.this, "广告图", 3) {
//            @Override
//            public void onSuccessResponse(String response) {
//
//            }
//
//            @Override
//            public void onErrorResponse() {
//
//            }
//        });


        MyOkHttpUtils.post_NoCallBack("http://9y.toushizhiku.com/api/portal/advertisement/index", params, getLoginHeads(mActivity))
                .execute(new OkHttpDataListener<AdBean>(this, "广告图", 3, AdBean.class) {
                    @Override
                    public void onDatasResponse(AdBean adBean) {
                        AtyUtils.i("广告图---", adBean.getRecruit() + "");
                    }

                    @Override
                    public void onErrorResponse() {

                    }
                });
//        MyOkHttpUtils.post_NoCallBack("http://9y.toushizhiku.com/api/portal/advertisement/index", params, getLoginHeads(mActivity))
//            .execute(new OkHttpFileListener());

    }

}
