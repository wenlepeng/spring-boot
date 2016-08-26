package com.pwl.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * 商业环境管理url
 *
 * http://localhost:8080/health
 * http://localhost:8080/beans
 * http://localhost:8080/info
 * http://localhost:8080/metrics
 * http://localhost:8080/trace
 * http://localhost:8080/configprops
 *
 *
 */
@SpringBootApplication
public class Application {

    public static void main(String [] args){
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        System.out.println("Let's inspect the beans provided by Spring boot");

        String [] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for(String beanName:beanNames){
            System.out.println(beanName);
        }


    }
}
