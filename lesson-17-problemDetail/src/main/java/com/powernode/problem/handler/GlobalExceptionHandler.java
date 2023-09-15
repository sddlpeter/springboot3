package com.powernode.problem.handler;

import com.powernode.problem.exception.BookNotFoundException;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;

// @RestControllerAdvice
public class GlobalExceptionHandler {

/*    @ExceptionHandler({BookNotFoundException.class})
    public ProblemDetail handlerBookNotFoundException(BookNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());

        problemDetail.setType(URI.create("/api/probs/not-found"));
        problemDetail.setTitle("图书异常");

        // 增加自定义的字段
        problemDetail.setProperty("时间", Instant.now());
        problemDetail.setProperty("客服", "service@powernode.com");

        return problemDetail;
    }*/


    @ExceptionHandler({BookNotFoundException.class})
    public ErrorResponse handlerException(BookNotFoundException e) {
        ErrorResponse error = new ErrorResponseException(HttpStatus.NOT_FOUND, e);

        return error;
    }
}
