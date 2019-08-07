package cn.lime.entity;

import java.io.Serializable;

/**
 * @description: 用户实体类
 * @author: Lime
 * @create: 2019-07-29 17:16
 **/

public class User implements Serializable
{

    private Integer id;
    private String username;
    private String password;

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
