
package com.icode.framework.utils;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.icode.wechat.constant.WechatConstant;
import com.icode.wechat.entity.user.WeixinUserInfo;
import com.icode.wechat.entity.widget.menu.Menu;

/**
 * 微信公众平台通用接口工具类
 * TODO javadoc for com.icode.framework.utils.WeixinUtil
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月18日
 */
public class WeixinUtil {

	private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);

	/**
	 * 创建菜单
	 * @description: TODO
	 * @creator: wang-zepeng
	 * @createDate: 2017年9月18日 
	 * @modifier:
	 * @modifiedDate:
	 * @param menu
	 * @param accessToken
	 * @return
	 */
	public static int createMenu(Menu menu, String accessToken) {
		int result = 0;
		// 拼装创建菜单的url
		String url = WechatConstant.CREATE_MENU_URL.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 调用接口创建菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", jsonMenu);
		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}
		return result;
	}

	/**
	 * @description: 获取微信用户信息
	 * @creator: wang-zepeng
	 * @createDate: 2017年9月19日 
	 * @modifier:
	 * @modifiedDate:
	 * @param accessToken
	 * @param openId
	 * @return
	 */
	public static WeixinUserInfo getWechatUserInfo(String accessToken, String openId) {
		WeixinUserInfo weixinUserInfo = null;
		String requestUrl = WechatConstant.WECHAT_USER_INFO.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 获取用户信息
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				weixinUserInfo = new WeixinUserInfo();
				// 用户的标识
				weixinUserInfo.setOpenId(jsonObject.getString("openid"));
				// 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
				weixinUserInfo.setSubscribe(jsonObject.getInt("subscribe"));
				// 用户关注时间
				weixinUserInfo.setSubscribeTime(jsonObject.getString("subscribe_time"));
				// 昵称
				weixinUserInfo.setNickname(jsonObject.getString("nickname"));
				// 用户的性别（1是男性，2是女性，0是未知）
				weixinUserInfo.setSex(jsonObject.getInt("sex"));
				// 用户所在国家
				weixinUserInfo.setCountry(jsonObject.getString("country"));
				// 用户所在省份
				weixinUserInfo.setProvince(jsonObject.getString("province"));
				// 用户所在城市
				weixinUserInfo.setCity(jsonObject.getString("city"));
				// 用户的语言，简体中文为zh_CN
				weixinUserInfo.setLanguage(jsonObject.getString("language"));
				// 用户头像
				weixinUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
			} catch (Exception e) {
				if (0 == weixinUserInfo.getSubscribe()) {
					log.error("用户{}已取消关注", weixinUserInfo.getOpenId());
				} else {
					int errorCode = jsonObject.getInt("errcode");
					String errorMsg = jsonObject.getString("errmsg");
					log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
				}
			}
		}
		return weixinUserInfo;
	}

}
