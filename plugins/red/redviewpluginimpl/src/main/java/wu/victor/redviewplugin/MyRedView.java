package wu.victor.redviewplugin;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import wu.victor.myviewinterface.MyBaseView;

/**
 * Created by wuguonan on 2017/2/14 0014.
 */

public class MyRedView extends MyBaseView {

  public MyRedView(Context context) {
    super(context);
    setBackgroundColor(Color.RED);
    setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        RedClass redClass = new RedClass();
        redClass.printLog();
      }
    });
  }

  @Override
  public void doAnimation() {
    RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
        Animation.RELATIVE_TO_SELF, 0.5f,
        Animation.RELATIVE_TO_SELF, 0.5f);
    rotateAnimation.setDuration(3000);
    startAnimation(rotateAnimation);
  }
}
