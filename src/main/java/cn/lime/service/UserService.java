package cn.lime.service;

import cn.lime.entity.User;

import java.util.List;

/**
 * @description: User业务层
 * @author: Lime
 * @create: 2019-07-29 11:48
 **/

public interface UserService
{
    /**
     * @Author Lime
     * @Description 通过username查询user
     * @Date 22:07 2019/8/6
     * @Param [record]
     * @return java.util.List<cn.lime.entity.User>
     **/
    List<User> finUserByUsername(User record);

    /**
     * @Author Lime
     * @Description 登录方法
     * @Date 23:08 2019/8/6
     * @Param [record]
     * @return java.util.List<cn.lime.entity.User>
     **/
    List<User> userLoginByUsernameAndPassword(User record);

    /**
     * @Author Lime
     * @Description 注册接口
     * @Date 23:48 2019/8/6
     * @Param [username, password]
     * @return int
     **/
    int userRegisterByUsernameAndPassword(String username, String password);
}
