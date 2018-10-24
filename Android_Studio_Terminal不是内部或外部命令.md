[Android Studio Terminal 不是内部或外部命令,也不是可运行程序或批处理文件](https://blog.csdn.net/guiying712/article/details/53129961#adb命令无效的解决办法)


Android Studio Terminal 命令行无效的问题
ADB命令无效的解决办法
使用Gradle 命令无效
Git命令无效的解决办法
Groovy命令无效的解决办法
由于这篇文章是在Windows系统中搭建开发环境的，因此需要你了解一些Windows环境变量的知识，方便你理解下面内容；Windows环境变量的知识请查看这篇文章：Windows环境变量Path、ClassPath、JAVA_HOME的作用 。

Android Studio Terminal 命令行无效的问题
在Android Studio中自带了命令行终端Terminal，但是我们在输入命令时经常会发现：“XXX”不是内部或外部命令,也不是可运行程序或批处理文件。 如下图：



一般这种情况都是Windows系统环境变量中没有配置相应工具的路径，那么我们就针对各种情况去在Windows系统的环境变量中添加相应工具的路径。这篇文章中主要讲解ADB、Gradle、Git 和 Groovy 的配置方法，支持其他工具的原理都大同小异，只需按照这几种方法自行添加就可以了。

在配置之前，首先需要说明的是 AndroidStudio Terminal 默认使用的 Shell 是Windows系统的 cmd.exe，当然如果你并不喜欢使用 cmd.exe 可以在AndroidStudio 的 Setting 中去修改，修改方法是：

Setting—->Tools—–>Terminal—–>Shell Path。



因此我们在Windows系统环境变量中配置了相应工具的路径后，不管是对 cmd.exe 还是AndroidStudio Terminal 都是有效的。如果你添加完工具的路径后，在AndroidStudio Terminal 中无效，那么你只需要重启下AndroidStudio即可！

ADB命令无效的解决办法
要想在Android Studio中自带的命令行终端Terminal 或者Cmd.exe 中执行 ADB命令，就要在系统属性中环境变量中配置ADB路径；例如下面的路径就是我电脑中SDK的ADB所在路径：

D:\SDK\platform-tools

然后打开“计算机”-“右键”-“属性”-“更改设置”-“高级”-“环境变量”，把这个路径添加到系统变量中的 Path 中，， 记得一定要用 分号( ; ) 将这个路径和 Path中的前一个路径隔开，如下图:



再去Android Studio Terminal输入： adb shell



这样即为成功。

我这个开发环境是Win7，如果你使用的是Win10需要设置下系统的cmd属性：



然后重启你的Android Studio，就可以愉快的使用Terminal了。

使用Gradle 命令无效
此时如果你想在Android Studio Terminal或者系统cmd 中使用gradle命令行打包apk或者执行gradle命令会发现依然提示你：“XXX”不是内部或外部命令,也不是可运行程序或批处理文件。 要想执行gradle命令我们还需要在系统属性中环境变量中配置 Gradle 路径。我的 Gradle 路径为：D:\gradle\gradle-2.14.1

然后打开“计算机”-“右键”-“属性”-“更改设置”-“高级”-“环境变量”，在系统变量中，点击新建，属性名为：“GRADLE_HOME”，属性值为：

D:\gradle\gradle-2.14.1



接着打开“计算机”-“右键”-“属性”-“更改设置”-“高级”-“环境变量”，在系统变量中，找到 Path，将下面的语句加入到Path中， 记得一定要用 分号( ; ) 将这个路径和 Path 中的前一个路径隔开：

%GRADLE_HOME%\bin;

或者直接将 gradle 的路径添加到 Path 中，要记得给前后加分号( ; )：

D:\gradle\gradle-2.14.1\bin;



最后在Android Studio Terminal或者系统cmd，输入： gradle，如果出现如图所示，则说明Gradle配置成功：



Git命令无效的解决办法
同上，如果你想在Android Studio Terminal或者系统cmd 中执行Git命令依然提示你：“XXX”不是内部或外部命令,也不是可运行程序或批处理文件。 执行Git命令我们还需要在系统属性中的环境变量中配置Git 
路径。我的Git路径为：

D:\Program Files\Git\bin

然后打开“计算机”-“右键”-“属性”-“更改设置”-“高级”-“环境变量”，在系统变量中，找到Path，将 “;D:\gradle\gradle-2.14.1\bin“加入到Path中， 记得一定要用 分号( ; ) 将这个路径和 Path中的前一个路径隔开：



最后在Android Studio Terminal或者系统cmd，输入： git - -version，如果出现如图所示，则说明Git配置成功：



Groovy命令无效的解决办法
要想在Android Studio Terminal或者系统cmd 中执行 Groovy 命令，前提必须是你的Windows电脑上要有Groovy的环境，Groovy 的SDK官方下载地址是：Groovy 的SDK官方下载地址 ， 进入这个网站后，在右上角有一个大大的黄色按钮Download，直接点击下载即可。然后把这个 zip 包 解压到你的D盘根目录下，例如我电脑的 Groovy路径是：

D:\groovy-2.4.12\bin

然后打开“计算机”-“右键”-“属性”-“更改设置”-“高级”-“环境变量”，在系统变量中，找到Path，将 “;D:\groovy-2.4.12\bin“加入到Path中， 记得一定要用 分号( ; ) 将这个路径和 Path中的前一个路径隔开：



最后在Android Studio Terminal或者系统cmd，输入： groovy -version，如果出现如图所示，则说明Groovy 配置成功：


--------------------- 
作者：guiying712 
来源：CSDN 
原文：https://blog.csdn.net/guiying712/article/details/53129961 
版权声明：本文为博主原创文章，转载请附上博文链接！
