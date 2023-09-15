package com.powernode.config;

import com.powernode.config.pk1.SomeService;
import com.powernode.config.pk2.ReadConfig;
import com.powernode.config.pk3.MultiConfigService;
import com.powernode.config.pk4.MultiEnvService;
import com.powernode.config.pk5.AppBean;
import com.powernode.config.pk6.NestAppBean;
import com.powernode.config.pk6.Security;
import com.powernode.config.pk8.CollectionConfig;
import com.powernode.config.pk9.Group;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lesson07Tests {

    @Autowired
    private SomeService someService;

    @Autowired
    private ReadConfig readConfig;

    @Autowired
    private MultiConfigService multiConfigService;

    @Autowired
    private MultiEnvService multiEnvService;

    @Autowired
    private AppBean appBean;

    @Test
    void test01() {
        someService.printValue();
    }

    @Test
    void test02() {
        readConfig.print();
    }

    @Test
    void test03() {
        multiConfigService.print();
    }

    @Test
    void test04() {
        multiEnvService.print();
    }

    @Test
    void test05() {
        System.out.println(appBean.toString());
        System.out.println(appBean.getClass());
    }

    @Autowired
    private NestAppBean nestAppBean;

    @Test
    void test06() {
        System.out.println(nestAppBean);
    }

    @Autowired
    private Security security;

    @Test
    void test07() {
        System.out.println(security);
    }


    @Autowired
    private CollectionConfig collectionConfig;

    @Test
    void test08() {
        System.out.println(collectionConfig);
    }

    @Autowired
    Group group;

    @Test
    void test09() {
        System.out.println(group);
    }
}
