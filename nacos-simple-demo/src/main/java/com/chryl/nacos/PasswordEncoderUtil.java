package com.chryl.nacos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Chr.yl on 2020/6/12.
 * nacos使用 BCrypt 加密方法, 直接修改users的密码即可
 *
 * @author Chr.yl
 */
public class PasswordEncoderUtil {
    public static void main(String[] args) {
        String chryl = new BCryptPasswordEncoder().encode("chryl");
        System.out.println(
                chryl
        );
    }


    // 如何修改 不需要登录验证 , 在conf目录下的spring.security.enable=false 等下面的注释打开
}
