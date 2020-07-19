package com.chryl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chr.yl on 2020/6/14.
 *
 * @author Chr.yl
 */
@SpringBootApplication
@RestController
@RefreshScope
public class Service4Application {
    public static void main(String[] args) {
        SpringApplication.run(Service4Application.class, args);
    }


    @Value("${service4.nac}")
    String nac;

    @Value("${service4.dev}")
    String dev;

    @GetMapping("/show")
    public Object show() {
        return nac + "-" + dev;
    }
}
