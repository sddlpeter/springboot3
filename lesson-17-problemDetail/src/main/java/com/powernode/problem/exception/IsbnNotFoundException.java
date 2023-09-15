package com.powernode.problem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;

// 自定义异常类，让springmvc的异常处理器使用
public class IsbnNotFoundException extends ErrorResponseException {

    public IsbnNotFoundException(HttpStatus httpStatus, String detail) {
        super(httpStatus, createProblemDetail(httpStatus, detail), null);
    }

    private static ProblemDetail createProblemDetail(HttpStatus status, String detail) {
        // 封装RFC7807字段
        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setType(URI.create("/api/probs/not-found"));
        problemDetail.setTitle("图书异常");
        problemDetail.setDetail(detail);

        // 自定义异常
        problemDetail.setProperty("严重程度", "低");
        problemDetail.setProperty("客服邮箱", "service@powernode.com");
        return problemDetail;
    }
}
