package android.com.anxintao.widget;

import android.com.anxintao.R;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 创建时间: 2018/12/01 17:02 <br>
 * 作者: panwei <br>
 * 描述:
 */

public class RationItemView extends LinearLayout{

  private TextView mTextView;

  private ImageView mImageView;

  private View mLineView;

  public RationItemView(Context context) {
    super(context);
    LayoutInflater.from(context).inflate(R.layout.head_radio_item,this);
    mTextView = (TextView)findViewById(R.id.tv_content);
    mImageView = (ImageView)findViewById(R.id.iv_icon);
    mLineView = findViewById(R.id.v_line);
    setGravity(Gravity.CENTER_HORIZONTAL);
  }

  public void setItem(String content,int imgid,boolean isChecked){
    mTextView.setText(content);
    mImageView.setImageDrawable(getResources().getDrawable(imgid));
    setItemChecked(isChecked);
  }

  public void setItemChecked(boolean isChecked){
    mLineView.setVisibility(isChecked?View.VISIBLE:View.GONE);
  }


}
