package cn.yhong.aframework.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by toushisx-08 on 2019/12/18.
 * 验证码获取工具类
 */

public class CountDownTimerUtils extends CountDownTimer {
    private TextView mTextView;

    private int isFirst;
    public CountDownTimerUtils(TextView textView, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.mTextView = textView;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mTextView.setClickable(false); //设置不可点击
        if(isFirst==0){
            mTextView.setText(millisUntilFinished / 1000 + "秒"); //设置倒计时时间
        }else {
            mTextView.setText("重新获取"+millisUntilFinished / 1000 + "秒"); //设置倒计时时间
        }

//        mTextView.setBackgroundResource(R.drawable.shape_solid_bg_50dp_check_phone); //设置按钮为灰色，这时是不能点击的

//        SpannableString spannableString = new SpannableString(mTextView.getText().toString()); //获取按钮上的文字
//        ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);
        /**
         * public void setSpan(Object what, int start, int end, int flags) {
         * 主要是start跟end，start是起始位置,无论中英文，都算一个。
         * 从0开始计算起。end是结束位置，所以处理的文字，包含开始位置，但不包含结束位置。
         */
//        spannableString.setSpan(span, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);//将倒计时的时间设置为红色
//        mTextView.setText(spannableString);
    }

    /**
     *  * 倒计时完成后调用
     *
     */
    @Override
    public void onFinish() {
        isFirst = 1;
        mTextView.setText("重新获取");
        mTextView.setClickable(true);//重新获得点击
//        mTextView.setBackgroundResource(R.drawable.shape_solid_orange_50dp); //还原背景色
    }
}
