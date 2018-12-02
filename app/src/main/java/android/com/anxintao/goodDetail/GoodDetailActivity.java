package android.com.anxintao.goodDetail;

import android.app.Activity;
import android.com.anxintao.AnxintaoApplication;
import android.com.anxintao.R;
import android.com.anxintao.tools.ToastUtil;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.oragee.banners.BannerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class GoodDetailActivity extends Activity {

  private BannerView mBannerView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_good_detail);
    initBannerView();
    initPicListView();
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

  private void initPicListView(){
    LinearLayout picListContainer = findViewById(R.id.ll_img_container);
    //ImageView imageView = findViewById(R.id.iv_pic);
    //Picasso.with(AnxintaoApplication.getInstance()).load("http://img.hb.aicdn.com/5b591216952133a8b45b8fcba09c7f9f8c4731927531-Tj1dsT_fw658").into(imageView);
    //  <!--<ImageView-->
    //        <!--android:id="@+id/iv_pic"-->
    //        <!--android:adjustViewBounds="true"-->
    //        <!--android:scaleType="fitXY"-->
    //        <!--android:layout_width="match_parent"-->
    //        <!--android:layout_height="wrap_content"/>

    for (int i = 0; i <5 ; i++) {
      ImageView imageView = new ImageView(this);
      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
      imageView.setAdjustViewBounds(true);
      imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
          ViewGroup.LayoutParams.WRAP_CONTENT));
      Picasso.with(AnxintaoApplication.getInstance()).load("http://img.hb.aicdn.com/5b591216952133a8b45b8fcba09c7f9f8c4731927531-Tj1dsT_fw658").into(imageView);
      picListContainer.addView(imageView);
    }




  }





}
