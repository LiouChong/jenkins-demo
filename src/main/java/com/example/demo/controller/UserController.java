package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/12 13:33
 */
@RestController
public class UserController {
//    @Autowired
//    private Jedis jedis;

//    @Value("${spring.redis.host}")
//    private String redisUrl;

    @RequestMapping(value = "/docker/test/{username}", method = RequestMethod.GET)
    public String changeToJson(@PathVariable String username) {
        System.out.println("redis url - >>>>>>>>>>>>");
//        System.out.println(redisUrl);
        assert username != null;
        User user = new User();
        if (username.equals("liuchong")) {
            user.setName("liuchong");
            user.setAge(21);
            user.setAddress("cd");
        } else {
            user.setName("zhongxiang");
            user.setAge(21);
            user.setAddress("lq");
        }

        String result = JSONObject.toJSONString(user);

//        jedis.hset("urls",username, result);
        return result;
    }
}
