package com.example.SpringRedisdemo;


import java.util.List;

public interface UserService {

    boolean saveUser(User user);

    List<User> fetchAllUser();



}