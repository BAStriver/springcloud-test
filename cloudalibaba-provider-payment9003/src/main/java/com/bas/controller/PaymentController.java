package com.bas.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, String> map = new HashMap<>();

    static {
        map.put(1L, "1L, 1111");
        map.put(1L, "2L, 2222");
        map.put(1L, "3L, 3333");
    }


    @GetMapping(value = "/paymentSQL/{id}")
    public String paymentSQL(@PathVariable("id") Long id) {
        String payment = map.get(id);
        return "from mysql,serverPort: " + serverPort + " , " + payment;
    }
}


