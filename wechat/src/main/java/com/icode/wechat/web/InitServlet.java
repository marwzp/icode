
package com.icode.wechat.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.icode.framework.thread.TokenThread;
import com.icode.framework.utils.CommonUtil;
import com.icode.wechat.constant.WechatConstant;


public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = -4396330419888259647L;
	
	private static Logger log = LoggerFactory.getLogger(CommonUtil.class);
	
	@Override
	public void init() throws ServletException {
		 log.info("weixin api appid:{}", WechatConstant.APP_ID);
	     log.info("weixin api appsecret:{}", WechatConstant.APPSECRET);
	     //启动定时线程获取AccessToken
	     new Thread(new TokenThread()).start();
	}
}

