
package com.icode.wechat.entity;


/**
 * 接口凭证实体
 * TODO javadoc for com.icode.wechat.entity.AccessToken
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class AccessToken {

	private String accessToken;
	
	private int expiresin;
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public int getExpiresin() {
		return expiresin;
	}
	
	public void setExpiresin(int expiresin) {
		this.expiresin = expiresin;
	}
	
	
}

