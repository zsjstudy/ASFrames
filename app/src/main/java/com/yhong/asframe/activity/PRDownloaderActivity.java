package com.yhong.asframe.activity;

import android.os.Bundle;

import com.yhong.asframe.R;
import com.yhong.asframe.base.BaseActivity;

import cn.yhong.aframework.titlebar.BaseTitlebar;
import cn.yhong.aframework.titlebar.DefaultTitlebar;

/**
 * 文件下载器
 */
public class PRDownloaderActivity extends BaseActivity {

    @Override
    public BaseTitlebar initTitlebar() {
        return new DefaultTitlebar.Builder(this).setTitle("PRDownloader")
                .setBackImage(R.drawable.back_white).create();
    }

    @Override
    public void initContent(Bundle savedInstanceState) {
        setContent(R.layout.activity_pr_downloader);
    }

    @Override
    public void initData() {

    }
}
