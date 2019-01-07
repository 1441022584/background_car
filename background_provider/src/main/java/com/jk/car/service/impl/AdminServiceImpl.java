package com.jk.car.service.impl;

import com.jk.car.mapper.AdminMapper;
import com.jk.car.mapper.UserMapper;
import com.jk.car.model.UserBean;
import com.jk.car.service.AdminServce;
import com.jk.car.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author: 褚仪明
 * @date: 2019/1/6 14:16
 * @pescription:
 */
@Service("adminService")
public class AdminServiceImpl implements AdminServce {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public PageResult queryUser(Integer page, Integer rows, UserBean userBean) {
        PageResult pageResult = new PageResult();


        HashMap<String, Object> map = new HashMap<>();

        map.put("user",userBean);
        map.put("start",( page -1) * rows);
        map.put("end",rows);

        int count = userMapper.queryUserOneCount(map);

        List<UserBean> list = userMapper.queryUserOne(map);

        pageResult.setRows(list);
        pageResult.setTotal(count);

        return pageResult;
    }

    @Override
    public void blacklist(Integer id) {
        adminMapper.blacklist(id);
    }

    @Override
    public PageResult queryBlacklist(Integer page, Integer rows, UserBean userBean) {
        PageResult pageResult = new PageResult();

        HashMap<String, Object> map = new HashMap<>();

        map.put("userBean",userBean);
        map.put("page",page);
        map.put("rows",rows);
        int count = adminMapper.queryBlacklistCount(map);

        List<UserBean> list = adminMapper.queryBlacklist(map);

        pageResult.setRows(list);
        pageResult.setTotal(count);

        return pageResult;
    }

    @Override
    public void updatePss(UserBean userBean) {
        adminMapper.updatePss(userBean);
    }

    @Override
    public void dels(Integer[] ids) {
        adminMapper.dels(ids);
    }

    @Override
    public void updates(Integer id) {
        adminMapper.updates(id);
    }

}
