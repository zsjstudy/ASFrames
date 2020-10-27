package com.yhong.asframe.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.yhong.asframe.R;

import java.io.Serializable;

/**
 * Created by 17639 on 2020/8/24.
 */

public class InitTitleBar extends DefaultTitleViewBar implements View.OnClickListener {

    private View layout;
    private TextView head_title, iv_share, bar_line;
    private ImageView back_iv, logo_iv;
    private RelativeLayout head_view;

    public InitTitleBar(Activity context) {
        super(context);
        initView();
    }

    public void initView() {
        try {
            layout = LayoutInflater.from(context).inflate(R.layout.head_view, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (layout == null) {
            return;
        }
        head_title = layout.findViewById(R.id.head_title);
        iv_share = layout.findViewById(R.id.iv_share);
        back_iv = layout.findViewById(R.id.back_iv);
        logo_iv = layout.findViewById(R.id.logo_iv);
        bar_line = layout.findViewById(R.id.bar_line);
        head_view = layout.findViewById(R.id.head_view);

        iv_share.setOnClickListener(this);
        back_iv.setOnClickListener(this);
        logo_iv.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_share://右边菜单按钮
                if (onClickMenuListener != null) {
                    onClickMenuListener.onClickMenu(v);
                }
                break;
            case R.id.back_iv://返回
                if (onClickBackListener == null) {
                    context.finish();
                    return;
                }
                onClickBackListener.onClickBack(v);
                break;
            case R.id.logo_iv://文章详情和专题详情 顶部logo返回
                if (onClickTitleListener != null) {
                    onClickTitleListener.onClickTitle(v);
                }
                break;
        }
    }

    /**
     * 标题文字加粗
     */
    private Typeface textTitleTf = null;


    /**
     * 标题文字
     */
    private CharSequence textTitle = null;

    /**
     * 标题文字大小
     */
    private int textSize = 14;
    /**
     * 标题文字颜色
     */
    private int textTitleColor = 0;

    /**
     * 返回文字
     */
    private CharSequence textBack = null;

    /**
     * 返回文字颜色
     */
    private int textBackColor = 0;

    /**
     * 菜单文字
     */
    private CharSequence textMenu = null;

    /**
     * 菜单文字字体大小
     */
    private int textMenuSize = 12;

    /**
     * 菜单文字颜色
     */
    private int textMenuColor = 0;

    /**
     * 菜单图片
     */
    private Drawable imageMenu = null;

    /**
     * 菜单图片2
     */
    private Drawable imageMenu2 = null;


    /**
     * 创建
     */
    private void create() {
        if (textTitle != null) {
            head_title.setText(textTitle);
        }
        if (textTitleTf != null) {
            head_title.setTypeface(textTitleTf);//加粗
        }

        if (textMenu != null) {
            iv_share.setText(textMenu);
            iv_share.setVisibility(View.VISIBLE);
        }

        //这里的ture指的是暗夜模式，如果有暗夜模式的判断，把这改了就行
        if (true) {
            head_view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorBlack));
            head_title.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));
            iv_share.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));
            back_iv.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.back));
        } else {
            head_view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite));
            head_title.setTextColor(textTitleColor != 0 ? textTitleColor : ContextCompat.getColor(context, R.color.colorText));
            iv_share.setTextColor(textMenuColor != 0 ? textMenuColor : ContextCompat.getColor(context, R.color.colorText));
            back_iv.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.back));
        }

        head_title.setTextSize(textSize);
        iv_share.setTextSize(textMenuSize);

        if (imageMenu != null && imageMenu2 != null) {
            if (true) {//这里可以改为暗夜模式的判断
//            if (API.isNight()) {
                imageMenu.setBounds(0, 0, imageMenu.getIntrinsicWidth(),
                        imageMenu.getIntrinsicHeight());
                iv_share.setCompoundDrawables(imageMenu, null, null, null);
            } else {
                imageMenu2.setBounds(0, 0, imageMenu2.getIntrinsicWidth(),
                        imageMenu2.getIntrinsicHeight());
                iv_share.setCompoundDrawables(imageMenu2, null, null, null);
            }
        }
    }

    public View getView() {
        if (layout == null) {
            return null;
        }
        return layout;
    }

    @SuppressWarnings("serial")
    public static class Builder implements Serializable {

        private final InitTitleBar D;
        private Context context;

        public Builder(Activity context) {
            this.context = context;
            D = new InitTitleBar(context);
        }

        // =========================获取上下文=========================

        public Context getContext() {
            return context;
        }

        // =========================设置标题文字=========================

        public InitTitleBar.Builder setTitleBold() {
            return setTitleTypeface(Typeface.DEFAULT_BOLD);
        }

        public InitTitleBar.Builder setTitleTypeface(Typeface tf) {
            D.textTitleTf = tf;
            return this;
        }

        public InitTitleBar.Builder setTitle(int textTitleId) {
            D.textTitle = context.getText(textTitleId);
            return this;
        }

        public InitTitleBar.Builder setTitle(CharSequence textTitle) {
            D.textTitle = textTitle;
            return this;
        }

        public InitTitleBar.Builder setTitleSize(int textSize) {
            D.textSize = textSize;
            return this;
        }

        public InitTitleBar.Builder setTitleColor(int titleColor) {
            D.textTitleColor = titleColor;
            return this;
        }

        public InitTitleBar.Builder setTitleColor(String titleColor) {
            D.textTitleColor = Color.parseColor(titleColor);
            return this;
        }

        // =========================设置返回文字=========================

        public InitTitleBar.Builder setBackText(int textBackId) {
            D.textBack = D.context.getText(textBackId);
            return this;
        }

        public InitTitleBar.Builder setBackText(CharSequence textBack) {
            D.textBack = textBack;
            return this;
        }

        public InitTitleBar.Builder setBackTextColor(int textBackColor) {
            D.textBackColor = textBackColor;
            return this;
        }

        public InitTitleBar.Builder setBackTextColor(String textBackColor) {
            D.textBackColor = Color.parseColor(textBackColor);
            return this;
        }

        // =========================设置菜单文字=========================

        public InitTitleBar.Builder setMenuText(int textMenuId) {
            D.textMenu = D.context.getText(textMenuId);
            return this;
        }

        public InitTitleBar.Builder setMenuText(CharSequence textMenu) {
            D.textMenu = textMenu;
            return this;
        }

        public InitTitleBar.Builder setMenuTextSize(int textMenuSize) {
            D.textMenuSize = textMenuSize;
            return this;
        }

        public InitTitleBar.Builder setMenuTextColor(int textMenuColor) {
            D.textMenuColor = textMenuColor;
            return this;
        }

        public InitTitleBar.Builder setMenuTextColor(String textMenuColor) {
            D.textMenuColor = Color.parseColor(textMenuColor);
            return this;
        }

        // =========================设置菜单图片=========================

        @SuppressWarnings("deprecation")
        public InitTitleBar.Builder setMenuImage(int imageId) {
            D.imageMenu = D.context.getResources().getDrawable(imageId);
            return this;
        }

        public InitTitleBar.Builder setMenuImage(Drawable imageMenu) {
            D.imageMenu = imageMenu;
            return this;
        }

        @SuppressWarnings("deprecation")
        public InitTitleBar.Builder setMenuImage(Bitmap imageMenu) {
            D.imageMenu = new BitmapDrawable(imageMenu);
            return this;
        }

        // =========================设置菜单图片2=========================

        @SuppressWarnings("deprecation")
        public InitTitleBar.Builder setMenuImage2(int imageId) {
            D.imageMenu2 = D.context.getResources().getDrawable(imageId);
            return this;
        }

        public InitTitleBar.Builder setMenuImage2(Drawable imageMenu) {
            D.imageMenu2 = imageMenu;
            return this;
        }

        @SuppressWarnings("deprecation")
        public InitTitleBar.Builder setMenuImage2(Bitmap imageMenu) {
            D.imageMenu2 = new BitmapDrawable(imageMenu);
            return this;
        }

        // =========================添加事件监听=========================

        public InitTitleBar.Builder setBackListener(OnClickBackListener onClickBackListener) {
            D.onClickBackListener = onClickBackListener;
            return this;
        }

        public InitTitleBar.Builder setTitleListener(OnClickTitleListener onClickTitleListener) {
            D.onClickTitleListener = onClickTitleListener;
            return this;
        }

        public InitTitleBar.Builder setMenuListener(OnClickMenuListener onClickMenuListener) {
            D.onClickMenuListener = onClickMenuListener;
            return this;
        }

        // =========================创建标题栏=========================

        public InitTitleBar create() {
            D.create();
            return D;
        }
    }

    public OnClickBackListener onClickBackListener;

    public OnClickBackListener getOnClickBackListener() {
        return onClickBackListener;
    }

    public void setOnClickBackListener(OnClickBackListener onClickBackListener) {
        this.onClickBackListener = onClickBackListener;
    }

    /**
     * 返回监听回调接口
     */
    public interface OnClickBackListener {
        void onClickBack(View view);
    }

    public OnClickTitleListener onClickTitleListener;

    public OnClickTitleListener getOnClickTitleListener() {
        return onClickTitleListener;
    }

    public void setOnClickTitleListener(OnClickTitleListener onClickTitleListener) {
        this.onClickTitleListener = onClickTitleListener;
    }

    /**
     * 标题监听回调接口
     */
    public interface OnClickTitleListener {
        void onClickTitle(View view);
    }

    public OnClickMenuListener onClickMenuListener;


    public void setOnClickMenuListener(OnClickMenuListener onClickMenuListener) {
        this.onClickMenuListener = onClickMenuListener;
    }

    /**
     * 菜单监听回调接口
     */
    public interface OnClickMenuListener {
        void onClickMenu(View view);
    }
}
