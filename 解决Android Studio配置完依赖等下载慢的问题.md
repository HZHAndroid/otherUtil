### 原文连接：https://blog.csdn.net/anyanyan07/article/details/79300063

### 步骤：
    1. 修改项目 build.gradle 
        buildscript {
          repositories {
              //加入下面这句
              maven{ url 'http://maven.aliyun.com/nexus/content/groups/public/'}
          }
         }

        allprojects {
            repositories {
                //加入下面这句
                maven{ url 'http://maven.aliyun.com/nexus/content/groups/public/'}
            }
        }
        
    2. 修改系统的 hosts 文件
      2.1 mac系统的执行以下命令打开文件: vi /etc/hosts
      2.2 在尾部添加：
          74.125.237.1 dl-ssl.google.com
          74.125.23.190 dl-ssl.google.com
