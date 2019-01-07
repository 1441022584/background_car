package com.jk.car.service.impl;

import com.jk.car.mapper.BuyCarBeanMapper;
import com.jk.car.model.BuyCarBean;
import com.jk.car.service.BuyCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
@Service("buyCarService")
public class BuyCarServiceImpl implements BuyCarService {

    @Resource
    private BuyCarBeanMapper buyCarBeanMapper;

    /**
     * 查询数据库的数据总条数
     * @return
     */
    @Override
    public Long queryCountList() {
        return buyCarBeanMapper.queryCountList();
    }

    /**
     * 分页查询
     * @return
     */
    @Override
    public List<BuyCarBean> findUserList(Map map) {
        return buyCarBeanMapper.findUserList(map);
    }
}
