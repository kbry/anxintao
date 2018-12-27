package android.com.anxintao.store;

import android.com.anxintao.R;
import android.com.anxintao.tools.ToastUtil;
import android.com.anxintao.widget.OnItemClickListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import java.util.ArrayList;
import java.util.List;

public class CustomerOrderActivity extends FragmentActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_customer_order);
    initListView();
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
    CustomerOrderAdapter adapter = new CustomerOrderAdapter(test);
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
