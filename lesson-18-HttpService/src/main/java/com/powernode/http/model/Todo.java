package com.powernode.http.model;

import lombok.Data;

@Data
public class Todo {

    private Integer userId;
    private Integer id;
    private String title;
    private Boolean completed;

}
