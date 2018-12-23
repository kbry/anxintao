package android.com.anxintao;

import android.com.anxintao.cart.CartFragment;
import android.com.anxintao.home.HomeFragment;
import android.com.anxintao.store.StoreFragment;
import android.com.anxintao.user.UserFragment;
import android.com.anxintao.widget.NoScrollViewPager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
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
  private ImageButton mButton1;
  private ImageButton mButton2;
  private ImageButton mButton3;
  private ImageButton mButton4;
  private TextView mText1,mText2,mText3,mText4;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_main);
    //initWindows();
    initViews();//初始化控件
    initEvents();//初始化事件
    initDatas();//初始化数据
  }

  private void initWindows() {
    Window window = getWindow();
    int color = getResources().getColor(android.R.color.transparent);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
          | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
      window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
          | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
          | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
      window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      //设置状态栏颜色
      window.setStatusBarColor(color);
      //设置导航栏颜色
      window.setNavigationBarColor(color);
      ViewGroup contentView = ((ViewGroup) findViewById(android.R.id.content));
      View childAt = contentView.getChildAt(0);
      if (childAt != null) {
        childAt.setFitsSystemWindows(true);
      }
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      //透明状态栏
      window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      //透明导航栏
      window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
      //设置contentview为fitsSystemWindows
      ViewGroup contentView = (ViewGroup) findViewById(android.R.id.content);
      View childAt = contentView.getChildAt(0);
      if (childAt != null) {
        childAt.setFitsSystemWindows(true);
      }
      //给statusbar着色
      View view = new View(this);
      view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(this)));
      view.setBackgroundColor(color);
      contentView.addView(view);
    }
  }

  /**
   * 获取状态栏高度
   *
   * @param context context
   * @return 状态栏高度
   */
  private static int getStatusBarHeight(Context context) {
    // 获得状态栏高度
    int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
    return context.getResources().getDimensionPixelSize(resourceId);
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
    mButton1 = (ImageButton) findViewById(R.id.id_tab1);
    mButton2 = (ImageButton) findViewById(R.id.id_tab2);
    mButton3 = (ImageButton) findViewById(R.id.id_tab3);
    mButton4 = (ImageButton) findViewById(R.id.id_tab4);
    mText1 = (TextView) findViewById(R.id.tv_text1);
    mText2 = (TextView) findViewById(R.id.tv_text2);
    mText3 = (TextView) findViewById(R.id.tv_text3);
    mText4 = (TextView) findViewById(R.id.tv_text4);
    selectTab(0);
  }

  @Override
  public void onClick(View v) {
    //先将四个ImageButton置为灰色
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
        mButton1.setImageResource(R.drawable.shouye_pressed);
        mText1.setTextColor(Color.parseColor("#F53C28"));
        mButton2.setImageResource(R.drawable.hehuoren_normal);
        mText2.setTextColor(Color.parseColor("#B7B7B7"));
        mButton3.setImageResource(R.drawable.gouwu_normal);
        mText3.setTextColor(Color.parseColor("#B7B7B7"));
        mButton4.setImageResource(R.drawable.geren_normal);
        mText4.setTextColor(Color.parseColor("#B7B7B7"));
        break;
      case 1:
        mButton1.setImageResource(R.drawable.shouye_normal);
        mText1.setTextColor(Color.parseColor("#B7B7B7"));
        mButton2.setImageResource(R.drawable.hehuoren_pressed);
        mText2.setTextColor(Color.parseColor("#F53C28"));
        mButton3.setImageResource(R.drawable.gouwu_normal);
        mText3.setTextColor(Color.parseColor("#B7B7B7"));
        mButton4.setImageResource(R.drawable.geren_normal);
        mText4.setTextColor(Color.parseColor("#B7B7B7"));
        break;
      case 2:
        mButton1.setImageResource(R.drawable.shouye_normal);
        mText1.setTextColor(Color.parseColor("#B7B7B7"));
        mButton2.setImageResource(R.drawable.hehuoren_normal);
        mText2.setTextColor(Color.parseColor("#B7B7B7"));
        mButton3.setImageResource(R.drawable.gouwu_pressed);
        mText3.setTextColor(Color.parseColor("#F53C28"));
        mButton4.setImageResource(R.drawable.geren_normal);
        mText4.setTextColor(Color.parseColor("#B7B7B7"));
        break;
      case 3:
        mButton1.setImageResource(R.drawable.shouye_normal);
        mText1.setTextColor(Color.parseColor("#B7B7B7"));
        mButton2.setImageResource(R.drawable.hehuoren_normal);
        mText2.setTextColor(Color.parseColor("#B7B7B7"));
        mButton3.setImageResource(R.drawable.gouwu_normal);
        mText3.setTextColor(Color.parseColor("#B7B7B7"));
        mButton4.setImageResource(R.drawable.geren_pressed);
        mText4.setTextColor(Color.parseColor("#F53C28"));
        break;
    }
    //设置当前点击的Tab所对应的页面
    mViewPager.setCurrentItem(i);
  }

}