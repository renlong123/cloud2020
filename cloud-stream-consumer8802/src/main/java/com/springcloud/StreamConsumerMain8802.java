package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StreamConsumerMain8802 {

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerMain8802.class,args);
    }

}
