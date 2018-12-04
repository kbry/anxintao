package android.com.anxintao.widget;

import android.com.anxintao.R;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

/**
 * 创建时间: 2018/12/04 23:56 <br>
 * 作者: panwei <br>
 * 描述:
 */

public class AddRedView extends FrameLayout{

  public AddRedView(Context context) {
    super(context);
    initView(context);
  }

  public AddRedView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    initView(context);
  }

  public AddRedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initView(context);
  }

  private void initView(Context context){
    LayoutInflater.from(context).inflate(R.layout.add_red_layout,this);
  }


}
