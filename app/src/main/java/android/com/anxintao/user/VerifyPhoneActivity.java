package android.com.anxintao.user;

import android.com.anxintao.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class VerifyPhoneActivity extends FragmentActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_verify_phone);
    findViewById(R.id.tv_next).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent =  new Intent(VerifyPhoneActivity.this,VerifyBankCardActivity.class);
        startActivity(intent);

      }
    });
  }
}
