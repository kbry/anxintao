package android.com.anxintao.store;

import android.com.anxintao.R;
import android.com.anxintao.goodDetail.GoodDetailActivity;
import android.com.anxintao.tools.ToastUtil;
import android.com.anxintao.widget.OnItemClickListener;
import android.com.anxintao.widget.RecycleViewDivider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class StoreFragment extends Fragment {

  private View rootView;

  private RecyclerView mList;

  public StoreFragment() {
  }
  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_store, container, false);
    initList();
    rootView.findViewById(R.id.ll_data_ana).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(StoreFragment.this.getContext(),DataActivity.class);
        startActivity(intent);
      }
    });
    return rootView;
  }



  private void initList(){
    mList = rootView.findViewById(R.id.rv_list);
    LinearLayoutManager
        layout = new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false);
    layout.setSmoothScrollbarEnabled(true);
    layout.setAutoMeasureEnabled(true);
    mList.setLayoutManager(layout);
    mList.addItemDecoration(new RecycleViewDivider(StoreFragment.this.getContext(),LinearLayoutManager.HORIZONTAL,45,getResources().getColor(android.R.color.white)));
    List<String> test = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      test.add(i+"test");
    }
    StoreOwnerItemAdapter adapter = new StoreOwnerItemAdapter(test);
    adapter.setOnViewItemClickListener(new OnItemClickListener() {
      @Override public void onItemClick(View view, int position) {
        ToastUtil.toast("---"+position);
        Intent intent = new Intent(StoreFragment.this.getContext(), GoodDetailActivity.class);
        intent.putExtra("goodid",position);
        startActivity(intent);
      }
    });
    mList.setAdapter(adapter);
  }

}
