package com.springcloudalibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {

    public static String HandlerException(BlockException exception){
        return "全局的自定义处理器---------500: 1";
    }

    public static String HandlerException2(BlockException exception){
        return "全局的自定义处理器---------500: 2";
    }
}
