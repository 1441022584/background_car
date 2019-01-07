package com.jk.car.service;

import com.jk.car.model.BuyCarBean;

import java.util.List;
import java.util.Map;

/**
 * 方法实现说明
 *
 * @author 王垚
 * <p>
 * $
 * @return $
 * @exception 
 * @date $ $
 */
public interface BuyCarService {
    Long queryCountList();

    List<BuyCarBean> findUserList(Map map);
}
