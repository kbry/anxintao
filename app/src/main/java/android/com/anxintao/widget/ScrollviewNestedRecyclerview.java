package android.com.anxintao.widget;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * 创建时间: 2018/12/01 18:44 <br>
 * 作者: panwei <br>
 * 描述:
 */

/**
 * Created by zzq on 2017/3/17 0017.
 */

public class ScrollviewNestedRecyclerview extends NestedScrollView {
  private int downX;
  private int downY;
  private int mTouchSlop;

  public ScrollviewNestedRecyclerview(Context context) {
    super(context);
    mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
  }

  public ScrollviewNestedRecyclerview(Context context, AttributeSet attrs) {
    super(context, attrs);
    mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
  }

  public ScrollviewNestedRecyclerview(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
  }

  @Override
  public boolean onInterceptTouchEvent(MotionEvent e) {
    int action = e.getAction();
    switch (action) {
      case MotionEvent.ACTION_DOWN:
        downX = (int) e.getRawX();
        downY = (int) e.getRawY();
        break;
      case MotionEvent.ACTION_MOVE:
        int moveY = (int) e.getRawY();
        if (Math.abs(moveY - downY) > mTouchSlop) {
          return true;
        }
    }
    return super.onInterceptTouchEvent(e);
  }
}

