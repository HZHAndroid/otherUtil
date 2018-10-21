推荐的技术栈顺序清单
1、阮一峰es6： http://es6.ruanyifeng.com/  
es6中的新特性是后续内容的基础，重点内容有let关键字、解构赋值、构造函数和原型链、Promise对象、yield关键字、Generator函数、aysnc/await等

2、reactjs：https://reactjs.org/
reactjs是react-native的基础，重点内容有Component、state、props等

3、redux(状态管理)： http://cn.redux.js.org/
react-redux框架用于管理react组件的state，重要的概念有：Action、Reducer、Store、Provider、connect

4、react-native：http://facebook.github.io/react-native/  中文网：http://reactnative.cn/
主要内容有：react-native环境搭建、集成与调试、基础组件的使用、组件的生命周期、页面布局及样式等

5、react-navigation(路由导航)：https://reactnavigation.org/
react-navigation是官方提供的路由插件，用于管理页面的跳转，有三种导航类型：StackNavigator、TabNavigator、DrawerNavigator，组件中可以使用props中的navigation属性跳转页面

6、react-native-router-flux(路由导航)：https://github.com/aksonov/react-native-router-flux
react-native-router-flux是对react-native的封装， 管理路由很方便，主要的内容有Router、Scene、Stack等内容

7、immutable.js：https://github.com/facebook/immutable-js
因为js声称万物皆对象，而且对象的赋值和java类似，存在对象和对象的引用的关系，容易导致一变都变的意外发生，immutable用于避免这种情况的发生，它使用trie的数据结构，封装了自己的数据类型和操作方式。在react中典型的应用是避免组件不必要的render操作。
--------------------- 
作者：泽兑鬼尘珠 
来源：CSDN 
原文：https://blog.csdn.net/u012455070/article/details/79030859 
版权声明：本文为博主原创文章，转载请附上博文链接！
