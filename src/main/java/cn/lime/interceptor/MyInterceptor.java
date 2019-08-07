package cn.lime.interceptor;

import cn.lime.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 自定义拦截器
 * @author: Lime
 * @create: 2019-08-07 09:32
 **/

public class MyInterceptor implements HandlerInterceptor
{

    /**
     * @return boolean
     * @Author Lime
     * @Description 预处理方法, 该方法会在请求到达controller之前拦截处理
     * @Date 9:35 2019/8/7
     * @Param [request, response, handler]
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {

        try
        {
            User user = ((User) request.getSession().getAttribute("user"));
            if (user != null)
            {
                //说明登录了,直接放行
                return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //不管是类型转换异常还是其他,都不应该放行
            response.sendRedirect(request.getContextPath() + "/user/login");
            return false;
        }
        //如果没有拿到session，也说明未登录
        request.setAttribute("result","3");
        request.getRequestDispatcher("/user/login").forward(request,response);
        //response.sendRedirect(request.getContextPath() + "/user/login");
        return false;
    }
}
