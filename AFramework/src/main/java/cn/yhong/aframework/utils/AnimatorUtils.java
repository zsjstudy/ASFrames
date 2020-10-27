package cn.yhong.aframework.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

/**
 * Created by toushisx-08 on 2019/12/19.
 */

public class AnimatorUtils {

    public static void setAnimarorShow(LinearLayout view){
        //沿x轴放大
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
        scaleXAnimator.setRepeatCount(0);
        scaleXAnimator.setRepeatMode(ValueAnimator.RESTART);

        //移动
        ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(view, "translationX", 260f, 0f);
        translationXAnimator.setRepeatCount(0);
        translationXAnimator.setRepeatMode(ValueAnimator.RESTART);

        //透明度
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
        animator.setRepeatCount(0);
        animator.setRepeatMode(ValueAnimator.RESTART);

        AnimatorSet set = new AnimatorSet();
        //同时沿X,Y轴放大，且改变透明度，然后移动
        set.setInterpolator(new DecelerateInterpolator());
        set.play(scaleXAnimator).with(animator).with(translationXAnimator);
        //set.play(scaleXAnimator).with(scaleYAnimator);
        //都设置3s，也可以为每个单独设置
        set.setDuration(400);
        set.start();
    }

    public static void setAnimarorHide(LinearLayout view){
        //沿x轴放大
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f);
        scaleXAnimator.setRepeatCount(0);
        scaleXAnimator.setRepeatMode(ValueAnimator.RESTART);

        //移动
        ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(view, "translationX", 0f, 260f);
        translationXAnimator.setRepeatCount(0);
        translationXAnimator.setRepeatMode(ValueAnimator.RESTART);

        //透明度
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f);
        animator.setRepeatCount(0);
        animator.setRepeatMode(ValueAnimator.RESTART);

        AnimatorSet set = new AnimatorSet();
        //同时沿X,Y轴放大，且改变透明度，然后移动
        set.setInterpolator(new DecelerateInterpolator());
        set.play(scaleXAnimator).with(animator).with(translationXAnimator);
        //set.play(scaleXAnimator).with(scaleYAnimator);
        //都设置3s，也可以为每个单独设置
        set.setDuration(400);
        set.start();
    }
}
