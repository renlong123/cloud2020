package com.springcloud.service.impl;

import com.springcloud.service.StreamSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
@Slf4j
public class StreamSendServiceImpl implements StreamSendService {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String message = UUID.randomUUID().toString();
        Message<String> build = MessageBuilder.withPayload(message).build();
        output.send(build);
        log.info("*****send info:"+build.toString());
        return null;
    }

}
