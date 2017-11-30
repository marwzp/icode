
package com.icode.wechat.constant;

/**
 * 微信常量类
 * TODO javadoc for com.icode.wechat.constant.WechatConstant
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class WechatConstant {

	public static final String APP_ID = "wxaa194b14940d35a9";

	public static final String APPSECRET = "eb6bdcfe00e7652dee7bc63aa88ce175";

	//获取AccessToken接口
	public static final String ACCEESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	//创建菜单接口
	public static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	//获取微信用户信息接口
	public static final String WECHAT_USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	//批量获取微信用户接口
	public static final String BATCH_GET = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";
	
}
