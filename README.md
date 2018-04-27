# API-Automation-Testing
RESTFul Webservice 接口测试教程和演示代码

Rest-Assured 是一个测试 Restful Web Service 的 Java 类库，我们能够测试各种各样的请求组合，依次测试核心业务逻辑的不同组合。Rest-Assured 库提供了验证从服器收到的 HTTP 响应的功能。我们可以很方便验证状态码，状态信息，标题和响应的正文。同时我们可以把 Rest-Assured 集成到 Junit 或 TestNG 测试框架中，也可以集成到 Cucumber 等 BDD（Behavior Driven Development）敏捷测试框架中。

**本 Chat 以实际应用为主题，包含的内容有：**

1. 测试环境搭建；
   - 设置JAVA 环境
   
   由于Rest-Assured是一个Java类库，需配置好JDK环境才能使用该Java库进行接口测试。
首先检查是否已经安装和JDK并配置好了运行环境。
在命令行窗口输入：

  `java -version`

    如果已经安装好了JDK运行环境则显示图1-1 JAVA版本信息：

![图1-1 查看Java版本信息](images/2018/04/图1-1-查看java版本信息.png)
图1-1 查看Java版本信息

如果没有显示Java版本信息，就需要下载JDK并配置JDK的运行环境。我们这里使用JDK 1.8,可以从ORACLE官方下载，官方下载需要注册一个用户。为了大家使用方便我在云盘上给共享了一个JDK的压缩包。

JAVA JDK下载地址分别如下：

  - Oracle官方下载：[JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
  下载完成后点击安装，Windows下安装路径默认为C:\Program Files\Java
 - 百度云盘下载：[JDK 1.8]( https://pan.baidu.com/s/1a7WNXf0MadWflOFVt2iprw)  下载密码：acjl
  如果是从百度云盘下载无需安装，下载后解压即可。

JDK下载安装后需要配置运行环境，配置JDK运行环境的步骤如下：
>右键单击我的电脑，依次选择“属性”、“高级系统设置”、“环境变量”。然后在系统变量栏下点击“新建系统变量”，在会话框的变量名中输入“JAVA_HOME”，在变量值中输入JDK的安装路径（即为之前的默认路径），点击确定。
在系统变量选项栏中查找是否有变量“PATH”，若没有则需要新建系统变量，否则的话选择“编辑系统变量”，在弹出的会话框中在“变量值”文本框的起始位置添加“%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;”或者是直接“%JAVA_HOME%\bin;”，单击确定。
图1-2 高级系统设置
![图1-2 高级系统设置](images/2018/04/图1-2-高级系统设置.png)
图1-2 高级系统设置

![环境变量](images/2018/04/环境变量.png)
图1-3 环境变量

![图1-4 设置JAVA_HOME环境变量](images/2018/04/图1-4-设置java-home环境变量.png)
图1-4 设置JAVA_HOME环境变量

![图1-5 设置path环境变量](images/2018/04/图1-5-设置path环境变量.png)
图1-5 设置path环境变量

2. 使用 Rest-Assured 发送 Get 请求；
3. 使用 Rest-Assured 验证返回状态；
4. 使用 Rest-Assured 验证报文头；
5. 使用 Rest-Assured 验证报文内容；
6. 使用 Rest-Assured 发送 Post 请求；
7. 把 JSON 格式数据封装为 Java 类；
8. RESTFul Webservice 中的验证和授权。

**GitBook：[Rest-Asssured 实战 Rest API 自动化测试](http://gitbook.cn/gitchat/activity/5ad5f44f3a87555c6d7ee7c7)**
** [吐司 QA](http://qatools.cn)公众号**
[公众号](https://wx2.sinaimg.cn/large/d99b41d3gy1fqrbpc6qaij2076076mxm.jpg)
