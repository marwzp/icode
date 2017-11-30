
package com.icode.framework.utils;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;


/**
 * 微信校验工具
 * TODO javadoc for com.icode.utils.CheckUtil
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月15日
 */
public class CheckUtil {
	
	private static final String token = "weixin";
	
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		
		//将传入参数放置到数组中
		String[] arr = new String[] {token, timestamp, nonce};
		//排序
		Arrays.sort(arr);
		// 生成字符串
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
		// sha1加密
		String temp = getSHA1String(content.toString());
		
		return temp.equals(signature); // 与微信传递过来的签名进行比较
	}
	
	private static String getSHA1String(String data){
        return DigestUtils.sha1Hex(data);   // 使用commons codec生成sha1字符串
    }

}

