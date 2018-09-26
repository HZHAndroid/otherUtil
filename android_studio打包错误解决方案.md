#### 一、忽略某些错误
      
      1. 在 app 的 build.gradle 文件的 android 节点添加如下代码
      
      android {
            ....
           lintOptions {
              checkReleaseBuilds false
              abortOnError false
           }
           ....
      }
