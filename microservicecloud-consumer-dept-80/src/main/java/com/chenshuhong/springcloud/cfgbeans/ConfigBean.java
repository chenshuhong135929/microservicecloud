package com.chenshuhong.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类
 */

@Configuration
public class ConfigBean {
    //rest模板提供了很多调用方法
    @Bean
    @LoadBalanced  //开启了客户端负载均衡功能
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        //return new RandomRule();
        return new RetryRule();
    }

}
