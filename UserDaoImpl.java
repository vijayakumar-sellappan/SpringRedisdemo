package com.example.SpringRedisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "USER";
/*
    @Override
    public boolean saveUser(User user) {
        try {
            redisTemplate.opsForHash().put(KEY, user.getId().toString(), user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
*/
    @Override
    public List<User> fetchAllUser() {
        List<User> users;
        users = redisTemplate.opsForSet().pop(KEY,5);
        return users;
    }
@Override
    public boolean saveUser(User user) {
        try {
            redisTemplate.opsForSet().add(KEY,user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
