package com.yhong.asframe.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anthonycr.grant.PermissionsResultAction;
import com.study.fileselectlibrary.AllFileActivity;
import com.study.fileselectlibrary.bean.FileItem;
import com.yhong.asframe.R;
import com.yhong.asframe.base.BaseActivity;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

import cn.yhong.aframework.utils.AtyUtils;
import cn.yhong.aframework.utils.FileMD5Utils;

/**
 * Created by 17639 on 2020/6/9.
 * 选择文件上传
 */

public class ChooseFileUplaodActivity extends BaseActivity {

    private Button choose_file;

    @Override
    public void initContent(Bundle savedInstanceState) {
        setContent(R.layout.activity_choose_file_upload);
    }

    @Override
    public void initData() {
        choose_file = findViewById(R.id.choose_file);
        choose_file();
    }

    public void choose_file() {
        choose_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFile();
            }
        });
    }


    /**
     * 从手机获取文件
     */
    private void selectFile() {
        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
        requestPermissions(permissions, new PermissionsResultAction() {

            @Override
            public void onGranted() {
                Intent intent = new Intent(mActivity, AllFileActivity.class);
                startActivityForResult(intent, 200);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }

            @Override
            public void onDenied(String permission) {
                AtyUtils.showShort(mActivity, R.string.open_save_permission, true);
            }
        });
    }

    private ArrayList<FileItem> resultFileList;
    private File file;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 200) {
            resultFileList = data.getParcelableArrayListExtra("file");

            String path = resultFileList.get(0).getPath();
            file = new File(path);

            //这里可根据项目需求自行修改
            if (resultFileList.get(0).getFileSize() != 0) {//文件上传大小限制，防止文件过大卡死
                DecimalFormat df = new DecimalFormat("#0.00");
                if (Double.parseDouble(df.format(resultFileList.get(0).getFileSize() / (double) (1024 * 1024))) > 4.00) {
                    AtyUtils.showShort(mActivity, "文件最大支持上传4M", true);
                    return;
                }
            } else {
                AtyUtils.showShort(mActivity, "请上传至少大于1kb的文件", true);
                return;
            }

            String fileMD5 = FileMD5Utils.getFileMD5(file);
//          AtyUtils.i("文件md5值",fileMD5);

//          String crc32_file = FileMD5Utils.getCRC32_file(path);
//          AtyUtils.i("文件crc32值",crc32_file);
        }
    }
}
