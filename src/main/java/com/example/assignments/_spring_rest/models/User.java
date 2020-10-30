package com.example.assignments._spring_rest.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    public enum role {
        USER,
        MANAGER,
        ADMIN;
    };
    private Address address;
    private ArrayList<User> friends;
}
