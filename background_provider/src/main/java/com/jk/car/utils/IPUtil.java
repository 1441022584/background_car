/** 
 * <pre>项目名称:user_wd 
 * 文件名称:IPUtil.java 
 * 包名:com.jk.wd.utils 
 * 创建日期:2018年10月20日下午1:39:55 
 * Copyright (c) 2018, All Rights Reserved.</pre> 
 */  
package com.jk.car.utils;
import com.alibaba.dubbo.common.utils.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;

/**
 * <pre>项目名称：user_wd    
 * 类名称：IPUtil    
 * 类描述：    
 * 创建人：王栋   
 * 创建时间：2018年10月20日 下午1:39:55    
 * 修改人：王栋      
 * 修改时间：2018年10月20日 下午1:39:55    
 * 修改备注：       
 * @version </pre>    
 */
public class IPUtil {

	//获取客户端ip  
    public static String getIp(HttpServletRequest request) {  
        String ip = request.getHeader("X-Forwarded-For");  
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip  
            int index = ip.indexOf(",");  
            if(index != -1){  
                return ip.substring(0,index);  
            }else{  
                return ip;  
            }  
        }
        ip = request.getHeader("X-Real-IP");  
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){  
            return ip;  
        }  
        return request.getRemoteAddr();  
    }  
	
	/**
     * 从发的request请求的头信息里获取客户端IP地址
     * @param request
     * @return ip 客户端IP地址
     */

    public static String getClientIPAddress(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        /*
         * 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割 "***.***.***.***".length() = 15
         */
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }

        return ip;
    }

    /**
     * 获取本地机器IP地址
     * @return 本地IP地址
     */
    public static String getLocalIPAddress() {

        InetAddress inet = null;

        try {
            inet = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return inet.getHostAddress();
    }

    //测试使用
    public static void main(String[] args) {
         System.out.println(getLocalIPAddress());
    }

}
