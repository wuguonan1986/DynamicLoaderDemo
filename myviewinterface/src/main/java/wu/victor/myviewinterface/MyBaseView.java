package wu.victor.myviewinterface;

import android.content.Context;
import android.view.View;

/**
 * Created by wuguonan on 2017/2/14 0014.
 */

public abstract class MyBaseView extends View {
  public MyBaseView(Context context) {
    super(context);
  }

  public abstract void doAnimation();

}
