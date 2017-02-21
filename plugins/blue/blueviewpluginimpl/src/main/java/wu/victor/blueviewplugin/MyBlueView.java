package wu.victor.blueviewplugin;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import wu.victor.myviewinterface.MyBaseView;

/**
 * Created by wuguonan on 2017/2/14 0014.
 */

public class MyBlueView extends MyBaseView {
  public MyBlueView(Context context) {
    super(context);
    setBackgroundColor(Color.BLUE);
    setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        BlueClass blueClass = new BlueClass();
        blueClass.printLog();
      }
    });
  }

  @Override
  public void doAnimation() {
    RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
        Animation.RELATIVE_TO_SELF, 0.5f,
        Animation.RELATIVE_TO_SELF, 0.5f);
    rotateAnimation.setDuration(1000);
    startAnimation(rotateAnimation);
  }
}
