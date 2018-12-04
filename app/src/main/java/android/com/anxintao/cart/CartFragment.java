package android.com.anxintao.cart;

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
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

  private TextView mHandle;

  private RecyclerView mList;

  private boolean isEdit = false;
  private View rootView;

  public CartFragment() {
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    rootView = inflater.inflate(R.layout.fragment_cart, container, false);
    initView();
    initList();
    return rootView;
  }

  private void initView() {
    mHandle = rootView.findViewById(R.id.tv_handle);
    mHandle.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (isEdit) {
          doEditFinishMode();
        } else {
          doEditMode();
        }
        isEdit = !isEdit;
      }
    });
  }

  private void doEditMode() {
    mHandle.setText("完成");
    mHandle.setTextColor(getResources().getColor(android.R.color.white));
    mHandle.setBackground(getResources().getDrawable(R.drawable.text_red_rectangle));
  }

  private void doEditFinishMode() {
    mHandle.setText("管理");
    mHandle.setTextColor(getResources().getColor(android.R.color.black));
    mHandle.setBackground(getResources().getDrawable(R.drawable.text_gray_rectangle));
  }

  private void initList(){
    mList = rootView.findViewById(R.id.rv_list);
    LinearLayoutManager
        layout = new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false);
    layout.setSmoothScrollbarEnabled(true);
    layout.setAutoMeasureEnabled(true);
    mList.setLayoutManager(layout);
    mList.addItemDecoration(new RecycleViewDivider(CartFragment.this.getContext(),LinearLayoutManager.HORIZONTAL,1,getResources().getColor(android.R.color.transparent)));
    List<String> test = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      test.add(i+"test");
    }
    CartAdapter adapter = new CartAdapter(test);
    adapter.setOnViewItemClickListener(new OnItemClickListener() {
      @Override public void onItemClick(View view, int position) {
        ToastUtil.toast("---"+position);
        Intent intent = new Intent(CartFragment.this.getContext(), GoodDetailActivity.class);
        intent.putExtra("goodid",position);
        startActivity(intent);
      }
    });
    mList.setAdapter(adapter);
  }


}
