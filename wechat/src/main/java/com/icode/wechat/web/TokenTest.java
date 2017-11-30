
package com.icode.wechat.web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.icode.framework.utils.AccessTokenUtil;
import com.icode.framework.utils.CommonUtil;
import com.icode.framework.utils.MyX509TrustManager;
import com.icode.wechat.constant.WechatConstant;
import com.icode.wechat.entity.AccessToken;


/**
 * 测试获取Token
 * TODO javadoc for com.icode.wechat.web.TokenTest
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class TokenTest {

	public static void main(String[] args) throws Exception{
		
//		//修改appID，secret
//        String tokenUrl = String.format(WechatConstant.ACCEESS_TOKEN_URL,WechatConstant.APP_ID,WechatConstant.APPSECRET);
//        //建立连接
//        URL url = new URL(tokenUrl);
//        HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
//        
//        // 创建SSLContext对象，并使用我们指定的信任管理器初始化
//        TrustManager[] tm = { new MyX509TrustManager() };
//        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
//        sslContext.init(null, tm, new java.security.SecureRandom());
//        // 从上述SSLContext对象中得到SSLSocketFactory对象
//        SSLSocketFactory ssf = sslContext.getSocketFactory();
//        
//        httpUrlConn.setSSLSocketFactory(ssf);
//        httpUrlConn.setDoOutput(true);
//        httpUrlConn.setDoInput(true);
//        
//        // 设置请求方式（GET/POST）
//        httpUrlConn.setRequestMethod("GET");
//        // 取得输入流
//        InputStream inputStream = httpUrlConn.getInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//        //读取响应内容
//        StringBuffer buffer = new StringBuffer();
//        String str = null;
//        while ((str = bufferedReader.readLine()) != null) {
//            buffer.append(str);
//        }
//        
//        bufferedReader.close();
//        inputStreamReader.close();
//        // 释放资源
//        inputStream.close();
//        httpUrlConn.disconnect();
//        //输出返回结果
//        System.out.println(buffer);
		
		  //测试获取AccessToken
		  //getTokenTest();
		  
		  //获取Token并保存
		  getTokenTest2();
	}
	
	public static void getTokenTest(){
		AccessToken token = CommonUtil.getToken(WechatConstant.APP_ID, WechatConstant.APPSECRET);
		System.out.println("access_token:"+token.getAccessToken());
        System.out.println("expires_in:"+token.getExpiresin());
	}
	
	public static void getTokenTest2(){
		AccessToken token=CommonUtil.getToken(WechatConstant.APP_ID, WechatConstant.APPSECRET);
		AccessTokenUtil.saveToken(token);
	}
	
}

