## CSArchWithSwing

> 一个简单的基于Swing的CS架构的小项目，使用maven对项目进行构建和管理，mina作为通信框架，项目本着学习与熟悉目的，仅仅在客户端登陆的时候进行了CS间的通信，内容部分以Swing为主，参考Swing.Hacks一书，将Swing组件富客户端的一些特性直观的展现出来，一方面总结了常用组件的使用方式，作为Demo方便学习，一方面提升自己的动手能力。

- client-cw:场务客户端，实现了Swing的常用组件和使用特性
- client-xj:业务客户端，实时聊天与信息提取功能（由于时间原因，并未实现^.^）
- servers:服务端，与客户端的通信，到数据库的访问
- commons:公共部分
  - 作为客户端远程调用服务端接口功能实现的共同接口
  - pom文件管理了项目需要使用的大部分jar包，其他模块直接依赖此模块即可
  - 提供公共公用的接口方法



> 使用：目前功能较少，持久层实现较为简单，所以直接以sf,123456作为用户名密码登陆

