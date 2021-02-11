package com.bas.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bas.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallback"
            , blockHandler = "blockHandler")
    public String fallback(@PathVariable Long id) {
        String result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, String.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgument ,非法参数异常...");
        } else if (result.contains("null")) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }

        return result;
    }

    public String handlerFallback(@PathVariable Long id, Throwable e) {
        return "异常handlerFallback，exception内容： " + e.getMessage() + ", id: " + id;
    }

    public String blockHandler(@PathVariable Long id, BlockException e) {
        return "444,blockHandler-sentinel 限流，BlockException： " + e.getMessage() + ", id: " + id;
    }

    //======= OpenFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public String paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
}
