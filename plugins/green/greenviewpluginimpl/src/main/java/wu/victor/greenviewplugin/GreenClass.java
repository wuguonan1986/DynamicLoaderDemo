package wu.victor.greenviewplugin;

import android.util.Log;

/**
 * Created by wuguonan on 2017/2/20 0020.
 */

public class GreenClass {
  String value = "green";

  public void printLog() {
    Log.e(getClass().getSimpleName(), "value = " + value);
  }
}
