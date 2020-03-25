package com.chenshuhong.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ZeroV on 2018/11/6.
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
       // return new RandomRule();//达到目的，用我们重新选择的设计算法替代默认的轮询
        // return new RetryRule(); //如果有某个服务挂掉了，他会默认不访问（访问挂掉的几次知道该服务不在，就不会进行访问了）
        return new RandomRule_LW();
    }
}
