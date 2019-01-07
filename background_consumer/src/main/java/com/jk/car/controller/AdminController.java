package com.jk.car.controller;

import com.jk.car.model.UserBean;
import com.jk.car.service.AdminServce;
import com.jk.car.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author: 褚仪明
 * @date: 2019/1/6 14:13
 * @pescription:
 */
@Controller
public class AdminController {

    @Resource
    private AdminServce adminServce;


    /**
         * Description: 删除
         *
         * @param:  * @param null
         * @return:
         * @auther: cym
         * @date:  22:30
         */
    @RequestMapping("/deletes")
    @ResponseBody
    public void deletes(Integer id){
        adminServce.updates(id);
    }
/**
     * Description: 删除用户
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  21:48
     */
    @RequestMapping("/delsUser")
    @ResponseBody
    public Boolean dels(Integer[] ids) {
        try {
            adminServce.dels(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
         * Description: 修改密码
         *
         * @param:  * @param null
         * @return:
         * @auther: cym
         * @date:  20:30
         */
    @RequestMapping("/updatePss")
    @ResponseBody
    public void updatePss(UserBean userBean){
        adminServce.updatePss(userBean);
    }

    /**
         * Description: 查询用户
         *
         * @param:  * @param null
         * @return:
         * @auther: cym
         * @date:  14:37
         */
    @RequestMapping("/queryUser")
    @ResponseBody
    public PageResult queryUser(Integer page, Integer rows, UserBean userBean){
        PageResult result = adminServce.queryUser(page, rows,userBean);
        return result;
    }
/**
     * Description: 加入黑名单
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  19:17
     */

    @RequestMapping("/blacklist")
    @ResponseBody
    public void blacklist(Integer id){
         adminServce.blacklist(id);
    }
/**
     * Description: 跳转到用户页面
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  14:36
     */

    @RequestMapping("toAdmin")
    public String toLogin(){

        return "adminList";
    }

    /**
         * Description:
         *
         * @param:  * @param null
         * @return:
         * @auther: cym
         * @date:  19:42
         */
    @RequestMapping("toBlacklist")
    public String toBlacklist(){

        return "blacklist";
    }
    /**
     * Description: 黑名单
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  14:37
     */
    @RequestMapping("/queryBlacklist")
    @ResponseBody
    public PageResult queryBlacklist(Integer page, Integer rows, UserBean userBean){
        PageResult result = adminServce.queryBlacklist(page, rows,userBean);
        return result;
    }
}
