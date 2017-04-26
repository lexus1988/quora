package com.wlewicki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by wlewicki on 4/26/2017.
 */
@SpringBootApplication(scanBasePackages={"com.wlewicki"})
public class SpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}
