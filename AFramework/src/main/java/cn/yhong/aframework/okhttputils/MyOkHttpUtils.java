package cn.yhong.aframework.okhttputils;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.File;
import java.util.Map;

import cn.yhong.aframework.okhttputils.OkHttpSuccessListener;
import okhttp3.MediaType;

/**
 * Created by 17639 on 2020/6/8.
 */

public class MyOkHttpUtils {

    /**
     * post返回RequestCall自己处理回调
     *
     * @param url 请求地址
     * @param params 请求参数
     * @param heads 请求头，如果不需要则可以把.headers(heads)去掉就行
     * @return
     */
    public static RequestCall post_NoCallBack(String url, Map<String, String> params, Map<String, String> heads) {
        RequestCall build = OkHttpUtils.post().url(url).params(params).headers(heads).build();
        return build;
    }

    /**
     * post返回RequestCall自己处理回调
     *
     * @param url 请求地址
     * @param params 请求参数
     * @return
     */
    public static RequestCall post_NoCallBack(String url, Map<String, String> params) {
        RequestCall build = OkHttpUtils.post().url(url).params(params).build();
        return build;
    }

    /**
     * post直接请求
     *
     * @param url 请求地址
     * @param params 请求参数
     * @param heads 请求头，如果不需要则可以把.headers(heads)去掉就行
     * @param callback 请求回调
     */
    public static void post_CallBack(String url, Map<String, String> params, Map<String, String> heads, OkHttpSuccessListener callback) {
        OkHttpUtils.post().url(url).params(params).headers(heads).build().execute(callback);
    }

    /**
     * post直接请求
     *
     * @param url 请求地址
     * @param params 请求参数
     * @param callback 请求回调
     */
    public static void post_CallBack(String url, Map<String, String> params, OkHttpSuccessListener callback) {
        OkHttpUtils.post().url(url).params(params).build().execute(callback);
    }


    /**
     * get直接请求
     *
     * @param url 请求地址
     * @param heads 请求头，如果不需要则可以把.headers(heads)去掉就行
     */
    public static RequestCall get_NoCallBack(String url, Map<String, String> heads) {
        RequestCall build = OkHttpUtils.get().url(url).headers(heads).build();
        return build;
    }

    /**
     * get直接请求
     *
     * @param url 请求地址
     */
    public static RequestCall get_NoCallBack(String url) {
        RequestCall build = OkHttpUtils.get().url(url).build();
        return build;
    }

    /**
     * get直接请求
     *
     * @param url 请求地址
     * @param heads 请求头，如果不需要则可以把.headers(heads)去掉就行
     * @param callback
     */
    public static void get_CallBack(String url, Map<String, String> heads, OkHttpSuccessListener callback) {
        OkHttpUtils.get().url(url).headers(heads).build().execute(callback);
    }
    /**
     * get直接请求
     *
     * @param url 请求地址
     * @param callback
     */
    public static void get_CallBack(String url, OkHttpSuccessListener callback) {
        OkHttpUtils.get().url(url).build().execute(callback);
    }


    /**
     * Post JSON
     *
     * @param url 请求地址
     * @param heads 请求头，如果不需要则可以把.headers(heads)去掉就行
     * @param callback
     */
    public static void JSON_CallBack(String url, Map<String, String> heads, Object o, OkHttpSuccessListener callback) {
        OkHttpUtils.postString().url(url).headers(heads).content(o.toString())
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build().execute(callback);
    }

    /**
     * Post File
     *
     * @param url 请求地址
     * @param heads 请求头，如果不需要则可以把.headers(heads)去掉就行
     * @param file 需要上传的文件
     * @param callback
     */
    public static void file_CallBack(String url, Map<String, String> heads, File file, OkHttpSuccessListener callback) {
        OkHttpUtils.postFile().url(url).headers(heads).file(file)
                .build().execute(callback);
    }

    /**
     * Post表单形式上传文件  一对一
     *
     * @param url 请求地址
     * @param heads 请求头，如果不需要则可以把.headers(heads)去掉就行
     * @param callback
     */
    public static void file_table_CallBack(String url, Map<String, String> heads, String key, String filename, File file, OkHttpSuccessListener callback) {
        OkHttpUtils.post().url(url).addFile(key, filename, file).headers(heads).build()
                .execute(callback);
    }

    /**
     * Post表单形式上传文件  一对多
     *
     * @param url 请求地址
     * @param heads 请求头，如果不需要则可以把.headers(heads)去掉就行
     * @param callback
     */
    public static void file_table_CallBack(String url, Map<String, String> heads, String key, Map<String, File> files, OkHttpSuccessListener callback) {
        OkHttpUtils.post().url(url).files(key, files).headers(heads).build()
                .execute(callback);
    }

    /**
     * Post表单形式上传文件  多对多
     *
     * @param url 请求地址
     * @param heads 请求头，如果不需要则可以把.headers(heads)去掉就行
     * @param callback
     */
    public static void file_table_CallBack(String url, Map<String, String> heads, Map<String, String> keys, Map<String, File> files, OkHttpSuccessListener callback) {
//        OkHttpUtils.post().url(url)
//                .addFile(key, files).headers(heads).build()
//                .execute(callback);
    }


}
