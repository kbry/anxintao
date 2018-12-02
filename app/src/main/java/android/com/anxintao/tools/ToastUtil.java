package android.com.anxintao.tools;

import android.com.anxintao.AnxintaoApplication;
import android.widget.Toast;

/**
 * 创建时间: 2018/12/01 13:16 <br>
 * 作者: panwei <br>
 * 描述:
 */

public class ToastUtil {

  public static void toast(String toast){
    Toast.makeText(AnxintaoApplication.getInstance(),toast,Toast.LENGTH_SHORT).show();
  }
}
