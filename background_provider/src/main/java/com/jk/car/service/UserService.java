/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2019/1/3 16:08
 * Description:
 * History:
 */
package com.jk.car.service;

import com.jk.car.model.Car;
import com.jk.car.model.TreeBean;
import com.jk.car.model.UserBean;
import com.jk.car.utils.PageResult;

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
public interface UserService {



    List<TreeBean> getTree();

    List<Map<String, Object>> queryCarYearHighchartsList();

    UserBean queryUserByName(String username);

    List<String> queryQuanXian(String username);

    /**
     * 已审核查询分页
     * @param page
     * @param rows
     * @return
     */
    PageResult queryTheApprovedPageList(Integer page, Integer rows);



    /**
     * 未审核查询分页
     * @param page
     * @param rows
     * @return
     */
    PageResult queryNotAuditPageList(Integer page, Integer rows);

    /**
     * 品牌月销量页面   highcharts 查询
     * @return
     */
    List<Map<String, Object>> queryCarBrandHighchartsList();

    /**
     * 授权
     * @param id
     */
    void approved(Integer id);



    /**
     * 审核 回显操作 根据id查询返回car对象
     * @param id
     * @return
     */
    Car queryByCarId(Integer id);



    /**
     * 审核 授权 将状态修改为2
     * @param car
     * @return
     */
    void saveOrUpdateCar(Car car);



    /**
     * 逻辑删除数据 将状态改为888
     * @param id
     * @return
     */
    void deleteOne(Integer id);


    /**
     * 买车待审核  分页查询
     * @param page
     * @param rows
     * @return
     */
    PageResult queryaCarPendingPageList(Integer page, Integer rows);


    /**
     * 买车已审核  分页查询
     * @param page
     * @param rows
     * @return
     */
    PageResult queryaCarHasBeenCarefulPageList(Integer page, Integer rows);



    /**
     * 审核 买车授权 将状态修改为4
     * @param car
     * @return
     */
    void UpdateaCarPendingCar(Car car);


    /**
     * 用户黑名单查询分页
     *
     * @param page
     * @param rows
     * @return
     */
    PageResult queryUserblackPageList(Integer page, Integer rows, UserBean userBean);



    /**
     * 初始化用户黑名单 手机号
     *
     * @return
     */
    List<UserBean> initUserPhone();



    /**
     * 星标用户查询分页
     *
     * @param page
     * @param rows
     * @return
     */
    PageResult queryStarUserPageList(Integer page, Integer rows, UserBean userBean);



    /**
     * 逻辑删除用户  状态改为888
     * @return
     */
    void deleteUserOne(Integer id);

    /**
     * 还原用户信息  修改状态为1
     * @param id
     * @constructor
     */
    void UpdateUserStatus(Integer id);

    /**
     * 拉入黑名单  修改状态为2
     * @param id
     * @constructor
     */
    void UpdateUserStatusToBlack(Integer id);



    /**
     * 星标用户 修改状态为3
     * @param id
     * @constructor
     */
    void UpdateUserStatusToStar(Integer id);


}
