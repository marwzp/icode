
package com.icode.httpClient;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.message.BasicHttpResponse;


public class HttpResponse1 {

	public static void main(String[] args) {
		
		//创建响应：设定协议版本，请求状态
		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
		
		response.addHeader("Set-Cookie","c1=a; path=/; domain=localhost");
		response.addHeader("Set-Cookie", "c2=b; path=\"/\", c3=c; domain=\"localhost\"");
		
		/*Header h1 = response.getFirstHeader("Set-Cookie");
		System.out.println(h1);
		Header h2 = response.getLastHeader("Set-Cookie");
		System.out.println(h2);
		Header[] hs = response.getHeaders("Set-Cookie");
		System.out.println(hs.length);*/
		
		HeaderIterator it = response.headerIterator("Set-Cookie");

		/*while (it.hasNext()) {
		    System.out.println(it.next());
		}
		*/
		
		
		
		System.out.println(response.getProtocolVersion());
		
		System.out.println(response.getStatusLine().getStatusCode());
		
		System.out.println(response.getStatusLine().getReasonPhrase());
		
		System.out.println(response.getStatusLine().toString());
	}
	
	
	
}

