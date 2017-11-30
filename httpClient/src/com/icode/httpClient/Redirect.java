
package com.icode.httpClient;

import java.net.URI;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


/**
 * 重定向
 * TODO javadoc for com.icode.httpClient.Redirect
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年10月18日
 */
public class Redirect {

	public static void main(String[] args) throws Exception {
		
		//重定向处理
		/*LaxRedirectStrategy redirectStrategy = new LaxRedirectStrategy();
		
		CloseableHttpClient httpclient = HttpClients.custom()
				.setRedirectStrategy(redirectStrategy)
				.build();*/
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpClientContext context = HttpClientContext.create();
		HttpGet httpget = new HttpGet("http://localhost:8080/");
		CloseableHttpResponse response = httpclient.execute(httpget, context);
		try {
			HttpHost target = context.getTargetHost();
			List<URI> redirectLocations = context.getRedirectLocations();
			URI location = URIUtils.resolve(httpget.getURI(), target, redirectLocations);
			System.out.println("Final HTTP location: " + location.toASCIIString());
			// Expected to be an absolute URI
		} finally {
		response.close();
		}
	}

}

