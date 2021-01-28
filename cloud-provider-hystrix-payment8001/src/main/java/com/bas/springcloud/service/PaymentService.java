package com.bas.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @title: fidb-parse
 * @description:
 * @author: Carlos.Zhang@morningstar.com
 * @create: 2021/1/25 17:06
 **/
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池： " + Thread.currentThread().getName()
                + "   paymentInfo_OK,id:" + id + " 正常访问！";
    }

    public String paymentInfo_Timeout(Integer id) {
        int timeNumber = 1;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName()
                + "   paymentInfo_OK,id:" + id + " 耗时(秒):" + timeNumber;
    }
}



