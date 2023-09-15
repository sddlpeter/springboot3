package com.powernode.http;

import com.powernode.http.model.Todo;
import com.powernode.http.service.TodoService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class Lesson18HttpServiceApplicationTests {

    @Resource
    private TodoService todoService;

    @Test
    void testQuery() {
        Todo todo = todoService.getTodoById(1);
        System.out.println(todo);

        System.out.println("todoService=" + todoService.getClass());
        Integer id = todo.getId();
        Integer userId = todo.getUserId();
    }

    @Test
    void testCreateTodo() {
        Todo todo = new Todo();
        todo.setId(1001);
        todo.setUserId(5005);
        todo.setTitle("Event 1");
        todo.setCompleted(true);

        Todo resultTodo = todoService.createTodo(todo );
        System.out.println("resultTodo=" + resultTodo);
    }

    @Test
    void testModify() {
        Todo todo = new Todo();
        todo.setId(1002);
        todo.setUserId(5002);
        todo.setTitle("Event 2");
        todo.setCompleted(true);

        ResponseEntity<Todo> entity = todoService.modifyTodo(2, todo);

        HttpHeaders headers = entity.getHeaders();
        System.out.println(headers);

        Todo body = entity.getBody();
        System.out.println(body);

        HttpStatusCode statusCode = entity.getStatusCode();
        System.out.println(statusCode);

    }

    @Test
    void testDelete() {
        todoService.removeTodo(10);
    }

}
