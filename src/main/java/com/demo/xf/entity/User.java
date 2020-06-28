package com.demo.xf.entity;

/**
 * @Author: Xiong Feng
 * @Date: 2020/6/24 10:19
 * @Description:
 */
public class User {
    private String username;
    private String password;
    private Integer age;
    private String gender;

    public User() {
    }

    public User(String username, Integer age, String gender) {
        this.username = username;
        this.age = age;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
