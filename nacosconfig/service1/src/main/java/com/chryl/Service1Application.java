package com.chryl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Chr.yl on 2020/6/14.
 *
 * @author Chr.yl
 */
@SpringBootApplication
@RestController
public class Service1Application {

    //1.@value方式
    //使用@value读取配置信息,但是有一个问题,当修改了nacos上的配置信息,但是value注解不会生效,也不是nacos没通知服务端.只是value注解不生效而已,所以想要动态实现,不能用这个方式
    @Value("${common.name}")//里面的key是什么:就是nacos配置文件里的key对应的内容
    private String config1;

    //2.配置上下文方式
    @Autowired
    ConfigurableApplicationContext applicationContext;


    @GetMapping("configs")
    public String getConfigw() {
        //读配置信息
//        return config1;//通过@value获取
        return applicationContext.getEnvironment().getProperty("common.name");//通过上下文环境获取配置信息
    }

    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }
}
