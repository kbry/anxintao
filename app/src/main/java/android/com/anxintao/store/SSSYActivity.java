package android.com.anxintao.store;

import android.com.anxintao.R;
import android.com.anxintao.tools.ToastUtil;
import android.com.anxintao.widget.OnItemClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class SSSYActivity extends FragmentActivity {

  private TextView mSR,mJM,mTVToday,mTVMonth;
  private ImageView mToday,mMonth;
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_sssy);
    initListView();
    initTab();
  }

  private void initTab(){
    mSR = (TextView)findViewById(R.id.tv_sr);
    mJM = (TextView)findViewById(R.id.tv_jm);
    mTVToday = (TextView)findViewById(R.id.tv_by_day);
    mTVMonth = (TextView)findViewById(R.id.tv_by_month);
    mToday = (ImageView)findViewById(R.id.iv_left);
    mMonth = (ImageView)findViewById(R.id.iv_right);
    mSR.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        mSR.setTextColor(Color.parseColor("#ffffffff"));
        mSR.setBackgroundColor(Color.parseColor("#ECC871"));
        mJM.setTextColor(Color.parseColor("#999999"));
        mJM.setBackgroundColor(Color.parseColor("#ffffffff"));
      }
    });
    mJM.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        mJM.setTextColor(Color.parseColor("#ffffffff"));
        mJM.setBackgroundColor(Color.parseColor("#ECC871"));
        mSR.setTextColor(Color.parseColor("#999999"));
        mSR.setBackgroundColor(Color.parseColor("#ffffffff"));
      }
    });
    findViewById(R.id.rl_today).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        mTVToday.setTextColor(Color.parseColor("#ECC871"));
        mToday.setImageDrawable(getResources().getDrawable(R.drawable.oval_yellow));
        mTVMonth.setTextColor(Color.parseColor("#999999"));
        mMonth.setImageDrawable(getResources().getDrawable(R.drawable.oval_gray));
      }
    });
    findViewById(R.id.rl_month).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        mTVMonth.setTextColor(Color.parseColor("#ECC871"));
        mMonth.setImageDrawable(getResources().getDrawable(R.drawable.oval_yellow));
        mTVToday.setTextColor(Color.parseColor("#999999"));
        mToday.setImageDrawable(getResources().getDrawable(R.drawable.oval_gray));
      }
    });
  }



  private RecyclerView listview;
  private void initListView(){
    listview = (RecyclerView)findViewById(R.id.rv_list);
    LinearLayoutManager
        layout = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
    layout.setSmoothScrollbarEnabled(true);
    layout.setAutoMeasureEnabled(true);
    listview.setLayoutManager(layout);
    listview.setHasFixedSize(true);
    listview.setNestedScrollingEnabled(false);
    //listview.addItemDecoration(new RecycleViewDivider(HomeFragment.this.getContext(),LinearLayoutManager.HORIZONTAL,60,getResources().getColor(android.R.color.white)));
    List<String> test = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      test.add(i+"test");
    }
    SSSYAdapter adapter = new SSSYAdapter(test);
    adapter.setOnViewItemClickListener(new OnItemClickListener() {
      @Override public void onItemClick(View view, int position) {
        ToastUtil.toast("---"+position);
        //Intent intent = new Intent(SSSYActivity.this, GoodDetailActivity.class);
        //intent.putExtra("goodid",position);
        //startActivity(intent);
      }
    });
    listview.setAdapter(adapter);
  }
}
