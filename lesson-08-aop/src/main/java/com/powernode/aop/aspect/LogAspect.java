package com.powernode.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

@Component
@Aspect
public class LogAspect {

    @Before("execution(* com.powernode.aop.service..*.*(..))")
    public void sysLog(JoinPoint jp) {
        StringJoiner log = new StringJoiner("|", "{", "}");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        log.add(formatter.format(LocalDateTime.now()));

        String methodName = jp.getSignature().getName();
        log.add(methodName);

        Object[] args = jp.getArgs();
        for (Object arg : args) {
            log.add(arg == null ? "-" : arg.toString());
        }

        System.out.println(log);
    }
}
