
package com.icode.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 测试HttpClient
 * TODO javadoc for com.icode.httpClient.Test
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年10月9日
 */
public class Test {

	public static void main(String[] args) {

		//创建默认的httpClient实例.
		HttpClient httpClient = new DefaultHttpClient();

		try {
			//创建httpget.
			//HttpGet httpGet = new HttpGet("http://www.baidu.com/");
			//System.out.println("executing request " + httpGet.getURI());
			HttpPost httpPost = new HttpPost("http://www.baidu.com/");
			System.out.println("executing request " + httpPost.getURI());
			//执行get请求.
			HttpResponse response = httpClient.execute(httpPost);
			//获取响应实体
			HttpEntity entity = response.getEntity();
			System.out.println("--------------------------------------");
			//打印响应状态
			System.out.println(response.getStatusLine());
			if (null != entity) {
				//打印响应内容长度
				System.out.println("Response content length: " + entity.getContentLength());
				//打印响应内容
				System.out.println("Response content: " + EntityUtils.toString(entity));
				System.out.println("------------------------------------");
			}
			
			//设置http context
			CloseableHttpClient HttpClient = HttpClients.createDefault();
			
			//配置请求参数8888
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(1000)
					.setConnectTimeout(1000)
					.build();
			
			HttpGet httpget1 = new HttpGet("http://localhost/1");
			
			httpget1.setConfig(requestConfig);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != httpClient) {
				httpClient.getConnectionManager().shutdown();
			}
		}

	}

}
