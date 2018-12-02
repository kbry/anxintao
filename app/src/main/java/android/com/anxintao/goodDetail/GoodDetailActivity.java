package android.com.anxintao.goodDetail;

import android.app.Activity;
import android.com.anxintao.R;
import android.com.anxintao.tools.ToastUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.oragee.banners.BannerView;
import java.util.ArrayList;
import java.util.List;

public class GoodDetailActivity extends Activity {

  private BannerView mBannerView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_good_detail);
    initBannerView();
  }

  private void initBannerView() {
    List<View> imageList = new ArrayList<>(2);
    for (int i = 0; i < 2; i++) {
      ImageView imageview = new ImageView(this);
      imageview.setBackground(getResources().getDrawable(R.drawable.ic_launcher));
      //PicUtil.loadImage(url,imageview);
      imageList.add(imageview);
      imageview.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          ToastUtil.toast("pppppppp");
        }
      });
    }
    mBannerView = findViewById(R.id.bannerview);
    mBannerView.setViewList(imageList);
    mBannerView.startLoop(true);
  }
}
