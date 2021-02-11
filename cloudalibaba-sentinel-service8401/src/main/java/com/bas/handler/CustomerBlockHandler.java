package com.bas.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {

    public static String handlerException(BlockException exception) {
        return "444,按照客户自定义的Glogal 全局异常处理 ---- 1" + exception.getClass().getCanonicalName();
    }

    public static String handlerException2(BlockException exception) {
        return "444,按照客户自定义的Glogal 全局异常处理 ---- 2" + exception.getClass().getCanonicalName();
    }
}

