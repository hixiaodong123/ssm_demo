package cn.lime.mapper;

import cn.lime.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User的mapper接口
 */
public interface UserMapper
{

    /**
     * @Author Lime
     * @Description 登录接口
     * @Date 20:53 2019/8/6
     * @Param [username, password]
     * @return cn.lime.entity.User
     **/
    List<User> userLoginByUsernameAndPassword(@Param("username") String username,@Param("password") String password);


    /**
     * @Author Lime
     * @Description  注册接口
     * @Date 20:56 2019/8/6
     * @Param [username, password]
     * @return void
     **/
    void userRegisterByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

    /**
     * @Author Lime
     * @Description 查找user通过username
     * @Date 22:08 2019/8/6
     * @Param [record] 
     * @return java.util.List<cn.lime.entity.User> 
     **/
    List<User> finUserByUsername(User record);
}
