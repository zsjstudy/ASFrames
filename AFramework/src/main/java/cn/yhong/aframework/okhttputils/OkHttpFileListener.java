package cn.yhong.aframework.okhttputils;

import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;

import okhttp3.Call;

/**
 * Created by 17639 on 2020/6/8.
 */

public class OkHttpFileListener extends FileCallBack {

    public OkHttpFileListener(String destFileDir, String destFileName) {
        super(destFileDir, destFileName);
    }

    @Override
    public void onError(Call call, Exception e, int id) {

    }

    @Override
    public void onResponse(File response, int id) {

    }
}
