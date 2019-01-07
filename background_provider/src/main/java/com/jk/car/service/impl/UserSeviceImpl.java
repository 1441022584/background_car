/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2019/1/3 16:10
 * Description:
 * History:
 */
package com.jk.car.service.impl;

import com.jk.car.mapper.CarMapper;
import com.jk.car.mapper.UserMapper;
import com.jk.car.model.Car;
import com.jk.car.model.TreeBean;
import com.jk.car.model.UserBean;
import com.jk.car.service.UserService;
import com.jk.car.utils.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author admin
 * @create 2019/1/3
 * @since 1.0.0
 */
@Service("userService")
public class UserSeviceImpl implements UserService {


    @Resource
    private UserMapper userMapper;

    @Resource
    private CarMapper carMapper;


    @Override
    public List<TreeBean> getTree() {

        Integer id = 0;
        List<TreeBean> treeNode = treeNode(id);
        return  treeNode;

    }

    private List<TreeBean> treeNode(Integer id){
        List<TreeBean> list =   userMapper.treeNode(id);

        for (TreeBean treeBean : list) {
            Integer id2 = treeBean.getId();
            List<TreeBean> treeNode = treeNode(id2);
            if(treeNode==null || treeNode.size()<=0 ) {
                treeBean.setSelectable(true);
            }else {
                treeBean.setSelectable(false);
                treeBean.setNodes(treeNode);
            }
        }
        return list;
    }


    @Override
    public List<Map<String, Object>> queryCarYearHighchartsList() {

        return userMapper.queryCarYearHighchartsList();
    }

    @Override
    public UserBean queryUserByName(String username) {

        return userMapper.queryUserByName(username);
    }

    @Override
    public List<String> queryQuanXian(String username) {
        return userMapper.queryQuanXian(username);
    }



    /**
     * 卖车已审核查询分页
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult queryTheApprovedPageList(Integer page, Integer rows) {
        PageResult pageResult = new PageResult();

        /*PageUtilEasyui<Book> easyui = new PageUtilEasyui<>();

        easyui.setPage(page);
        easyui.setRows(rows);*/

        HashMap<String, Object> map = new HashMap<>();

        map.put("start",( page -1) * rows);
        map.put("end",rows);

        int count = carMapper.getTheApprovedPageTotalCount();

        List<Car> list = carMapper.queryTheApprovedPageList(map);

        pageResult.setRows(list);
        pageResult.setTotal(count);

        return pageResult;
    }

    /**
     * 卖车未审核查询分页
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult queryNotAuditPageList(Integer page, Integer rows) {
        PageResult pageResult = new PageResult();

        /*PageUtilEasyui<Book> easyui = new PageUtilEasyui<>();

        easyui.setPage(page);
        easyui.setRows(rows);*/

        HashMap<String, Object> map = new HashMap<>();

        map.put("start",( page -1) * rows);
        map.put("end",rows);

        int count = carMapper.getNotAuditPageTotalCount();

        List<Car> list = carMapper.queryNotAuditPageList(map);

        pageResult.setRows(list);
        pageResult.setTotal(count);

        return pageResult;
    }





    /**
     * 品牌销量页面   highcharts 查询
     * @return
     */
    @Override
    public List<Map<String, Object>> queryCarBrandHighchartsList() {
        return carMapper.queryCarBrandHighchartsList();
    }

    @Override
    public void approved(Integer id) {
        carMapper.approved(id);
    }

    /**
     * 审核 回显操作 根据id查询返回car对象
     * @param id
     * @return
     */
    @Override
    public Car queryByCarId(Integer id) {
        return carMapper.queryByCarId(id);
    }

    /**
     * 审核 授权 将状态修改为2
     * @param car
     * @return
     */
    @Override
    public void saveOrUpdateCar(Car car) {
        carMapper.saveOrUpdateCar(car);
    }

    /**
     * 逻辑删除数据 将状态改为888
     * @param id
     * @return
     */
    @Override
    public void deleteOne(Integer id) {
        carMapper.deleteOne(id);
    }


    /**
     * 买车待审核  分页查询
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult queryaCarPendingPageList(Integer page, Integer rows) {
        PageResult pageResult = new PageResult();

        HashMap<String, Object> map = new HashMap<>();

        map.put("start",( page -1) * rows);
        map.put("end",rows);

        int count = carMapper.getaCarPendingPageTotalCount();

        List<Car> list = carMapper.queryaCarPendingPageList(map);

        pageResult.setRows(list);
        pageResult.setTotal(count);

        return pageResult;
    }

    /**
     * 买车已审核  分页查询
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult queryaCarHasBeenCarefulPageList(Integer page, Integer rows) {
        PageResult pageResult = new PageResult();

        HashMap<String, Object> map = new HashMap<>();

        map.put("start",( page -1) * rows);
        map.put("end",rows);

        int count = carMapper.getaCarHasBeenCarefulPageTotalCount();

        List<Car> list = carMapper.queryaCarHasBeenCarefulPageList(map);

        pageResult.setRows(list);
        pageResult.setTotal(count);

        return pageResult;
    }


    /**
     * 审核 买车授权 将状态修改为4
     * @param car
     * @return
     */
    @Override
    public void UpdateaCarPendingCar(Car car) {
        carMapper.UpdateaCarPendingCar(car);
    }


    /**
     * 用户黑名单查询分页
     *
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult queryUserblackPageList(Integer page, Integer rows, UserBean userBean) {
        PageResult pageResult = new PageResult();

        HashMap<String, Object> map = new HashMap<>();

        map.put("user",userBean);
        map.put("start",( page -1) * rows);
        map.put("end",rows);

        int count = userMapper.getUserblackPageTotalCount(map);

        List<UserBean> list = userMapper.queryUserblackPageList(map);

        pageResult.setRows(list);
        pageResult.setTotal(count);

        return pageResult;
    }



    /**
     * 初始化用户黑名单 手机号
     *
     * @return
     */
    @Override
    public List<UserBean> initUserPhone() {
        return userMapper.initUserPhone();
    }



    /**
     * 星标用户查询分页
     *
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult queryStarUserPageList(Integer page, Integer rows, UserBean userBean) {
        PageResult pageResult = new PageResult();

        HashMap<String, Object> map = new HashMap<>();

        map.put("user",userBean);
        map.put("start",( page -1) * rows);
        map.put("end",rows);

        int count = userMapper.getStarUserPageTotalCount(map);

        List<UserBean> list = userMapper.queryStarUserPageList(map);

        pageResult.setRows(list);
        pageResult.setTotal(count);

        return pageResult;
    }



    /**
     * 逻辑删除用户  状态改为888
     * @return
     */
    @Override
    public void deleteUserOne(Integer id) {
        userMapper.deleteUserOne(id);
    }

    /**
     * 还原用户信息  修改状态为1
     * @param id
     * @constructor
     */
    @Override
    public void UpdateUserStatus(Integer id) {
        userMapper.UpdateUserStatus(id);
    }

    /**
     * 拉入黑名单  修改状态为2
     * @param id
     * @constructor
     */
    @Override
    public void UpdateUserStatusToBlack(Integer id) {
        userMapper.UpdateUserStatusToBlack(id);
    }

    /**
     * 星标用户 修改状态为3
     * @param id
     * @constructor
     */
    @Override
    public void UpdateUserStatusToStar(Integer id) {
        userMapper.UpdateUserStatusToStar(id);
    }

}
