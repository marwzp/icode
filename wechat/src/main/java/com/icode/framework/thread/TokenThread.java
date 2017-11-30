
package com.icode.framework.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.icode.framework.utils.AccessTokenUtil;
import com.icode.framework.utils.CommonUtil;
import com.icode.wechat.constant.WechatConstant;
import com.icode.wechat.entity.AccessToken;


/**
 * TokenThread 
 * 描述: 定时获取微信access_token的线程 </br>
 * TODO javadoc for com.icode.framework.thread.TokenThread
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月18日
 */
public class TokenThread implements Runnable {

	private static Logger log = LoggerFactory.getLogger(TokenThread.class);
	
	public static AccessToken accessToken = null;
	
	public void run() {

		while(true){
			try {
				accessToken = CommonUtil.getToken(WechatConstant.APP_ID, WechatConstant.APPSECRET);
				if (null != accessToken) {
					//调用存储到数据库
					AccessTokenUtil.saveToken(accessToken);
	                log.info("获取access_token成功，有效时长{}秒 token:{}", accessToken.getExpiresin(), accessToken.getAccessToken());
	                // 休眠7000秒
					Thread.sleep((accessToken.getExpiresin() - 200)*1000);
				}else{
					// 如果access_token为null，60秒后再获取
                    Thread.sleep(60 * 1000);
				}
			} catch (InterruptedException  e) {
				try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e1) {
                    log.error("{}", e1);
                }
                log.error("{}", e);
			}
		}
		
	}

}

