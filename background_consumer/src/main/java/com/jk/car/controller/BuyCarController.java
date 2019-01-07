package com.jk.car.controller;

import com.jk.car.model.BuyCarBean;
import com.jk.car.service.BuyCarService;
import com.jk.car.utils.ExportExcelMax;
import com.jk.car.utils.JsonUtils;
import com.jk.car.utils.PagerEntity;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
@Controller
public class BuyCarController extends Thread {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private BuyCarService buyCarService;


    /**
     * 大数据导出
     * @param response
     * @throws Exception
     */
    @RequestMapping("downExcel")
    public void downExcel(final HttpServletResponse response) throws Exception{
        //1.查询数据库的数据总条数
        Long count=buyCarService.queryCountList();
        System.out.println(count);
        //分页展示
        Long totalpage =count%1000==0?count/1000:count/1000+1;
        System.out.println(totalpage);
        //定义workbook对象
        final XSSFWorkbook xssfWrkBook =new XSSFWorkbook();
        //定义单列线程池
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //循环页数  有多少页就创建多少线程
        for (int i = 1; i <= totalpage; i++) {
            final int  a= i;
            executor.execute(new Runnable() {

                @Override
                public void run() {
                    //查询数据  分页查询
                    PagerEntity page =new PagerEntity(a,1000);
                    Map map =new HashMap();
                    map.put("page", page.getStart());
                    map.put("rows",page.getPageSize());

                    //标题
                    String title ="用户列表";
                    //列头
                    String[] rowName = {"ID","类型","预约时间","上牌地点","车辆情况","看车地址"};
                    //分页查询
                    List<BuyCarBean> list = new ArrayList<BuyCarBean>();
                    try {
                        list =buyCarService.findUserList(map);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //创建list接收传递的数据
                    List<Object[]>  dataList =new ArrayList<Object[]>();
                    Object[] obj=null;
                    //循环遍历查询的数据然后把数据放到新的list集合中
                    for (BuyCarBean map1 : list) {
                        //创建出序列的长度的object数组
                        obj = new Object[rowName.length];
                        obj[0]=map1.getId();
                        obj[1]=map1.getCartype();
                        obj[2]=map1.getCarLicenseMonth();
                        obj[3]=map1.getCarRoadroller();
                        obj[4]=map1.getCarVehiclecondition();
                        obj[5]=map1.getCarSite();
                        dataList.add(obj);
                    }

                    ExportExcelMax exc =new ExportExcelMax(xssfWrkBook, title, rowName, dataList, response);
                    try {
                        exc.export(a);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            });
            //6线程池停止

        }
        executor.shutdown();
        while(true){
            //7.
            if(executor.isTerminated()){
                String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xlsx";
                String headStr = "attachment; filename=\"" + fileName + "\"";
                response.setContentType("APPLICATION/OCTET-STREAM");
                response.setHeader("Content-Disposition", headStr);
                OutputStream out = response.getOutputStream();
                xssfWrkBook.write(out);
                break;
            }
            //9.
            Thread.sleep(100);
        }
    }

    /**
     * 监听客户端往mogondb新增数据
     * @param hello1
     */
    @RabbitListener(queues = "addBuyCarWY")
    public void process(String hello1){
        BuyCarBean buyCarBean = JsonUtils.jsonToPojo(hello1, BuyCarBean.class);
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String numStr = "" ;
        String trandStr = String.valueOf((Math.random() * 9 + 1) * 1000000);
        buyCarBean.setId(Integer.parseInt(trandStr.substring(0,trandStr.indexOf("."))));

        //System.out.println("1"+buyCarBean);
        mongoTemplate.insert(buyCarBean);

    }


    /**
     * 跳转报表页面
     */
    @RequestMapping("toBuyCarEct")
    public String toBuyCarEct(){
        return "buyCarEct";
    }
    /**
     * 跳转列表页面
     */
    @RequestMapping("toBuyCarPageList")
    public String toBuyCarPageList(){
        return "buyCarPageList";
    }

    @RequestMapping("getBuyCarPageList")
    @ResponseBody
    public HashMap<String, Object> getBuyCarPageList(Integer page, Integer rows,BuyCarBean buyCarBean) throws ParseException {
        Query query = new Query();
        if(buyCarBean.getCartype()!=null && !"".equals(buyCarBean.getCartype())) {
            query.addCriteria(Criteria.where("cartype").regex(buyCarBean.getCartype()));
        }
        if(buyCarBean.getStartTime()!=null  && !"".equals(buyCarBean.getStartTime()) && buyCarBean.getEndTime()!=null && !"".equals(buyCarBean.getEndTime())) {
            query.addCriteria(new Criteria().andOperator(Criteria.where("carLicenseMonth").gte(buyCarBean.getStartTime()),Criteria.where("carLicenseMonth").
                    lte(buyCarBean.getEndTime())));
        }else if(buyCarBean.getStartTime()!=null  && !"".equals(buyCarBean.getStartTime())) {
            query.addCriteria(Criteria.where("carLicenseMonth").gte((buyCarBean.getStartTime())));
        }else if(buyCarBean.getEndTime()!=null && !"".equals(buyCarBean.getEndTime())) {
            query.addCriteria(Criteria.where("carLicenseMonth").lte(buyCarBean.getEndTime()));
        }
        HashMap<String, Object> hashMap = new HashMap<String,Object>();
        hashMap.put("total", mongoTemplate.count(query,BuyCarBean.class));
        query.skip((page-1)*rows);
        query.limit(rows);
        hashMap.put("rows",mongoTemplate.find(query, BuyCarBean.class));
        return hashMap;
    }
}
