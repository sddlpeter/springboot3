package com.powernode.config.pk2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ReadConfig {

    @Autowired
    private Environment environment;

    public void print() {
        String name = environment.getProperty("app.name");
        System.out.println("app.name=" + name);

        if (environment.containsProperty("app.owner")) {
            System.out.println("app.owner is exists");
        }

        Integer portNumber = environment.getProperty("app.port", Integer.class, 9001);
        System.out.println(portNumber);
    }
}
