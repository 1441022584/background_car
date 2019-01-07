package com.jk.car.mapper;

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
public interface BuyCarBeanMapper {

    Long queryCountList();

    List<BuyCarBean> findUserList(Map map);
}
