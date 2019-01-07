/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: MyRealm
 * Author:   zyl
 * Date:     2018/12/26 13:56
 * Description: test
 * History:
 */
package com.jk.car.shiro;


import com.jk.car.model.UserBean;
import com.jk.car.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈test〉
 *
 * @author zyl
 * @create 2018/12/26
 * @since 1.0.0
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userServcice;

    //授权器
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取主身份信息
         UserBean username = (UserBean) principals.getPrimaryPrincipal();
        //根据身份信息获取权限信息
        //模拟从数据库获取到数据
        List<String> permissions = userServcice.queryQuanXian(username.getUsername());
        System.out.println(permissions);
        //将查询到授权信息填充到对象中
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);

        return info;
    }

    //认证器
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.从token取出用户身份信息
        String username = (String) token.getPrincipal();
        UserBean user = userServcice.queryUserByName(username);
        //如果查询不到则返回null
        if (!username.equals(user.getUsername())) {//这里模拟查询不到
            throw new UnknownAccountException();
        }
        //查询到返回认证信息
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());

        return authenticationInfo;
    }

}
