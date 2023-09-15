package com.powernode.config.pk3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MultiConfigService {

    @Value("${spring.redis.host}")
    private String redisHostName;

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    public void print() {
        System.out.println("redisHostName=" + redisHostName + ", jdbcUrl=" + jdbcUrl);
    }
}
