package com.jk.car.service;

import com.jk.car.model.UserBean;
import com.jk.car.utils.PageResult;
import org.springframework.stereotype.Service;

/**
 * @author: 褚仪明
 * @date: 2019/1/6 14:14
 * @pescription:
 */

public interface AdminServce {

    PageResult queryUser(Integer page, Integer rows, UserBean userBean);

    void blacklist(Integer id);

    PageResult queryBlacklist(Integer page, Integer rows, UserBean userBean);

    void updatePss(UserBean userBean);

    void dels(Integer[] ids);

    void updates(Integer id);
}
