package cn.yhong.aframework.utils;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 17639 on 2020/5/20.
 * 获取屏幕点击位置坐标
 */

public class CorrdinateUtils {

    /**
     * 获取点击屏幕的位置
     *
     * @param event
     */
    public static void getXY(MotionEvent event) {
        try {
            switch (event.getAction()) {
                /**
                 * 触屏位置
                 */
                case MotionEvent.ACTION_DOWN:
                    float rawX = event.getRawX();
                    float rawY = event.getRawY();

                    int x = (int) rawX;
                    int y = (int) rawY;

                    break;
                /**
                 * 触屏实时位置
                 */
                case MotionEvent.ACTION_MOVE:
                    break;
                /**
                 * 离开屏幕的位置
                 */
                case MotionEvent.ACTION_UP:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取view相对于屏幕的坐标
     *
     * @param view
     */
    public static void getViewCoor(View view) {
        //获取View的坐标位置    https://www.jianshu.com/p/e4d9f98e4610
        int[] location = new int[2];
//      view.getLocationInWindow(location); // 获取控件 相对 窗口Window 的位置
        view.getLocationOnScreen(location);  //获得 View 相对 屏幕 的绝对坐标
        int x = location[0]; // view距离window 左边的距离（即x轴方向）
        int y = location[1]; // view距离window 顶边的距离（即y轴方向）
    }

    /**
     * x轴点击位置
     *
     * @return
     */
    public static int getX(MotionEvent event) {
        try {
            int x = 0;
            switch (event.getAction()) {
                /**
                 * 触屏位置
                 */
                case MotionEvent.ACTION_DOWN:
                    float rawX = event.getRawX();
                    x = (int) rawX;
                    break;
                /**
                 * 触屏实时位置
                 */
                case MotionEvent.ACTION_MOVE:
                    break;
                /**
                 * 离开屏幕的位置
                 */
                case MotionEvent.ACTION_UP:
                    break;
            }
            return x;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * y轴点击位置
     *
     * @return
     */
    public static int getY(MotionEvent event) {
        try {
            int y = 0;
            switch (event.getAction()) {
                /**
                 * 触屏位置
                 */
                case MotionEvent.ACTION_DOWN:
                    float rawY = event.getRawY();
                    y = (int) rawY;
                    break;
                /**
                 * 触屏实时位置
                 */
                case MotionEvent.ACTION_MOVE:
                    break;
                /**
                 * 离开屏幕的位置
                 */
                case MotionEvent.ACTION_UP:
                    break;
            }
            return y;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
