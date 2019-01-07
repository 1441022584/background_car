/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2019/1/1 22:48
 * Description: 用户表
 * History:
 */
package com.jk.car.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户表〉
 *
 * @author admin
 * @create 2019/1/1
 * @since 1.0.0
 */
public class UserBean implements Serializable {

    private static final long serialVersionUID = 7347863424235391297L;


    private Integer id;

    private String  username;

    private String  phone;

    private String  password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private Integer ifphoneconfirm;

    public Integer getIfphoneconfirm() {
        return ifphoneconfirm;
    }

    public void setIfphoneconfirm(Integer ifphoneconfirm) {
        this.ifphoneconfirm = ifphoneconfirm;
    }
    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
