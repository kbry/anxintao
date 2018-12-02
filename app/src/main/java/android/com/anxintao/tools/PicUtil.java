package android.com.anxintao.tools;

import android.com.anxintao.AnxintaoApplication;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/**
 * 创建时间: 2017/10/01 12:02 <br>
 * 作者: panwei <br>
 * 描述:
 */

public class PicUtil {

  public static void loadImage(Uri url,ImageView imageView){
    if(!TextUtils.isEmpty(url.toString()) && imageView != null){
      Picasso.with(AnxintaoApplication.getInstance()).load(url).into(imageView);
    }
  }

  public static void loadImage(String url,ImageView imageView){
    if(!TextUtils.isEmpty(url) && imageView != null){
      Picasso.with(AnxintaoApplication.getInstance()).load(url).fit().into(imageView);
    }
  }

}
