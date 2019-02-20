package com.wzjwhut.examples.basic;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Log4j2
public class ConfigureExample {

    public ConfigureExample(){
        log.info("ConfigureExample init: {}", this.getClass());
    }

}
