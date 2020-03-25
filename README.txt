microservicecloud-provider-dept-8001 部门微服务提供者Modeule

约定》配置》编码

DeptDao   DeptDaoImpl
deptDao   DeptMapper.xml

microservicecloud-consumer-dept-80部门微服务消费者 Module


microservicecloud-eureka-7001  服务注册中心 Module

    假如我们需要引入cloud的一个新技术组件
    基本上又两步
    1.1 新增一个相关的maven坐标
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka-server</artifactId>
        </dependency>
    1.2 再主启动类上面，标注的启动该新组件技术的相关注解标签
        @EnableEurekaServer
     1.3 java业务逻辑编码
     将已有的部门微服务注册进eureka中心

自我保护机制：好死不如赖活着


eureka集群要用到的

做一下域名映射
C:\Windows\System32\drivers\etc\hosts

127.0.0.1    eureka7001.com
127.0.0.1    eureka7002.com
127.0.0.1    eureka7003.com




传统的ACID分别是什么？
    1 A（Atomicity）原子性
    2 C(Consistency) 一致性
    3 D(Durability)持久性
CAP
    1 C:Consistency (强一致性)
    2 A:Availability (可用性)
    3 P：Partition tolerance(分区容错性)



作为服务器注册中心，Eureka比Zookeeper好在哪里
著名的CAP理论指出，一个分布式系统不可能同时满足C(一致性)，A（可用性）和P（分区容错性） ，由于分区容错性P在是分布式系统中必须保证的，因此我们只能在A和C之间进行权衡

Zookeeper保证的是CP
Eureka则是AP


Spring Cloud Ribbon 是基于Netflix Ribbon实现的一套客户端  负载均衡的工具
Spring Cloud Feign  是一个声明式的Web服务客户端，使得编写Web服务客户端变得非常容易（只需要创建一个接口，然后再上面添加注解即可）

Ribbon 跟  Feign 都是负载均衡   Feign集成了Ribbon    区别就是Feign是以接口方式调用服务


ribbon
    1.1 GAV-maven  坐标
    1.2 @EnableXXX   相对应技术组件的标签

之前大家用Ribbon  进行负载均衡，功能强大，甚至可以自己自定义算法
feign是怎么出来的？
    大部分大家的解说，直接调用我们的微服务进行访问
    private static final String REST_URL_PREFIX = "http://localhost:8001"
    修改
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

2，大家目前习惯面向接口编程，比如WebService 接口，比如我们的DAO接口，这个已经是大家的规范
    2.1微服务名字得到调用地址
    2.2通过接口+注解，获得我们的调用服务
    适应社区其他程序员提出的，还是统一的面向接口编程的套路--feign
    只需要创建一个接口，然后再上面注解即可


Feign 集成了Ribbon
    利用Ribbon维护MicroServiceCloud-Dept的列表信息，并且通过轮询实现客户端负载均衡，
    而与Ribbon不同的是通过feign需要定义服务绑定接口并以声明的方法，优雅而简单的实现服务调用

Hystrix 是一个用于处理分布式系统的延迟喝容错的开源库，在分布式系统里，许多依赖不可避免的会调用失败，比如超时，异常等
    hystrix 能够保证在一个依赖出问题的情况下，不会导致整体服务失败，避免级联故障，以高分布式系统的弹性。

    “断路器”本身是一种开关装置，当某个服务单元发生故障之后，通过断路器的故障监控（类似熔断保险丝），向调用方返回一个符合预期的，
    可处理的备选响应（fallBack）,而不是长时间的等待或者抛出调用方法无法处理的异常，这样保证了服务调用方的线程不会被长时间，不必要地占用，从而避免了故障
    在分布式系统中蔓延，乃至雪崩

服务降级
    整体资源快不够了，忍痛将某些服务先关掉，待度过难关，再开启回来


