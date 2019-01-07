package com.jk.car.mapper;

import com.jk.car.model.Car;
import com.jk.car.model.UserBean;

import java.util.HashMap;
import java.util.List;

/**
 * @author: 褚仪明
 * @date: 2019/1/6 14:17
 * @pescription:
 */
public interface AdminMapper {

    List<UserBean> queryUser(HashMap<String, Object> map);

    int queryUserCount(HashMap<String, Object> map);

    void blacklist(Integer id);

    int queryBlacklistCount(HashMap<String, Object> map);

    List<UserBean> queryBlacklist(HashMap<String, Object> map);

    void updatePss(UserBean userBean);

    void dels(Integer[] ids);

    void updates(Integer id);

}
