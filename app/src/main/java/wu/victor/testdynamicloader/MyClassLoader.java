package wu.victor.testdynamicloader;

import dalvik.system.DexClassLoader;

/**
 * Created by wuguonan on 2017/2/14 0014.
 */

public class MyClassLoader extends DexClassLoader {
  public MyClassLoader(String dexPath, String optimizedDirectory, String librarySearchPath, ClassLoader parent) {
    super(dexPath, optimizedDirectory, librarySearchPath, parent);
  }
}
