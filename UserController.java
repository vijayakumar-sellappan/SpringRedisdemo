package com.example.SpringRedisdemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity <String> saveUser(@RequestBody User user)
    {
        boolean result = userService.saveUser(user);
        if (result)
            return ResponseEntity.ok("User Created Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> fetchAllUser()
    {
        List<User> users;
        users = userService.fetchAllUser();
        return ResponseEntity.ok(users);
    }


}