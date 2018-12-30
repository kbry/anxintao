package android.com.anxintao.user;

import android.com.anxintao.R;
import android.com.anxintao.tools.ToastUtil;
import android.com.anxintao.widget.OnItemClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class MyWalletActivity extends FragmentActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my_wallet);
    initListView();
    findViewById(R.id.tv_problem).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(MyWalletActivity.this,ProblemLeftMoneyActivity.class);
        startActivity(intent);
      }
    });
    findViewById(R.id.tv_go_get_money).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(MyWalletActivity.this,GetMoneyActivity.class);
        startActivity(intent);
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
    //listview.addItemDecoration(new RecycleViewDivider(this,LinearLayoutManager.HORIZONTAL,1,getResources().getColor(android.R.color.transparent)));
    List<String> test = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      test.add(i+"test");
    }
    MyWalletTradeDetailAdapter adapter = new MyWalletTradeDetailAdapter(test);
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
