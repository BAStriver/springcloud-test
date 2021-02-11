package com.bas.service;

import com.bas.service.impl.PaymentFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackServiceImpl.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public String paymentSQL(@PathVariable("id") Long id);

}
