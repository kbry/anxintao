package android.com.anxintao;

import android.app.Application;

/**
 * 创建时间: 2018/12/01 13:09 <br>
 * 作者: panwei <br>
 * 描述:
 */

public class AnxintaoApplication extends Application {

  private static AnxintaoApplication _instance = new AnxintaoApplication();
  public AnxintaoApplication() {
  }

  public static AnxintaoApplication getInstance(){
    return _instance;
  }

  @Override public void onCreate() {
    super.onCreate();
    _instance = this;
  }
}
