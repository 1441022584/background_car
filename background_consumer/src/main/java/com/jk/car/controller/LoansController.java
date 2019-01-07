/**
 * 金融controller
 *
 */
package com.jk.car.controller;

import com.jk.car.model.BorrowerBean;
import com.jk.car.model.StaffBean;
import com.jk.car.service.LoansService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
public class LoansController {

    @Resource
    private LoansService loansService;

    /**
     *   跳转金融后台页面
     */
    @RequestMapping("toLoadsListPage")
    public String  toLoadsListPage(){

        return "loadsList";
    }

    /**
     * 展示贷款人的行信息列表
     * @param page
     * @param rows
     * @param borrower
     * @return
     */
    @RequestMapping("loansList")
    @ResponseBody
    public HashMap<String, Object> loansList(Integer page, Integer rows, BorrowerBean borrower){
        HashMap<String, Object> map= loansService.loansList(page,rows,borrower);
        return map;
    }

    /**
     * 完成通话后修改状态
     */
    @RequestMapping("finishPhone")
    @ResponseBody
    public boolean finishPhone(BorrowerBean borrower){
        loansService.finishPhone(borrower);
        return true;
    }

    /**
     * 取消申请修改状态
     */
    @RequestMapping("endLoans")
    @ResponseBody
    public boolean endLoans(BorrowerBean borrower){
        loansService.endLoans(borrower);
    return true;
    }

    /**
     * 陪同看车员工 列表
     */
    @RequestMapping("staffList")
    @ResponseBody
    public List<StaffBean> staffList(){
        List<StaffBean> list = loansService.staffList();
        return list;
    }

   /* url:'../dispatchStaff',
    type:'post',
    data:{staffId:staffid,id:loansid},*/
    /**
     * 选择陪同看车人员
     */
    @RequestMapping("dispatchStaff")
    @ResponseBody
    public boolean dispatchStaff(Integer staffId,Integer id){
        loansService.dispatchStaff(staffId,id);
        return true;
    }
    /**
     * 陪同看车人员 已完成贷款方案
     * 修改状态
     */
    @RequestMapping("finishAppoint")
    @ResponseBody
     public boolean finishAppoint(Integer id,Integer staffId){
         loansService.finishAppoint(id,staffId);
         return true;
     }

    /**
     * 已完成贷款方案
     * 修改状态
     */
    @RequestMapping("endOeder")
    @ResponseBody
    public boolean endOeder(String loansCompact,Integer id,Integer staffId){
        loansService.endOeder(loansCompact,id,staffId);
        return true;
    }



}
