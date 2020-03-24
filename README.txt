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

ribbon
    1.1 GAV-maven

