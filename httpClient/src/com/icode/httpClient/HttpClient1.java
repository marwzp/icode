
package com.icode.httpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class HttpClient1 {
	
	public static void main(String[] args){
		
		//创建一个请求对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		CloseableHttpResponse response = null;
		
		try {
			
			//模拟form表单
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			formparams.add(new BasicNameValuePair("param1", "value1"));
			formparams.add(new BasicNameValuePair("param2", "value2"));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
			
			//使用GET方式请求
			//HttpGet httpGet = new HttpGet("https://www.baidu.com");
			
			//post 方式
			HttpPost httppost = new HttpPost("http://www.baidu.com");
			
			httppost.setEntity(entity);
			
			System.out.println("执行 url:"+httppost.getURI());
			
			response = httpClient.execute(httppost);
			
			System.out.println("开始解析请求响应：===============================》");
			
			HttpEntity httpEntity = response.getEntity();
			
			System.out.println("请求内容长度："+httpEntity.getContentLength());
			System.out.println("请求类型："+httpEntity.getContentType());
			System.out.println("请求编码："+httpEntity.getContentEncoding());
			
			long len = httpEntity.getContentLength();
	        if (len != -1 && len < 2048) {
	            System.out.println(EntityUtils.toString(httpEntity));
	        } else {
	            // Stream content out
	        }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}

