package wu.victor.redviewplugin;

import android.util.Log;

/**
 * Created by wuguonan on 2017/2/20 0020.
 */

public class RedClass {
  String value = "red";

  public void printLog() {
    Log.e(getClass().getSimpleName(), "value = " + value);
  }
}
