
package com.zhuke.zdy1.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * 
 * 自定义密码输入框
 * 
 * @author zhangke
 * 
 */
public class PassWordEditText1 extends android.support.v7.widget.AppCompatEditText {

	/**
	 * 间隔
	 */
	private final int PWD_SPACING = 1;
	/**
	 * 密码大小
	 */
	private final int PWD_SIZE = 5;
	/**
	 * 密码长度
	 */
	private final int PWD_LENGTH = 6;
	/**
	 * 上下文
	 */
	private Context mContext;
	/**
	 * 宽度
	 */
	private int mWidth;
	/**
	 * 高度
	 */
	private int mHeight;
	/**
	 * 密码框
	 */
	private Rect mRect;

	/**
	 * 密码画笔
	 */
	private Paint mPwdPaint;

	/**
	 * 密码框画笔
	 */
	private Paint mRectPaint;
	/**
	 * 密码框画笔
	 */
	private Paint textPaint;
	/**
	 * 输入的密码长度
	 */
	private int mInputLength;

	/**
	 * 输入结束监听
	 */
	private OnInputFinishListener mOnInputFinishListener;

	/**
	 * 输入的数字
	 */
	private String num;
	/**
	 * 构造方法
	 *
	 * @param context
	 * @param attrs
	 */
	public PassWordEditText1(Context context, AttributeSet attrs) {
		super(context, attrs);

		// 初始化密码画笔
		mPwdPaint = new Paint();
		mPwdPaint.setColor(Color.BLACK);
		mPwdPaint.setStyle(Paint.Style.FILL);
		mPwdPaint.setAntiAlias(true);
		// 初始化密码框
		mRectPaint = new Paint();
		mRectPaint.setStyle(Paint.Style.STROKE);
		mRectPaint.setColor(Color.LTGRAY);
		mRectPaint.setAntiAlias(true);
		//绘制密码
		textPaint = new Paint();
		textPaint.setAntiAlias(true);
		textPaint.setTextSize(dip2px(context, 16));
	}
	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	private  int dip2px(Context context, float dpValue) {
		try {

			float scale = context.getResources().getDisplayMetrics().density;
			return (int) (dpValue * scale + 0.5f * (dpValue >= 0 ? 1 : -1));
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mWidth = getWidth();
		mHeight = getHeight();

		// 这三行代码非常关键，大家可以注释点在看看效果
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
		canvas.drawRect(0, 0, mWidth, mHeight, paint);

		// 计算每个密码框宽度
		int rectWidth = (mWidth - PWD_SPACING * (PWD_LENGTH - 1)) / PWD_LENGTH;
		// 绘制密码框
		for (int i = 0; i < PWD_LENGTH; i++) {
			int left = (rectWidth + PWD_SPACING) * i;
			int top = 2;
			int right = left + rectWidth;
			int bottom = mHeight - top;
			mRect = new Rect(left, top, right, bottom);
			canvas.drawRect(mRect, mRectPaint);
		}

		// 绘制密码
		for (int i = 0; i < mInputLength; i++) {
			int cx = rectWidth / 2 + (rectWidth + PWD_SPACING) * i;
			int cy = mHeight / 2;
			//如果要显示的是密码样式的 需要放开这句代码 这里输入的就是圆点
			canvas.drawCircle(cx, cy, PWD_SIZE, mPwdPaint);
			//诸如验证码之类的需要显示明文的 用下面的方法  这里以明文为例
//			String numStr = getNum();//获取输入数字
			//这里根据不同的位置 截取显示不同的字符串  因为字符串长度不够 就采取笨方法处理，
			//优化的话可以将字符串转换成集合或者数字根据索引来展示 但是需要注意的是集合长度输入过程中是不固定的
//			switch (i) {
//			case 0:
////				String num1 = numStr.substring(0, 1);
//				canvas.drawText(num1, cx, cy,
//						textPaint);
//				break;
//			case 1:
//				String num2 = numStr.substring(1, 2);
//				canvas.drawText(num2, cx, cy,
//						textPaint);
//				break;
//			case 2:
//				String num3 = numStr.substring(2, 3);
//				canvas.drawText(num3, cx, cy,
//						textPaint);
//				break;
//			case 3:
//				String num4 = numStr.substring(numStr.length()-1, numStr.length());
//				canvas.drawText(num4, cx, cy,
//						textPaint);
//				break;
//
//			default:
//				break;
//			}
		}
	}

	@Override
	protected void onTextChanged(CharSequence text, int start,
                                 int lengthBefore, int lengthAfter) {
		super.onTextChanged(text, start, lengthBefore, lengthAfter);
		//对输入长度做限制 防止输入数据不准确
		if (text.toString().length() >PWD_LENGTH ) {
			return;
		} else {
			setNum(num);
			this.mInputLength = text.toString().length();
			setNum(text.toString());
			invalidate();
			if (mInputLength == PWD_LENGTH && mOnInputFinishListener != null) {
				mOnInputFinishListener.onInputFinish(text.toString());
			}
		}
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}

	/**
	 * 长度达到指定场地后的回调接口
	* @function:
	* @author zhangkx
	* @date 2017-3-17 下午5:52:59
	* @version V1.0
	 */
	public interface OnInputFinishListener {
		/**
		 * 密码输入结束监听
		 *
		 * @param password
		 */
		void onInputFinish(String password);
	}

	/**
	 * 设置输入完成监听
	 *
	 * @param onInputFinishListener
	 */
	public void setOnInputFinishListener(
			OnInputFinishListener onInputFinishListener) {
		this.mOnInputFinishListener = onInputFinishListener;
	}

}
