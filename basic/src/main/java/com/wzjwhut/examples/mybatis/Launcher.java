package com.wzjwhut.examples.mybatis;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootConfiguration //约等同于@Configuration
@EnableAutoConfiguration //自动配置
@EnableScheduling //启用定时器
@RestController   //使用restful形式
@ControllerAdvice //未捕获的异常的处理
@EnableAspectJAutoProxy(proxyTargetClass=true)
@SpringBootApplication
@Data     //自动生成setter/getter. 需要idea安装lombok插件
@Log4j2  //lombok自动生成log4j2的log对象
public class Launcher {

    @Autowired
    ConfigureExample configureExample;


    public static void main(String[] args){

        //禁用web, 适用于非web形式的应用
        //SpringApplication app = new SpringApplication(Launcher.class);
        //app.setWebApplicationType(WebApplicationType.NONE);
        //app.run(args);

        //默认启用web, 端口通过application.propertis配置(或其它格式)
        SpringApplication.run(Launcher.class, args);
    }

    //配置一个定时器, 每30秒执行一次. 类似于linux的cron
    @Scheduled(cron = "30 * * * * ?")
    public void mySchedule(){
        log.info("start push data scheduled!");
    }

    //当spring配置完成之后, 会执行ApplicationRunner
    @Bean
    public ApplicationRunner runner1() {
        return args -> {
           log.info("run1");
        };
    }
    @Bean
    public ApplicationRunner runner2() {
        return args -> {
            log.info("run2");
        };
    }

    @RequestMapping("/")
    Object hello(HttpServletRequest req, HttpServletResponse resp, /*如果用不到这两个参数, 可以去掉*/
    @RequestParam(required = false) String name) {
        return "hello: " + name;
    }




}