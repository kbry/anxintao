package android.com.anxintao.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 创建时间: 2018/12/01 14:02 <br>
 * 作者: panwei <br>
 * 描述:
 */

public class NoScrollViewPager extends ViewPager {

  private boolean isCanScroll = false;

  public NoScrollViewPager(Context context) {
    super(context);
  }

  public NoScrollViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override public boolean onInterceptTouchEvent(MotionEvent ev) {
    if(isCanScroll){
      return super.onInterceptTouchEvent(ev);
    }else{
      return false;
    }

  }

  @Override public boolean onTouchEvent(MotionEvent ev) {
    if(isCanScroll){
      return super.onTouchEvent(ev);
    }else {
      return false;
    }

  }
}
