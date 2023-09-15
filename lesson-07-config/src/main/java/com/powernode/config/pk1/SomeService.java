package com.powernode.config.pk1;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

@Service
public class SomeService {

    @Value("${app.name}")
    private String name;

    //@Value("${app.owner}")
    private String owner;

    @Value("${app.port:8008}")
    private Integer port;


    public void printValue() {
        StringJoiner joiner = new StringJoiner(";");
        joiner.add(name).add(owner).add(String.valueOf(port));

        String res = joiner.toString();
        System.out.println(res);
    }
}
