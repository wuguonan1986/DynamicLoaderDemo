package wu.victor.testdynamicloader;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;

import dalvik.system.DexClassLoader;
import wu.victor.myviewinterface.MyBaseView;

public class MainActivity extends AppCompatActivity {
  Button red;
  Button blue;
  Button green;

  FrameLayout container;

  HashMap<String, DexClassLoader> classLoaderHashMap = new HashMap<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initViews();
  }

  void initViews() {
    container = (FrameLayout) findViewById(R.id.container);


    red = (Button) findViewById(R.id.red);
    red.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        loadRedView();
      }
    });

    blue = (Button) findViewById(R.id.blue);
    blue.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        loadBlueView();
      }
    });

    green = (Button) findViewById(R.id.green);
    green.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        loadGreenView();
      }
    });
  }

  void loadRedView() {
//    ClassLoader classLoader = getClassLoader();
    String path = Environment.getExternalStorageDirectory() + "/testplugins/red.apk";
    Log.e("path:", path);
    ClassLoader classLoader = getMyClassLoader(path);
    try {
      Class clazz = classLoader.loadClass("wu.victor.redviewplugin.MyRedView");
      Constructor constructor = clazz.getConstructor(Context.class);
      MyBaseView view = (MyBaseView) constructor.newInstance(this);
      container.removeAllViews();
      container.addView(view);
      view.doAnimation();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void loadBlueView() {
//    ClassLoader classLoader = getClassLoader();
    String path = Environment.getExternalStorageDirectory() + "/testplugins/blue.apk";
    Log.e("path:", path);
    ClassLoader classLoader = getMyClassLoader(path);
    try {
      Class clazz = classLoader.loadClass("wu.victor.blueviewplugin.MyBlueView");
      Constructor constructor = clazz.getConstructor(Context.class);
      MyBaseView view = (MyBaseView) constructor.newInstance(this);
      container.removeAllViews();
      container.addView(view);
      view.doAnimation();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }



  void loadGreenView() {
//    ClassLoader classLoader = getClassLoader();
    String path = Environment.getExternalStorageDirectory() + "/testplugins/green.apk";
    Log.e("path:", path);
    ClassLoader classLoader = getMyClassLoader(path);
    try {
      Class clazz = classLoader.loadClass("wu.victor.greenviewplugin.MyGreenView");
      Constructor constructor = clazz.getConstructor(Context.class);
      MyBaseView view = (MyBaseView) constructor.newInstance(this);
      container.removeAllViews();
      container.addView(view);
      view.doAnimation();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  DexClassLoader getMyClassLoader(String dexPath) {

    DexClassLoader loader = classLoaderHashMap.get(dexPath);
    File file = new File(dexPath);
    if (!file.exists()) {
      return null;
    }
    if (loader == null) {
      String cachPath = getCacheDir().getPath();
      Log.e("cachPath:", cachPath);
      loader = new DexClassLoader(dexPath, cachPath, null, getClassLoader());
      classLoaderHashMap.put(dexPath, loader);
    }
    return loader;
  }

}
