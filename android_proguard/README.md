<div align='center'>说明（有处理androidx兼容）</div>

1. config.gradle（组件化，第三方库版本统一管理）
  1.1 该文件是在项目 build.gradle 同级目录。
  1.2 在项目的 build.gradle ，注意不是模块的 build.gradle，引入该文件
      // 引入其他的gradle文件，在这里引入，全局可用
      apply from: 'config.gradle'
  1.3 引入后就可以使用里面的属性了
  
2. build.gradle（这里是模块的build.gradle）
  1.1 在该文件导入第三方jar包（implementation 和 api 都是引入，如果使用api，在一个模块引入另外一个模块，仍然可以使用，implementation 只可以在
  当前模块使用）

3. proguard-rules.pro (混淆规则文件, 这里是指根模块目录中的混淆配置文件)
  1. 这里是【根模块目录中，即app模块】中的混淆配置文件
  2. 该文件是所有第三方库或者系统库中的混淆配置
  
