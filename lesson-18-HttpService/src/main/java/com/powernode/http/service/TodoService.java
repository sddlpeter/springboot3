package com.powernode.http.service;

import com.powernode.http.model.Todo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

public interface TodoService {

    // 一个方法，就是一个远程服务 (远程调用)

    @GetExchange("/todos/{id}")
    Todo getTodoById(@PathVariable("id") Integer id);


    @PostExchange(value = "/todos/", accept = MediaType.APPLICATION_JSON_VALUE)
    Todo createTodo(@RequestBody Todo newTodo);

    @PutExchange("/todos/{id}")
    ResponseEntity<Todo> modifyTodo(@PathVariable Integer id, @RequestBody Todo todo);

    @DeleteMapping("/todo/{sid}")
    void removeTodo(@PathVariable("sid") Integer id);
}
