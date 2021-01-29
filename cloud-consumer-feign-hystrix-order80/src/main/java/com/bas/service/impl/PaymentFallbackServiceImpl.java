package com.bas.service.impl;

import com.bas.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

/**
 * @title: fidb-parse
 * @description:
 * @author: Carlos.Zhang@morningstar.com
 * @create: 2021/1/25 17:48
 **/
@Service
public class PaymentFallbackServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_Timeout,o(╥﹏╥)o";
    }
}



