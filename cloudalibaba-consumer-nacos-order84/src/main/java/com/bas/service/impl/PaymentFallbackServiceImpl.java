package com.bas.service.impl;

import com.bas.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackServiceImpl implements PaymentService {
    @Override
    public String paymentSQL(Long id) {
        return "444,服务降级返回，---PaymentFallbackService ErrorSerial, id: " + id;
    }
}
