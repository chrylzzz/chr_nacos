package com.chryl.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Created by Chr.yl on 2020/6/11.
 *
 * @author Chr.yl
 */
public class SimpleDemo {
    //使用nacos client获取配置信息
    public static void main(String[] args) throws NacosException {
        //nacos地址
        String serverAddr = "127.0.0.1:8848";
        //namespace 的id如何获取
//        String namespace = "cf4991df-158c-4cc1-bf7b-a7dd32c3ea04";
        //Data Id
        String dataId = "nacos-simple-demo.yaml";
        //Group
        String group = "DEFAULT_GROUP";

        Properties properties = new Properties();
        properties.setProperty("serverAddr", serverAddr);
        //没有写namespace,默认是public
//        properties.setProperty("namespace",namespace);
        ConfigService configService = NacosFactory.createConfigService(properties);
        //获取配置,String dataId,String group,long timeoutMs
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);

        //添加监听,时刻监听nacos的配置文件的修改String dataId,String group,Listener listener
        configService.addListener(dataId, group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            //当配置发生变化时的通知
            @Override
            public void receiveConfigInfo(String s) {
                System.out.println(s);
            }
        });
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
