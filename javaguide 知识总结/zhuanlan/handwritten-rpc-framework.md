---
title: 《手写 RPC 框架》
category: 知识星球
---

## 介绍

**《手写 RPC 框架》** 是我的[知识星球](../about-the-author/zhishixingqiu-two-years.md)的一个内部小册，我写了 12 篇文章来讲解如何从零开始基于 Netty+Kyro+Zookeeper 实现一个简易的 RPC 框架。

麻雀虽小五脏俱全，项目代码注释详细，结构清晰，并且集成了 Check Style 规范代码结构，非常适合阅读和学习。

## 内容概览

![](https://guide-blog-images.oss-cn-shenzhen.aliyuncs.com/github/javaguide/image-20220308100605485.png)

通过这个简易的轮子，你可以学到 RPC 的底层原理和原理以及各种 Java 编码实践的运用。你甚至可以把它当做你的毕设/项目经验的选择，这是非常不错！对比其他求职者的项目经验都是各种系统，造轮子肯定是更加能赢得面试官的青睐。

- Github 地址：[https://github.com/Snailclimb/guide-rpc-framework](https://github.com/Snailclimb/guide-rpc-framework) 。
- Gitee 地址：[https://gitee.com/SnailClimb/guide-rpc-framework](https://gitee.com/SnailClimb/guide-rpc-framework) 。

## 项目基本情况和可优化点

为了循序渐进，最初的是时候，我是基于传统的 **BIO** 的方式 **Socket** 进行网络传输，然后利用 **JDK 自带的序列化机制** 来实现这个 RPC 框架的。后面，我对原始版本进行了优化，已完成的优化点和可以完成的优化点我都列在了下面 👇。

**为什么要把可优化点列出来？** 主要是想给哪些希望优化这个 RPC 框架的小伙伴一点思路。欢迎大家 fork 本仓库，然后自己进行优化。

- [x] **使用 Netty（基于 NIO）替代 BIO 实现网络传输;**
- [x] **使用开源的序列化机制 Kyro（也可以用其它的）替代 JDK 自带的序列化机制;**
- [x] **使用 Zookeeper 管理相关服务地址信息;**
- [x] **Netty 重用 Channel 避免重复连接服务端;**
- [x] **使用 `CompletableFuture` 包装接受客户端返回结果**（之前的实现是通过 `AttributeMap` 绑定到 Channel 上实现的）;
- [x] **增加 Netty 心跳机制** : 保证客户端和服务端的连接不被断掉，避免重连。
- [x] **客户端调用远程服务的时候进行负载均衡** ：调用服务的时候，从很多服务地址中根据相应的负载均衡算法选取一个服务地址。ps：目前实现了随机负载均衡算法与一致性哈希算法。
- [x] **处理一个接口有多个类实现的情况** ：对服务分组，发布服务的时候增加一个 group 参数即可。
- [x] **集成 Spring 通过注解注册服务；**
- [x] **集成 Spring 通过注解进行服务消费；**
- [x] **增加服务版本号** ：建议使用两位数字版本，如：1.0，通常在接口不兼容时版本号才需要升级。为什么要增加服务版本号？为后续不兼容升级提供可能，比如服务接口增加方法，或服务模型增加字段，可向后兼容，删除方法或删除字段，将不兼容，枚举类型新增字段也不兼容，需通过变更版本号升级。
- [x] **对 SPI 机制的运用；**
- [ ] **增加可配置比如序列化方式、注册中心的实现方式,避免硬编码** ：通过 API 配置，后续集成 Spring 的话建议使用配置文件的方式进行配置
- [x] **客户端与服务端通信协议（数据包结构）重新设计** ，可以将原有的 `RpcRequest`和 `RpcReuqest` 对象作为消息体，然后增加如下字段（可以参考：《Netty 入门实战小册》和 Dubbo 框架对这块的设计）：
  - **魔数** ： 通常是 4 个字节。这个魔数主要是为了筛选来到服务端的数据包，有了这个魔数之后，服务端首先取出前面四个字节进行比对，能够在第一时间识别出这个数据包并非是遵循自定义协议的，也就是无效数据包，为了安全考虑可以直接关闭连接以节省资源。
  - **序列化器编号** ：标识序列化的方式，比如是使用 Java 自带的序列化，还是 json，kyro 等序列化方式。
  - **消息体长度** ： 运行时计算出来。
  - ......
- [ ] **编写测试为重构代码提供信心**
- [ ] **服务监控中心（类似 dubbo admin）**
- [x] **设置 gzip 压缩**

## 星球其他资源

除了 **《从零开始写一个 RPC 框架》** 之外，星球还有 **《Java 面试指北》**、 **《Java 必读源码系列》**（目前已经整理了 Dubbo 2.6.x 、Netty 4.x、SpringBoot2.1 的源码） 、**《Kafka 常见面试题/知识点总结》** 等多个专栏。

![](https://guide-blog-images.oss-cn-shenzhen.aliyuncs.com/xingqiu/image-20220211231206733.png)

另外，星球还会有读书活动、学习打卡、简历修改、免费提问、海量 Java 优质面试资源以及各种不定时的福利。

![](https://guide-blog-images.oss-cn-shenzhen.aliyuncs.com/xingqiu/image-20220304124333119.png)

## 星球限时优惠

两年前，[知识星球](../about-the-author/zhishixingqiu-two-years.md)的定价是 **50/年** ，这是星球的最低定价，我还附送了优惠券。扣除了星球手续费，发了各种福利之后，几乎就是纯粹做公益。

当时的想法真不是为了赚钱，不开玩笑，不打诳语！目前星球有 **8000+** 人，其中有超过 **35%** 的小伙伴都是星球刚开那会就加入了。

随着时间推移，星球积累的干货资源越来越多，我花在星球上的时间也越来越多。于是，我将星球的定价慢慢调整为了 **159/年**！是的，星球的价格会慢慢升高的，想要加入的小伙伴一定要尽早。

你可以添加我的微信领取星球专属优惠券，限时 **100 元/年** 加入。

![](https://guide-blog-images.oss-cn-shenzhen.aliyuncs.com/github/javaguide/IMG_3007.jpg)

如果你经济确实有困难的话，加我的时候说明一下情况就好，莫欺少年穷，可以理解，一定不要去用什么花呗类借贷产品。

![](https://guide-blog-images.oss-cn-shenzhen.aliyuncs.com/xingqiu/image-20220304125325364.png)

![](https://guide-blog-images.oss-cn-shenzhen.aliyuncs.com/xingqiu/image-20220304125403995.png)

不过，还是希望大家也不要利用我的好心，感恩！信任！理解！