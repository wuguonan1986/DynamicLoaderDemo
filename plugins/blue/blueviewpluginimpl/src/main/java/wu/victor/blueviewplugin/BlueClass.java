package wu.victor.blueviewplugin;

import android.util.Log;

/**
 * Created by wuguonan on 2017/2/20 0020.
 */

public class BlueClass {
  String value = "blue";

  public void printLog() {
    Log.e(getClass().getSimpleName(), "value = " + value);
  }
}
