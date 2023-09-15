package com.powernode.aop;

import com.powernode.aop.service.SomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lesson08AopApplicationTests {

    @Autowired
    SomeService someService;

    @Test
    void testLog() {
        someService.query(1001);
        someService.save("zhangSan", 20);
    }
}
