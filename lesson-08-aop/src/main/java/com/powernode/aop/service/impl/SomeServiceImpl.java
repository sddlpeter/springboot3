package com.powernode.aop.service.impl;

import com.powernode.aop.service.SomeService;
import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public void query(Integer id) {
        System.out.println("======some service business query======");
    }

    @Override
    public void save(String name, Integer age) {
        System.out.println("======some service save method======");
    }
}
