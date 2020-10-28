package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StreamConsumerMain8803 {

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerMain8803.class,args);
    }

}
