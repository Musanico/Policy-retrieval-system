package com.musanico.all.controller;

import com.musanico.all.entity.User;
import com.musanico.all.mapper.UserMapper;
import com.musanico.all.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @PostMapping
    public Integer save(@RequestBody User user){
        //新增或者更新
        return userService.save(user);
    }

    // 查询所有数据
    @GetMapping
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return userMapper.deleteById(id);
    }

    //分页查询接口
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize
                                        ) {
        pageNum = (pageNum - 1) * pageSize;
        List<User> data = userMapper.selectPage(pageNum, pageSize);
        Integer total = userMapper.selectTotal();
        Map<String, Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
