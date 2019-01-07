/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2019/1/3 16:08
 * Description: 控制层
 * History:
 */
package com.jk.car.controller;

import com.jk.car.model.Car;
import com.jk.car.model.TreeBean;
import com.jk.car.model.UserBean;
import com.jk.car.service.UserService;
import com.jk.car.utils.AliyunOSSUtil;
import com.jk.car.utils.PageResult;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈控制层〉
 *
 * @author admin
 * @create 2019/1/3
 * @since 1.0.0
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;


    /**
     * 登录成功跳转页面
     * @return
     */
    @RequestMapping("index")
    public String index(){

        return "index";
    }

    /**
     * 查询左侧树
     * @return
     */
    @RequestMapping("getTree")
    @ResponseBody
    public List<TreeBean> getTree(){
        List<TreeBean> tree = userService.getTree();
        //System.out.println(tree);
        return tree;
    }


    // 初始化销量保镖
    @RequestMapping("toVolumePage")
    //@RequiresPermissions("user:select")    // 需要权限认证
    public String toVolumePage(){

        return "volumeShow";
    }

    /**
     *  highcharts 查询      返回的总个数必须叫  y  每年销量
     * @return
     */
    @RequestMapping("queryCarYearHighchartsList")
    @ResponseBody
    public List<Map<String,Object>> queryCarYearHighchartsList(){

        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();

        List<Map<String,Object>> queryCarYearHighchartsList = userService.queryCarYearHighchartsList();

        for (Map<String, Object> map : queryCarYearHighchartsList) {

            Map<String, Object>  map1=new HashMap<String,Object>();

            map1.put("y", map.get("总个数"));
            map1.put("c", map.get("年"));
            map1.put("p", map.get("品牌"));
            map1.put("sliced", false);
            map1.put("selected", false);
            list.add(map1);
        }
        return list;
    }



    /**
     * 访问登录页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(){

        return "login";
    }


    // 没有用户跳转的页面
    @RequestMapping("403")
    public String to(){

        return "403";
    }


    /**
     * 登录查询页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("login")
    public String login(HttpServletRequest request, Model model){
        //获得验证的异常信息的名称，提示用户是账号错误还是密码错误
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        System.out.println(exceptionClassName);
        System.out.println(UnknownAccountException.class.getName());
        if(UnknownAccountException.class.getName().equals(exceptionClassName)|| AuthenticationException.class.getName().equals(exceptionClassName)){
            model.addAttribute("flag", "账号不存在");
        }else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            //model.addObject("flag", "密码错误");
        }
        //登录失败之后 再跳转回登录页面
        //访问其他页面时 只要不是登录成功状态 都会跳转到登录页面
        return "login";
    }


    /**
     * 初始化已审核页面
     * @return
     */
    @RequestMapping("toTheApprovedPage")
    /*@RequiresPermissions("user:select")    // 需要权限认证*/
    public String toTheApprovedPage(){
        return "theApproved";
    }

    /**
     * 初始化未审核页面
     * @return
     */
    @RequestMapping("toNotAuditPage")
    /*@RequiresPermissions("user:select")    // 需要权限认证*/
    public String toNotAuditPage(){
        return "notAudit";
    }

    /**
     * 已审核查询分页
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/queryTheApprovedPageList")
    @ResponseBody
    public PageResult queryTheApprovedPageList(Integer page, Integer rows){
        PageResult result = userService.queryTheApprovedPageList(page, rows);
        return result;
    }

    /**
     * 已审核查询分页
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/queryNotAuditPageList")
    @ResponseBody
    public PageResult queryNotAuditPageList(Integer page, Integer rows){
        PageResult result = userService.queryNotAuditPageList(page, rows);
        return result;
    }



    /**
     * 初始化品牌销量页面
     *
     * @return
     */
    @RequestMapping("/tobrandShowPage")
    public String tobrandShowPage() {
        return "brandShow";
    }



    /**
     * 品牌销量页面   highcharts 查询
     *
     * @return
     */
    @RequestMapping("/queryCarBrandHighchartsList")
    @ResponseBody
    public List<Map<String, Object>> queryCarBrandHighchartsList() {
        List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();

        List<Map<String, Object>> list = userService.queryCarBrandHighchartsList();

        for (Map<String, Object> map : list) {

            Map<String, Object> map1 = new HashMap<String, Object>();

            map1.put("y", map.get("个数"));
            list1.add(map1);
        }

        return list1;
    }

    /**
     * 授权
     */
    @RequestMapping("/approved")
    @ResponseBody
    public String approved(Integer id) {
        try {
            userService.approved(id);
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }



    /**
     * 引入 授权弹框页面approvedNotAudit
     */
    @RequestMapping("/toApprovedNotAudit")
    public String toApprovedNotAudit() {
        return "approvedNotAudit";
    }







    /**
     * 上传文件到OSS  返回一个路径
     */
    /*@RequestMapping("/upload")
    public String upload(String img) {
        *//*String blog = AliyunOSSUtil.uploadBlog(file);*//*
        System.out.println(img);
        return null;
    }*/

    /**
     * 上传 图片到OSS阿里服务器
     * @param
     * @return
     */
    @RequestMapping("upload")
    @ResponseBody
    public HashMap<String, String> upload(@RequestParam(value="img",required=false) MultipartFile file
            ,HttpServletRequest request){
        //调用工具类将前台传过来的路径 存入oss阿里云中
        String uploadBlog = AliyunOSSUtil.uploadBlog(file);
        System.out.println(uploadBlog);
        //将session中存贮 ossUrl
        HttpSession session = request.getSession();
        session.setAttribute("OSSDown",uploadBlog);
        //返回前台页面 相应前台
        HashMap<String, String> result = new HashMap<>();
        result.put("img", uploadBlog);
        return result;
    }

    /**
     * 回显操作
     * @param id
     * @return
     */
    @RequestMapping("/queryByCarId")
    @ResponseBody
    public Car queryByCarId(Integer id){
        Car car = userService.queryByCarId(id);
        return car;
    }



    /**
     * 审核 卖车授权 将状态修改为2
     * @param car
     * @return
     */
    @RequestMapping("/saveOrUpdateCar")
    @ResponseBody
    public String saveOrUpdateCar(Car car,HttpServletRequest request){
        try {
            //将session中取值 ossUrl
            String ossUrl = (String) request.getSession().getAttribute("OSSDown");
            car.setCarImg(ossUrl);
            //2是审核参数  直接设置默认值 已通过审核
            car.setCarStatus(2);
            userService.saveOrUpdateCar(car);
            return "1";
        }catch (Exception e){
            return "2";
        }
    }


    /**
     * 审核 买车授权 将状态修改为4
     * @param car
     * @return
     */
    @RequestMapping("/UpdateaCarPendingCar")
    @ResponseBody
    public String UpdateaCarPendingCar(Car car,HttpServletRequest request){
        try {
            car.setCarStatus(4);
            userService.UpdateaCarPendingCar(car);
            return "1";
        }catch (Exception e){
            return "2";
        }
    }

    /**
     * 逻辑删除数据 将状态改为888
     * @param id
     * @return
     */
    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(Integer id){
        try {
            userService.deleteOne(id);
            return "1";
        }catch (Exception e){
            return "0";
        }
    }



    /**
     * 初始化买车待审核页面
     * @return
     */
    @RequestMapping("/toaCarPending")
    public String toaCarPending(){
        return "aCarPending";
    }

    /**
     * 初始化买车已审核页面
     * @return
     */
    @RequestMapping("/toaCarHasBeenCareful")
    public String toaCarHasBeenCareful(){
        return "aCarHasBeenCareful";
    }



    /**
     * 初始化引入买车待审核修改页面
     * @return
     */
    @RequestMapping("/toApprovedaCarPending")
    public String toApprovedaCarPending(){
        return "approvedaCarPending";
    }



    /**
     * 买车待审核  分页查询
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/queryaCarPendingPageList")
    @ResponseBody
    public PageResult queryaCarPendingPageList(Integer page, Integer rows){
        PageResult result = userService.queryaCarPendingPageList(page, rows);
        return result;
    }


    /**
     * 买车已审核  分页查询
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/queryaCarHasBeenCarefulPageList")
    @ResponseBody
    public PageResult queryaCarHasBeenCarefulPageList(Integer page, Integer rows){
        PageResult result = userService.queryaCarHasBeenCarefulPageList(page, rows);
        return result;
    }



    /**
     * 初始化用户黑名单页面
     * @return
     */
    @RequestMapping("/toBlacklists")
    public String toBlacklist(){
        return "Userblacklist";
    }

    /**
     * 初始化用户用户星标页面
     * @return
     */
    @RequestMapping("/toUserStarList")
    public String toUserStarList(){
        return "StarUserList";
    }



    /**
     * 用户黑名单查询分页
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/queryUserblackPageList")
    @ResponseBody
    public PageResult queryUserblackPageList(Integer page, Integer rows, UserBean userBean) {
        PageResult result = userService.queryUserblackPageList(page, rows,userBean);
        return result;
    }

    /**
     * 星标用户查询分页
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/queryStarUserPageList")
    @ResponseBody
    public PageResult queryStarUserPageList(Integer page, Integer rows, UserBean userBean) {
        PageResult result = userService.queryStarUserPageList(page, rows,userBean);
        return result;
    }







    /**
     * 初始化用户黑名单 手机号
     *
     * @return
     */
    @RequestMapping("/initUserPhone")
    @ResponseBody
    public List<UserBean> initUserPhone(){
        return userService.initUserPhone();
    }



    /**
     * 逻辑删除用户  状态改为888
     * @return
     */
    @RequestMapping("/deleteUserOne")
    @ResponseBody
    public String deleteUserOne(Integer id){
        try {
            userService.deleteUserOne(id);
            return "1";
        }catch (Exception e){
            return "0";
        }

    }
    /**
     * 还原用户信息  修改状态为1
     * @param id
     * @constructor
     */
    @RequestMapping("/UpdateUserStatus")
    @ResponseBody
    public String UpdateUserStatus(Integer id){
        try {
            userService.UpdateUserStatus(id);
            return "1";
        }catch (Exception e){
            return "0";
        }

    }

    /**
     * 拉入黑名单  修改状态为2
     * @param id
     * @constructor
     */
    @RequestMapping("/UpdateUserStatusToBlack")
    @ResponseBody
    public String UpdateUserStatusToBlack(Integer id){
        try {
            userService.UpdateUserStatusToBlack(id);
            return "1";
        }catch (Exception e){
            return "0";
        }

    }

    /**
     * 星标用户 修改状态为3
     * @param id
     * @constructor
     */
    @RequestMapping("/UpdateUserStatusToStar")
    @ResponseBody
    public String UpdateUserStatusToStar(Integer id){
        try {
            userService.UpdateUserStatusToStar(id);
            return "1";
        }catch (Exception e){
            return "0";
        }

    }



}
