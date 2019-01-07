/**
 * 金融 service接口
 */
package com.jk.car.service;


import com.jk.car.model.BorrowerBean;
import com.jk.car.model.StaffBean;

import java.util.HashMap;
import java.util.List;

public interface LoansService {

    HashMap<String, Object> loansList(Integer page, Integer rows, BorrowerBean borrower);

    void finishPhone(BorrowerBean borrower);

    void endLoans(BorrowerBean borrower);

    List<StaffBean> staffList();

    void dispatchStaff(Integer staffId, Integer id);

    void finishAppoint(Integer id, Integer staffId);

    void endOeder(String loansCompact, Integer id, Integer staffId);

}
