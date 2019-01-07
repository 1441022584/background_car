package com.jk.car.mapper;

import com.jk.car.model.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CarMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    /**
     * 已审核查询总条数
     * @return
     */
    int getTheApprovedPageTotalCount();

    /**
     * 已审核查询list
     * @param map
     * @return
     */
    List<Car> queryTheApprovedPageList(HashMap<String, Object> map);


    /**
     * 未审核查询总条数
     * @return
     */
    int getNotAuditPageTotalCount();

    /**
     * 未审核查询list
     * @param map
     * @return
     */
    List<Car> queryNotAuditPageList(HashMap<String, Object> map);


    /**
     * 品牌销量页面   highcharts 查询
     * @return
     */
    List<Map<String, Object>> queryCarBrandHighchartsList();

    /**
     * 未授权页面  授权
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
     * 逻辑删除数据 将状态改为888deleteOne
     * @param id
     * @return
     */
    void deleteOne(Integer id);


    /**
     * 买车已审核查询总条数
     * @return
     */
    int getaCarHasBeenCarefulPageTotalCount();

    /**
     * 买车已审核查询List
     * @return
     */
    List<Car> queryaCarHasBeenCarefulPageList(HashMap<String, Object> map);


    /**
     * 买车待审核查询总条数
     * @return
     */
    int getaCarPendingPageTotalCount();

    /**
     * 买车待审核查询总条数
     * @return
     */
    List<Car> queryaCarPendingPageList(HashMap<String, Object> map);


    /**
     * 审核 买车授权 将状态修改为4
     * @param car
     * @return
     */
    void UpdateaCarPendingCar(Car car);
}