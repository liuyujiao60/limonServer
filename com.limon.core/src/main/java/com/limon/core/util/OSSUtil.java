package com.limon.core.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectResult;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

public class OSSUtil {
	private static OSSClient client;
	
	static{
		String endpoint = "http://oss-cn-zhangjiakou.aliyuncs.com/";
        String accessKeyId = "LTAILYH33UMdB6eB";
        String accessKeySecret = "EmqeTkhxM1K6OS2vvR1ZNhgl8w393a";
        
        client = new OSSClient(endpoint,accessKeyId, accessKeySecret);
	}
	
    public static String putObject(String bucketName,String fileName,InputStream content) throws FileNotFoundException {
        try{
            // 上传Object.
            PutObjectResult result = client.putObject(bucketName, fileName, content);
            
            String url=getImgUrl(bucketName, fileName);
            return url;
        }catch(OSSException oe){
            System.out.println("Error Message: " + oe.getErrorCode());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
        }
		return null;     
    }
    
    public static String getImgUrl(String bucketName,String fileUrl) {
    	if (!StringUtils.isEmpty(fileUrl)) {
    		return getUrl(bucketName,fileUrl);
    	}
    	return null;
    }
    
    public static String getUrl(String bucketName,String key) {
        // 设置URL过期时间为10年  3600l* 1000*24*365*10
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = client.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
          return url.toString();
        }
        return null;
    }
}
