package cn.lime.service.impl;

import cn.lime.entity.User;
import cn.lime.mapper.UserMapper;
import cn.lime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 用户业务层实现类
 * @author: Lime
 * @create: 2019-08-06 20:43
 **/

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> finUserByUsername(User record)
    {
        return userMapper.finUserByUsername(record);
    }

    @Override
    public List<User> userLoginByUsernameAndPassword(User record)
    {
        return userMapper.userLoginByUsernameAndPassword(record.getUsername(),record.getPassword());
    }

    @Override
    public int userRegisterByUsernameAndPassword(String username, String password)
    {
        try
        {
            userMapper.userRegisterByUsernameAndPassword(username,password);
            return 1;
        }
        catch (Exception e)
        {
            return 0;
        }
    }
}
