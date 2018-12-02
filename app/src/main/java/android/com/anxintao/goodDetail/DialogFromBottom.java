package android.com.anxintao.goodDetail;

import android.app.Dialog;
import android.com.anxintao.R;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

/**
 * 创建时间: 2018/12/02 16:46 <br>
 * 作者: panwei <br>
 * 描述:
 */

public class DialogFromBottom extends Dialog {

  private Context context;
  //这里的view其实可以替换直接传layout过来的 因为各种原因没传(lan)
  public DialogFromBottom(Context context) {
    super(context, R.style.MyDialog);
    this.context = context;

  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.add_to_cart_dialog);//这行一定要写在前面
    setCancelable(true);//点击外部不可dismiss
    setCanceledOnTouchOutside(true);
    Window window = this.getWindow();
    window.setGravity(Gravity.BOTTOM);
    WindowManager.LayoutParams params = window.getAttributes();
    params.width = WindowManager.LayoutParams.MATCH_PARENT;
    params.height = WindowManager.LayoutParams.WRAP_CONTENT;
    window.setAttributes(params);
  }
}