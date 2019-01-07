/**
 * 金融mapperj 接口
 */
package com.jk.car.mapper;

import com.jk.car.model.BorrowerBean;
import com.jk.car.model.StaffBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoansMapper {

    Long queryLoansCount(@Param("borrower") BorrowerBean borrower);

    List<BorrowerBean> loansList(@Param("start") int start, @Param("end") int end, @Param("borrower") BorrowerBean borrower);

    void finishPhone(@Param("borrower") BorrowerBean borrower);

    void endLoans(@Param("borrower") BorrowerBean borrower);

    List<StaffBean> staffList();

    void dispatchStaff(@Param("borrowerBean") BorrowerBean borrowerBean);

    void upStaffstart(@Param("staffId") Integer staffId, @Param("id") Integer id);

    void upStaffstartnull(@Param("id") Integer id, @Param("staffId") Integer staffId);

    void finishAppoint(@Param("id") Integer id, @Param("staffId") Integer staffId);

    void endOeder(@Param("borrower") BorrowerBean borrower);
}
