
package com.icode.framework.utils;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;


/**
 * 证书信任管理器
 * TODO javadoc for com.icode.framework.utils.MyX509TrustManager
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class MyX509TrustManager implements X509TrustManager {

	// 检查客户端证书
	public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
	}

	// 检查服务器端证书
	public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
	}

	// 返回受信任的X509证书数组
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}

}

