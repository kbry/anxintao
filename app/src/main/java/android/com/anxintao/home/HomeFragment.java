package android.com.anxintao.home;

import android.com.anxintao.R;
import android.com.anxintao.goodDetail.GoodDetailActivity;
import android.com.anxintao.tools.ToastUtil;
import android.com.anxintao.widget.RationItemView;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.oragee.banners.BannerView;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment  {

  private BannerView mBannerView;

  public static HomeFragment newInstance(String param1, String param2) {
    HomeFragment fragment = new HomeFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  public HomeFragment() {
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
    }
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);
    initBannerView(view);
    initRatioItems(view);
    initListView(view);
    return view;
  }

  private void initBannerView(View view) {
    List<View> imageList = new ArrayList<>(2);
    for (int i = 0; i < 2; i++) {
      ImageView imageview = new ImageView(HomeFragment.this.getContext());
      imageview.setBackground(getResources().getDrawable(R.drawable.ic_launcher));
      //PicUtil.loadImage(url,imageview);
      imageList.add(imageview);
      imageview.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          ToastUtil.toast("pppppppp");
        }
      });
    }
    mBannerView = view.findViewById(R.id.bannerview);
    mBannerView.setViewList(imageList);
    mBannerView.startLoop(true);
  }

  private RationItemView getRationView() {
    RationItemView itemView = new RationItemView(HomeFragment.this.getContext());
    LinearLayout.LayoutParams params =
        new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
    params.weight = 1;
    params.gravity = Gravity.CENTER_HORIZONTAL;
    itemView.setLayoutParams(params);
    return itemView;
  }

  private void initRatioItems(View view) {
    LinearLayout radionLL = (LinearLayout) view.findViewById(R.id.ll_radio);
    final RationItemView item1 = getRationView();
    item1.setItem("热销", R.drawable.ic_launcher, true);
    final RationItemView item2 = getRationView();
    item2.setItem("生鲜", R.drawable.ic_launcher, false);
    final RationItemView item3 = getRationView();
    item3.setItem("食品", R.drawable.ic_launcher, false);
    final RationItemView item4 = getRationView();
    item4.setItem("生活", R.drawable.ic_launcher, false);

    radionLL.addView(item1);
    radionLL.addView(item2);
    radionLL.addView(item3);
    radionLL.addView(item4);
    item1.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        item1.setItemChecked(true);
        item2.setItemChecked(false);
        item3.setItemChecked(false);
        item4.setItemChecked(false);
        refreshContent(0);
      }
    });
    item2.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        item1.setItemChecked(false);
        item2.setItemChecked(true);
        item3.setItemChecked(false);
        item4.setItemChecked(false);
        refreshContent(1);
      }
    });
    item3.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        item1.setItemChecked(false);
        item2.setItemChecked(false);
        item3.setItemChecked(true);
        item4.setItemChecked(false);
        refreshContent(2);
      }
    });
    item4.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        item1.setItemChecked(false);
        item2.setItemChecked(false);
        item3.setItemChecked(false);
        item4.setItemChecked(true);
        refreshContent(3);
      }
    });
  }

  private void initListView(View view){
    RecyclerView listview = view.findViewById(R.id.rv_list);
    LinearLayoutManager layout = new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false);
    layout.setSmoothScrollbarEnabled(true);
    layout.setAutoMeasureEnabled(true);
    listview.setLayoutManager(layout);
    listview.setHasFixedSize(true);
    listview.setNestedScrollingEnabled(false);
    //listview.addItemDecoration(new RecycleViewDivider(HomeFragment.this.getContext(),LinearLayoutManager.HORIZONTAL,60,getResources().getColor(android.R.color.white)));
    List<String>  test = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      test.add(i+"test");
    }
    MyAdapter adapter = new MyAdapter(test);
    adapter.setOnViewItemClickListener(new MyAdapter.OnItemClickListener() {
      @Override public void onItemClick(View view, int position) {
        ToastUtil.toast("---"+position);
        Intent intent = new Intent(HomeFragment.this.getContext(), GoodDetailActivity.class);
        intent.putExtra("goodid",position);
        startActivity(intent);
      }
    });
    listview.setAdapter(adapter);
  }


  private void refreshContent(int position){

  }

}
