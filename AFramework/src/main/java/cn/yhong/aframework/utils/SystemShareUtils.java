package cn.yhong.aframework.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;

import cn.yhong.aframework.app.AfApplication;


/**
 * Created by 17639 on 2020/8/27.
 */

public class SystemShareUtils {

    /**
     * 分享图片
     *
     * @param context
     * @param bitmap
     * @param image_path
     */
    public static void shareImage(Context context, Bitmap bitmap, String image_path, String shareTitle) {
        try {
            ImageUtils.saveBitmapFile(bitmap, image_path);
            File file = new File(image_path);

            Intent intent = new Intent(Intent.ACTION_SEND); // 启动分享发送的属性
            intent.setType("image/jpeg");// 分享发送的数据类型 "text/plain"文本  "image/jpeg"图片
            Uri imageUri;
            if (Build.VERSION.SDK_INT >= 24) {
                imageUri = FileProvider.getUriForFile(context, AfApplication.FILE_PROVIDER, file);
            } else {
                imageUri = Uri.fromFile(file);
            }
            intent.putExtra(Intent.EXTRA_STREAM, imageUri);
            context.startActivity(Intent.createChooser(intent, shareTitle));//弹出系统分享列表。
        } catch (Exception e) {
            e.printStackTrace();
            AtyUtils.showShort(context, "分享失败", false);
        }
    }

    /**
     * 分享文本
     *
     * @param context
     * @param text
     */
    public static void shareText(Context context, String text, String shareTitle) {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND); // 启动分享发送的属性
            intent.setType("image/jpeg");// 分享发送的数据类型 "text/plain"文本  "image/jpeg"图片
            intent.putExtra(Intent.EXTRA_TEXT, text);// 分享的内容
//                intent.putExtra(Intent.EXTRA_SUBJECT, "Email subject over here");// 分享的主题
            context.startActivity(Intent.createChooser(intent, shareTitle));//弹出系统分享列表。
        } catch (Exception e) {
            e.printStackTrace();
            AtyUtils.showShort(context, "分享失败", false);
        }
    }
}
