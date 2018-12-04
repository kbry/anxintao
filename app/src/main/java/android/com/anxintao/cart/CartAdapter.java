package android.com.anxintao.cart;

import android.com.anxintao.R;
import android.com.anxintao.widget.OnItemClickListener;
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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{

  private List<String> list;

  private OnItemClickListener mOnItemClickListener;
  public CartAdapter(List<String> list) {
    this.list = list;
  }

  public void setOnViewItemClickListener(OnItemClickListener onItemClickListener){
    this.mOnItemClickListener = onItemClickListener;
  }

  @Override
  public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_listview_item, parent, false);
    CartAdapter.ViewHolder viewHolder = new CartAdapter.ViewHolder(view);
    viewHolder.mItemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        mOnItemClickListener.onItemClick(v,(int)v.getTag());
      }
    });
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(CartAdapter.ViewHolder holder, int position) {
    holder.mText.setText(list.get(position));
    holder.mItemView.setTag(position);
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    TextView mText;
    View mItemView;
    ViewHolder(View itemView) {
      super(itemView);
      mItemView = itemView;
      mText = itemView.findViewById(R.id.tv_type);
    }
  }

}
