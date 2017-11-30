
package com.icode.httpClient;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;


/**
 * 测试自定义请求重新启动
 * TODO javadoc for com.icode.httpClient.RequestRetryHandler
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年10月18日
 */
public class RequestRetryHandler {

	public static void main(String[] args) {
		
		
		HttpRequestRetryHandler myRetryHandler  = new HttpRequestRetryHandler(){
			
			@Override
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				
				/**
				 * 异常处理
				 */
				if(executionCount >= 5){
					// Do not retry if over max retry count
					return false;
				}
				
				if(exception instanceof InterruptedIOException){
					// Timeout
					return false;
				}
				
				if (exception instanceof UnknownHostException) {
					// Unknown host
					return false;
				}
				
				if (exception instanceof ConnectTimeoutException) {
					// Connection refused
					return false;
				}
				
				if (exception instanceof SSLException) {
					// SSL handshake exception
					return false;
				}
				
				/**
				 * 处理自定义请求重启
				 */
				
				//适配请求上下文
				HttpClientContext clientContext = HttpClientContext.adapt(context);
				
				//从上下文中获取请求
				HttpRequest request = clientContext.getRequest();
				
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
				
				if (idempotent) {
					// Retry if the request is considered idempotent
					return true;
				}
				
				return false;
			}
		};
		
		//请求绑定处理自定义重启方式
		CloseableHttpClient  httpClient = HttpClients.custom().setRetryHandler(myRetryHandler).build();
		
		

	}

}

