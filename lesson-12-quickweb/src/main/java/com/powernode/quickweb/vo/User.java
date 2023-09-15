package com.powernode.quickweb.vo;

import lombok.Data;

@Data
public class User {
    private String username;
    private Integer age;
    private RoleVO roleVO;
}
