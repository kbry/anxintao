package android.com.anxintao.user;

import android.com.anxintao.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UserFragment extends Fragment {


  public UserFragment() {
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     View rootView = inflater.inflate(R.layout.fragment_user, container, false);
    rootView.findViewById(R.id.rl_user_rights).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(UserFragment.this.getActivity(),UserRightsIntroActivity.class);
        startActivity(intent);
      }
    });
    return rootView;


  }

}
