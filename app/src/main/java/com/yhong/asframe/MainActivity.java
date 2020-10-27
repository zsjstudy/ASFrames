package com.yhong.asframe;

import android.view.KeyEvent;

import com.yhong.asframe.activity.AbsListActivity;
import com.yhong.asframe.activity.BannerActivity;
import com.yhong.asframe.activity.ChooseFileUplaodActivity;
import com.yhong.asframe.activity.CommonUtilsActivity;
import com.yhong.asframe.activity.CustomWidgetActivity;
import com.yhong.asframe.activity.GithubProjectActivity;
import com.yhong.asframe.activity.OkHttpUtilsTextActivity;
import com.yhong.asframe.activity.RefreshBeanActivity;
import com.yhong.asframe.activity.UploadAvatarActivity;
import com.yhong.asframe.activity.UploadImageActivity;
import com.yhong.asframe.activity.UploadVideoActivity;
import com.yhong.asframe.activity.UploadVoiceActivity;
import com.yhong.asframe.activity.WebViewActivity;
import com.yhong.asframe.activity.ZmQrCodeActivity;
import com.yhong.asframe.activity.ZmShakeActivity;

import cn.yhong.aframework.titlebar.BaseTitlebar;
import cn.yhong.aframework.titlebar.DefaultTitlebar;

/**
 * 主页
 */
public class MainActivity extends AbsListActivity {

    @Override
    public BaseTitlebar initTitlebar() {
        return new DefaultTitlebar.Builder(this).setTitle("AfDemo").create();
    }

    @Override
    protected CharSequence initTitle() {
        return "AfDemo";
    }

    @Override
    protected String[] initTitles() {
        return new String[]{
                "轮播图",
                "常用工具类",
                "自定义控件",
                "Github优秀开源库",
                "下拉刷新",
                "头像上传",
                "图片多选",
                "视频上传",
                "语音上传",
                "WebView的使用",
                "微信扫一扫",
                "微信摇一摇",
                "测试OKHTTPutils",
                "选择文件上传",
        };
    }

    @Override
    protected Class[] initClass() {
        return new Class[]{
                BannerActivity.class,
                CommonUtilsActivity.class,
                CustomWidgetActivity.class,
                GithubProjectActivity.class,
                RefreshBeanActivity.class,
                UploadAvatarActivity.class,
                UploadImageActivity.class,
                UploadVideoActivity.class,
                UploadVoiceActivity.class,
                WebViewActivity.class,
                ZmQrCodeActivity.class,
                ZmShakeActivity.class,
                OkHttpUtilsTextActivity.class,
                ChooseFileUplaodActivity.class,
        };
    }

    @Override
    public void initData() {
        super.initData();
    }



    @Override
    public boolean enableSliding() {
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && //
                event.getAction() == KeyEvent.ACTION_DOWN) {
            doubleClickExit(2000, "再按一次返回键退出程序");
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
