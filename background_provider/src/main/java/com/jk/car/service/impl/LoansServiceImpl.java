/**
 * 金融 service实现类
 */
package com.jk.car.service.impl;

import com.jk.car.mapper.LoansMapper;
import com.jk.car.model.BorrowerBean;
import com.jk.car.model.StaffBean;
import com.jk.car.service.LoansService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service("loansService")
public class LoansServiceImpl implements LoansService {
    @Resource
    private LoansMapper loansMapper;

    /**
     * 贷款申请分页条查列表
     * @param page
     * @param rows
     * @param borrower
     * @return
     */
    @Override
    public HashMap<String, Object> loansList(Integer page, Integer rows, BorrowerBean borrower) {
        int start=(page -1) * rows;
        int end = start+rows;
        Long count=loansMapper.queryLoansCount(borrower);
        List<BorrowerBean> list=loansMapper.loansList(start,end,borrower);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    /**
     * 电话联系结束后修改状态
     * @param borrower
     */
    @Override
    public void finishPhone(BorrowerBean borrower) {
        Date time = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current = sdf.format(time);// new Date()为获取当前系统时
        borrower.setFollowTime(current);
        loansMapper.finishPhone(borrower);
    }

    /**
     * 取消申请
     * @param borrower
     */
    @Override
    public void endLoans(BorrowerBean borrower) {
        loansMapper.endLoans(borrower);
    }

    /**
     *陪同员工列表
     * @return
     */
    @Override
    public List<StaffBean> staffList() {

        List<StaffBean> list =  loansMapper.staffList();

        return list;
    }

    /**安排陪同人员
     *
     * @param staffId
     * @param id
     */
    @Override
    public void dispatchStaff(Integer staffId, Integer id) {
        BorrowerBean borrowerBean = new BorrowerBean();
        borrowerBean.setStaffId(staffId);
        borrowerBean.setId(id);
        Date time = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current = sdf.format(time);
        System.out.println(current);// new Date()为获取当前系统时
        borrowerBean.setFollowTime(current);
        loansMapper.dispatchStaff(borrowerBean);//安排陪同人员 修改订单状态


        loansMapper.upStaffstart(staffId,id);//修改派遣人员状态 为接单

    }

    /**
     * 陪同看车人员 已完成贷款方案
     *
     * 修改订单的状态
     * @param
     */
    @Override
    public void finishAppoint(Integer id,Integer staffId) {

        loansMapper.finishAppoint(id,staffId); //完成贷款方案 修改订单的状态为 预定成功
    }
    /**
     * 已完成贷款
     * 修改工作人员状态
     * 修改订单的状态
     * @param
     */
    @Override
    public void endOeder(String loansCompact, Integer id, Integer staffId) {
        loansMapper.upStaffstartnull(id,staffId); //修改派遣人员状态 为休息

        BorrowerBean borrower = new BorrowerBean();
        borrower.setStaffId(staffId);
        borrower.setId(id);
        Date time = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current = sdf.format(time);
        borrower.setFollowTime(current);
        loansMapper.endOeder(borrower);//完成申请订单 修改订单状态





    }


}
