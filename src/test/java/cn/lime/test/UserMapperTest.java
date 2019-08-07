package cn.lime.test;

import cn.lime.entity.User;
import cn.lime.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description: 测试
 * @author: Lime
 * @create: 2019-08-06 22:10
 **/

public class UserMapperTest extends BaseTest
{

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindUserByUsername()
    {
        User user = new User();
        user.setUsername("zhangsan");
        List<User> users = userMapper.finUserByUsername(user);
        for (User user1 : users)
        {
            System.out.println(user1);
        }
    }

    @Test
    public void testLogin()
    {

        List<User> users = userMapper.userLoginByUsernameAndPassword("zhangsan","123");
        for (User user : users)
        {
            System.out.println(user);
        }
    }
}
