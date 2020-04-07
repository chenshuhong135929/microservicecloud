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
    3 I (Isolation )隔离性
    4 D(Durability)持久性
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
    所谓降级，一般是从整体负荷考虑，就是当某个服务熔断之后，服务器将不再调用
    此时客户端可以自己准备一个本地的fallback回调，返回一个缺省值
    这样做，虽然水平下降，但是好歹可用，比直接挂掉要强，会给用户一个友好的提示


服务熔断
    一般是某个服务故障或者异常引起，类似行现实世界中的“保险丝”，当某个异常条件触发，直接熔断整个服务，而不是一直等到此服务超时


Hystrix Dashboard  可以监控微服务图形化数据（压力状况，调用状况）
    url  http://eureka7002.com:9001/hystrix
    监控单个的    http://hystrix-app:port/hystrix.stream
   监控的说明：
            实心圆：共有两种含义，它通过颜色的变化代表了实例的健康程度，它的健康程度从绿色>黄色>橙色>红色递减
            该实心圆除了颜色的变化之外，它的大小也会根据实例的请求流量发生变化。流量越大实心圆就越大，所以通过该实心圆展现就可以在大量的实例中快速发现故障实例喝高压实例

Zuul 包含了对请求的路由和过滤两个最主要的功能
        其中路由功能负责将外部请求转发到具体的微服务实例上，最实现外部访问统一入口的基础而过滤功能则负责请求的处理过程进行干预，是实现强请求校验，服务集合等功能
        的基础Zuul和Eureka进行整合，将Zuul注册为Eureka服务治理下的应用，同时从Eureka中获得其他服务的消息，也即以后访问微服务都通过Zuul后获得

        注意：Zuul服务最终还是会注册进Eureka
        提供=代理+路由+过滤  三大功能

SpringCloud Config 为微服务架构中的微服务提供集中化的外部配置支撑，配置服务器为各个不同微服务应用的所有环境提供了一个中心化外部配置

        1 在github上创建一个仓库
        2 在本地找个文件夹执行git代码
          1    git init
          2    git clone https://github.com/chenshuhong135929/microservicecloud-config.git
          3    创建对应的配置文件，必须要是utf-8的格式保存，不然会报错的
          4    cd microservicecloud-config/
          5     git add.
          6    git commit -m "init file"
          7    git push -u  origin master
          7    git pull --rebase origin master


           127.0.0.1  config-3344.com
            访问 http://localhost:3344/application-dev.yml
            访问 http://localhost:3344/application-test.yml

application.yml 是用户级的资源配置项
bootstrap.yml  是系统级的，最优先更加高



