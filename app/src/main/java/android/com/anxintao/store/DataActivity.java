package android.com.anxintao.store;

import android.com.anxintao.R;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class DataActivity extends FragmentActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_data);
    initDays();
  }

  private TextView today, _30day;

  private void initDays() {
    today = findViewById(R.id.tv_today);
    _30day = findViewById(R.id.tv_30day);
    today.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        _30day.setBackgroundColor(Color.parseColor("#ffffff"));
        _30day.setTextColor(Color.parseColor("#999999"));
        today.setBackgroundColor(Color.parseColor("#ECC871"));
        today.setTextColor(Color.parseColor("#ffffff"));
      }
    });
    _30day.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        _30day.setBackgroundColor(Color.parseColor("#ECC871"));
        _30day.setTextColor(Color.parseColor("#ffffff"));
        today.setBackgroundColor(Color.parseColor("#ffffff"));
        today.setTextColor(Color.parseColor("#999999"));
      }
    });
  }
}
