package android.com.anxintao;

import android.com.anxintao.cart.CartFragment;
import android.com.anxintao.home.HomeFragment;
import android.com.anxintao.store.StoreFragment;
import android.com.anxintao.user.UserFragment;
import android.com.anxintao.widget.NoScrollViewPager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
  //声明ViewPager
  private NoScrollViewPager mViewPager;
  //适配器
  private FragmentPagerAdapter mAdapter;
  //装载Fragment的集合
  private List<Fragment> mFragments;

  //四个Tab对应的布局
  private LinearLayout mTabWeixin;
  private LinearLayout mTabFrd;
  private LinearLayout mTabAddress;
  private LinearLayout mTabSetting;

  //四个Tab对应的ImageButton
  private ImageButton mImgWeixin;
  private ImageButton mImgFrd;
  private ImageButton mImgAddress;
  private ImageButton mImgSetting;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_main);
    initViews();//初始化控件
    initEvents();//初始化事件
    initDatas();//初始化数据
  }

  private void initDatas() {
    mFragments = new ArrayList<>();
    //将四个Fragment加入集合中
    mFragments.add(new HomeFragment());
    mFragments.add(new StoreFragment());
    mFragments.add(new CartFragment());
    mFragments.add(new UserFragment());

    //初始化适配器
    mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
      @Override
      public Fragment getItem(int position) {//从集合中获取对应位置的Fragment
        return mFragments.get(position);
      }

      @Override
      public int getCount() {//获取集合中Fragment的总数
        return mFragments.size();
      }

    };
    //不要忘记设置ViewPager的适配器
    mViewPager.setAdapter(mAdapter);
    //设置ViewPager的切换监听
    mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      //页面滚动事件
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      //页面选中事件
      @Override
      public void onPageSelected(int position) {
        //设置position对应的集合中的Fragment
        mViewPager.setCurrentItem(position);
        resetImgs();
        selectTab(position);
      }

      @Override
      //页面滚动状态改变事件
      public void onPageScrollStateChanged(int state) {

      }
    });
  }

  private void initEvents() {
    //设置四个Tab的点击事件
    mTabWeixin.setOnClickListener(this);
    mTabFrd.setOnClickListener(this);
    mTabAddress.setOnClickListener(this);
    mTabSetting.setOnClickListener(this);

  }

  //初始化控件
  private void initViews() {
    mViewPager = (NoScrollViewPager) findViewById(R.id.id_viewpager);
    mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
    mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
    mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
    mTabSetting = (LinearLayout) findViewById(R.id.id_tab_setting);
    mImgWeixin = (ImageButton) findViewById(R.id.id_tab_weixin_img);
    mImgFrd = (ImageButton) findViewById(R.id.id_tab_frd_img);
    mImgAddress = (ImageButton) findViewById(R.id.id_tab_address_img);
    mImgSetting = (ImageButton) findViewById(R.id.id_tab_setting_img);

  }

  @Override
  public void onClick(View v) {
    //先将四个ImageButton置为灰色
    resetImgs();

    //根据点击的Tab切换不同的页面及设置对应的ImageButton为绿色
    switch (v.getId()) {
      case R.id.id_tab_weixin:
        selectTab(0);
        break;
      case R.id.id_tab_frd:
        selectTab(1);
        break;
      case R.id.id_tab_address:
        selectTab(2);
        break;
      case R.id.id_tab_setting:
        selectTab(3);
        break;
    }
  }

  private void selectTab(int i) {
    //根据点击的Tab设置对应的ImageButton为绿色
    switch (i) {
      case 0:
        mImgWeixin.setImageResource(R.drawable.ic_launcher_round);
        break;
      case 1:
        mImgFrd.setImageResource(R.drawable.ic_launcher_round);
        break;
      case 2:
        mImgAddress.setImageResource(R.drawable.ic_launcher_round);
        break;
      case 3:
        mImgSetting.setImageResource(R.drawable.ic_launcher_round);
        break;
    }
    //设置当前点击的Tab所对应的页面
    mViewPager.setCurrentItem(i);
  }

  //将四个ImageButton设置为灰色
  private void resetImgs() {
    mImgWeixin.setImageResource(R.drawable.ic_launcher_round);
    mImgFrd.setImageResource(R.drawable.ic_launcher_round);
    mImgAddress.setImageResource(R.drawable.ic_launcher_round);
    mImgSetting.setImageResource(R.drawable.ic_launcher_round);
  }
}