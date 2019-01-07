/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2019/1/3 16:10
 * Description:
 * History:
 */
package com.jk.car.mapper;

import com.jk.car.model.TreeBean;
import com.jk.car.model.UserBean;

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
public interface UserMapper {


    List<TreeBean> treeNode(Integer id);

    List<Map<String, Object>> queryCarYearHighchartsList();

    UserBean queryUserByName(String username);

    List<String> queryQuanXian(String username);

    /**
     * 根据car表userid两表联查 返回user对象
     * @param id
     * @return
     */
    UserBean queryByIdUserBean(Integer id);


    /**
     * 用户黑名单查询分页 总条数
     *
     * @return
     */
    int getUserblackPageTotalCount(HashMap<String, Object> map);



    /**
     * 用户黑名单查询分页
     *
     * @return
     */
    List<UserBean> queryUserblackPageList(HashMap<String, Object> map);



    /**
     * 初始化用户黑名单 手机号
     *
     * @return
     */
    List<UserBean> initUserPhone();



    /**
     * 星标用户查询分页 条数
     *
     * @return
     */
    int getStarUserPageTotalCount(HashMap<String, Object> map);

    /**
     * 星标用户查询分页
     *
     */
    List<UserBean> queryStarUserPageList(HashMap<String, Object> map);

    /**
     * 逻辑删除用户  状态改为888
     * @return
     */
    void deleteUserOne(Integer id);

    /**
     * 还原用户信息  修改状态为1
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



    /**
     * 普通用户查询 总条数 查1
     * @constructor
     */
    int queryUserOneCount(HashMap<String, Object> map);


    /**
     * 普通用户查询 查1
     * @constructor
     */
    List<UserBean> queryUserOne(HashMap<String, Object> map);
}
