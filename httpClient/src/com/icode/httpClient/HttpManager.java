
package com.icode.httpClient;

import java.util.concurrent.TimeUnit;

import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;


/**
 * 链接管理器
 * TODO javadoc for com.icode.httpClient.HttpManager
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年10月18日
 */
public class HttpManager {
	
	public static void main(String[] args) {
		
		HttpClientContext context = HttpClientContext.create();
		
		HttpClientConnectionManager connMrg = new BasicHttpClientConnectionManager();
		
		//路由信息
		HttpRoute route = new HttpRoute(new HttpHost("localhost", 80));
		
		// Request new connection. This can be a long process
		
		ConnectionRequest  connRequest = connMrg.requestConnection(route, null);
		
		HttpClientConnection conn = null;
		
		try {
			// Wait for connection up to 10 sec
			conn = connRequest.get(10, TimeUnit.SECONDS);
			
			if(!conn.isOpen()){
				// establish connection based on its route info
				connMrg.connect(conn, route, 1000, context);
				// and mark it as route complete
				connMrg.routeComplete(conn, route, context);
			}
			
			// Do useful things with the connection.
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			
		}
	}
	

}

