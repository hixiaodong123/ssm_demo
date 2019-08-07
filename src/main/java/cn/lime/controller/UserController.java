package cn.lime.controller;

import cn.lime.entity.User;
import cn.lime.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * @description: User控制器
 * @author: Lime
 * @create: 2019-07-29 17:17
 **/

@Controller
@RequestMapping("/user")
public class UserController
{
    private final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }

    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public String checkUser(@ModelAttribute User user, Model model, HttpSession session)
    {
        List<User> list;
        User record = new User();
        record.setUsername(user.getUsername());
        list = userService.finUserByUsername(record);
        if (list.size() == 0)
        {
            model.addAttribute("result", "0");//该用户不存在
        }
        else
        {
            record.setPassword(user.getPassword());
            list = userService.userLoginByUsernameAndPassword(record);
            if (list.size() == 0)
            {
                model.addAttribute("result", "1");//密码错误
            }
            else
            {
                record = list.get(0);
                //将用户保存在session里面
                session.setAttribute("user", record);
                model.addAttribute("result", "2");//登录成功
            }
        }

        return "login";
    }

    //跳转到登录成功页面
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(Model model, HttpSession session)
    {
        User user = (User) session.getAttribute("user");
        if (user != null)
        {
            model.addAttribute("user", user);
        }
        return "success";
    }


    //注册
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register()
    {
        return "register";
    }

    @RequestMapping(value = "registerCheck", method = RequestMethod.POST)
    public String registerCheck(@ModelAttribute User user, Model model)
    {
        User record = new User();
        record.setUsername(user.getUsername());
        List<User> list = userService.finUserByUsername(record);
        if (list.size() == 0)
        {
            //说明未被注册
            //调用注册方法
            int flag = userService.userRegisterByUsernameAndPassword(user.getUsername(),user.getPassword());
            if (flag == 1)
            {
                model.addAttribute("result", 1);//注册成功
            }
            else
            {
                model.addAttribute("result", 0);//注册失败
            }
        }
        else
        {
            model.addAttribute("result", 2);//已有人注册
        }
        return "register";
    }


}
