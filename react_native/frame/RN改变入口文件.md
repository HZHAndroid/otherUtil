<div align='center'>
  <h3>React Native 改变入口文件</h3>
</div>
    
#### 这里以Android为例子
      
      说明：1. 在 MainApplication 的 
              @Override
              protected String getJSMainModuleName() {
                return "src/containers/index";
              }
              方法中，改变 “src/containers/index” 为需要改变的具体路径即可。
              且文件不需要后缀名。
           
           2. 当前 的路径为 “src/containers/index”，原本的只有 "index"；
           3. src 是跟 android 和 ios目录，已经默认生成的入口文件 inedx.js 同级的。

      
      package com.dousouapp;

      import android.app.Application;

      import com.facebook.react.ReactApplication;
      import com.facebook.react.ReactNativeHost;
      import com.facebook.react.ReactPackage;
      import com.facebook.react.shell.MainReactPackage;
      import com.facebook.soloader.SoLoader;

      import java.util.Arrays;
      import java.util.List;

      public class MainApplication extends Application implements ReactApplication {

        private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
          @Override
          public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
          }

          @Override
          protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                new MainReactPackage()
            );
          }

          @Override
          protected String getJSMainModuleName() {
            return "src/containers/index";
          }
        };

        @Override
        public ReactNativeHost getReactNativeHost() {
          return mReactNativeHost;
        }

        @Override
        public void onCreate() {
          super.onCreate();
          SoLoader.init(this, /* native exopackage */ false);
        }
      }
