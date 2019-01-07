package com.jk.car.utils;


import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.jk.car.model.ConstantProperties;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
/*
 * @Author : 乔光辉
 * @Date : 2019/1/3$ 20:49$
 * @Description : $
 */
public class AliyunOSSUtil {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AliyunOSSUtil.class);

    public static String upload(File file) {
        logger.info("=========>OSS文件上传开始：" + file.getName());
        String endpoint = ConstantProperties.JAVA4ALL_END_POINT;
        String accessKeyId = ConstantProperties.JAVA4ALL_ACCESS_KEY_ID;
        String accessKeySecret = ConstantProperties.JAVA4ALL_ACCESS_KEY_SECRET;
        String bucketName = ConstantProperties.JAVA4ALL_BUCKET_NAME1;
        String fileHost = ConstantProperties.JAVA4ALL_FILE_HOST;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());

        if (null == file) {
            return null;
        }

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        //容器不存在，就创建
        if (!ossClient.doesBucketExist(bucketName)) {
            ossClient.createBucket(bucketName);
            CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
            createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
            ossClient.createBucket(createBucketRequest);
        }
        //创建文件路径
        String fileUrl = fileHost + "/" + (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + file.getName());
        //上传文件
        PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, file));
        //设置权限 这里是公开读
        ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
        if (null != result) {
            logger.info("==========>OSS文件上传成功,OSS地址：" + fileUrl);
            return fileUrl;
        }
        return fileUrl;
    }


    private static final org.slf4j.Logger uploadlogger = LoggerFactory.getLogger(AliyunOSSUtil.class);

    /**
     * 文件上传
     * @param file/upload/uploadBlog
     */
    /*@RequestMapping(value = "uploadBlog",method = RequestMethod.POST)*/
    public static String uploadBlog(MultipartFile file){

        uploadlogger.info("============>文件上传");
        try {

            if(null != file){
                String filename = file.getOriginalFilename();
                if(!"".equals(filename.trim())){
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    //上传到OSS
                    String upload = upload(newFile);
                    System.out.println();
                    upload = "https://qgh.oss-cn-beijing.aliyuncs.com/"+upload;
                    return upload;
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }





}

