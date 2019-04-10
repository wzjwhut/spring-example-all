package com.wzjwhut.examples;

import com.wzjwhut.examples.repository.CityRepository;
import com.wzjwhut.examples.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log4j2  //lombok自动生成log4j2的log对象
public class Application {

    @Autowired
    CityRepository cityRepository;
    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //当spring配置完成之后, 会执行ApplicationRunner
    @Bean
    public ApplicationRunner runner1() {
        return args -> {
            log.info("run");
            log.info("find city {}", cityRepository.findById("wzj"));
            log.info("find person {}", personRepository.findById("wzj"));
        };
    }
}