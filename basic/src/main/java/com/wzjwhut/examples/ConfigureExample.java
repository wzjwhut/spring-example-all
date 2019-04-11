package com.wzjwhut.examples;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class ConfigureExample {

    public ConfigureExample(){
        log.info("ConfigureExample init: {}", this.getClass());
    }

    public void invoke(){
        log.info("invoke");
    }

}
