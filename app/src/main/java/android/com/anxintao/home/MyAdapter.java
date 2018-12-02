package android.com.anxintao.home;

import android.com.anxintao.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * 创建时间: 2018/12/01 17:47 <br>
 * 作者: panwei <br>
 * 描述:
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

  private List<String> list;

  public MyAdapter(List<String> list) {
    this.list = list;
  }

  @Override
  public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_listivew_item, parent, false);
    MyAdapter.ViewHolder viewHolder = new MyAdapter.ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
    holder.mText.setText(list.get(position));
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    TextView mText;
    ViewHolder(View itemView) {
      super(itemView);
      mText = itemView.findViewById(R.id.tv_type);
    }
  }
}
