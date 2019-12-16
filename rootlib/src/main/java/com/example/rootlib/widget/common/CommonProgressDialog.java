package com.example.rootlib.widget.common;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.example.rootlib.R;

/**
 * 说明：进度提示框
 *
 * @author guolei
 */
public class CommonProgressDialog extends Dialog {

    /**
     * 动画切换间隔
     */
    private int STEP_DURATION = 40;
    /**
     * 动画修饰器 -- 匀速
     */
    private static final Interpolator DEFAULT_INTERPOLATOR = new LinearInterpolator();

    /**
     * 文字光影起始位置
     */
    private static final float start = 10.0f;
    /**
     * 光影变化上限
     */
    private static final float dest = 300.0f;

    /**
     * 当前动画步数
     */
    private int mCurrentStep = 0;
    /**
     * 循环周期（即多少次为一次动画周期）
     */
    private int mSteps = 32;
    /**
     * 动画播放方向，用于控制“从开头到结束再从结束返回开头”的动画效果，结合{@link CommonProgressDialog#mCurrentStep}使用
     */
    private boolean forward = true;
    /**
     * 默认布局id
     */
    public static int default_layout_id = R.layout.layout_dialog_common_loading;

    public CommonProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    /**
     * 动画效果计算及渲染
     */
    private Runnable mStepper = new Runnable() {

        @Override
        public void run() {
            // 计算新的文字渐变起始位置
            float fraction = DEFAULT_INTERPOLATOR.getInterpolation(mCurrentStep / (float) mSteps);
            float newValue = start + (dest - start) * fraction;
            // 执行文字光影渐变动画
            onAnimationStep(newValue);

            // 根据动画“正”，“反”计算执行当前执行步数，并执行动画
            if (forward) {                              // 正向
                if (mCurrentStep < mSteps) {    // 一个周期内
                    mCurrentStep++;
                } else {
                    forward = false;
                }
            } else {                                    // 反向
                if (mCurrentStep > 0) {
                    mCurrentStep--;
                } else {
                    forward = true;
                }
            }

            schedule(true);
        }
    };

    /**
     * 当动画执行的时候，为中央Message的TextView设置光影轮播效果
     *
     * @param value 本次效果开始渐变的x坐标，y默认
     */
    private void onAnimationStep(float value) {
        TextView txt = (TextView) this.findViewById(R.id.common_pdialog_message_tv);
        Shader shader = new RadialGradient(value, 20.0f, 50.0f, Color.WHITE, Color.GRAY, TileMode.CLAMP);
        txt.getPaint().setShader(shader);
        txt.invalidate();
    }

    /**
     * 通过handler发送动画执行通知
     *
     * @param delayed 是否延时发送
     */
    private void schedule(boolean delayed) {
        TextView mView = (TextView) this.findViewById(R.id.common_pdialog_message_tv);
        Handler handler = mView.getHandler();
        if (handler != null) {
            if (delayed) {
                handler.postDelayed(mStepper, STEP_DURATION);
            } else {
                handler.post(mStepper);
            }
        }
    }

    /**
     * 说明：设置要显示的文本
     *
     * @param message
     */
    public void setMessage(CharSequence message) {
        if (message != null && message.length() > 0) {
            findViewById(R.id.common_pdialog_message_tv).setVisibility(View.VISIBLE);
            TextView txt = (TextView) findViewById(R.id.common_pdialog_message_tv);
            txt.setText(message);
            txt.invalidate();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {                             // 获得焦点，继续执行
            this.mCurrentStep = 0;
            this.schedule(false);
        } else {                                    // 失去焦点，移除循环通知
            TextView mView = (TextView) this.findViewById(R.id.common_pdialog_message_tv);
            Handler handler = mView.getHandler();
            handler.removeCallbacks(this.mStepper);
        }
    }

    /**
     * 说明:创建对话框，但不显示
     * @param context 上下文
     * @param message 文本 -- 为空时不显示TextView
     * @return CommonProgressDialog
     */
    public static CommonProgressDialog create(Context context, CharSequence message) {
        final CommonProgressDialog dialog = new CommonProgressDialog(context, R.style.CommonProgressDialog);
        // 绑定布局
        dialog.setContentView(default_layout_id);

        if (message == null || message.length() == 0) {         // 为空时不显示TextView
            dialog.findViewById(R.id.common_pdialog_message_tv).setVisibility(View.GONE);
        } else {                                                // 显示文字
            TextView txt = (TextView) dialog.findViewById(R.id.common_pdialog_message_tv);
            txt.setText(message);
        }

        // 居中显示
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;

        // 以下为背景变暗，暂时不用
        /*WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount = .3f;
        dialog.getWindow().setAttributes(lp);
		dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);*/

        return dialog;
    }
}
