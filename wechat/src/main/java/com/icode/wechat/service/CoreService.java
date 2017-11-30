
package com.icode.wechat.service;

import javax.servlet.http.HttpServletRequest;


/**
 * 核心服务接口
 * TODO javadoc for com.icode.wechat.service.CoreService
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public interface CoreService {

	
	/**
	 * @description: 核心处理业务方法
	 * @creator: wang-zepeng
	 * @createDate: 2017年9月16日 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @return
	 */
	public String processRequest(HttpServletRequest request);
	
}

