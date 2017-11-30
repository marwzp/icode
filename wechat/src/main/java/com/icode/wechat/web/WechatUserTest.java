
package com.icode.wechat.web;

import com.icode.framework.utils.CommonUtil;
import com.icode.framework.utils.WeixinUtil;
import com.icode.wechat.constant.WechatConstant;
import com.icode.wechat.entity.AccessToken;
import com.icode.wechat.entity.user.WeixinUserInfo;


/**
 * 测试获取微信用户
 * TODO javadoc for com.icode.wechat.web.WechatUserTest
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月19日
 */
public class WechatUserTest {

	public static void main(String[] args) {
		//获取凭证
		AccessToken accessToken = CommonUtil.getToken(WechatConstant.APP_ID, WechatConstant.APPSECRET);
		String token = accessToken.getAccessToken();
		
		/**
         * 获取用户信息
         */
        WeixinUserInfo user = WeixinUtil.getWechatUserInfo(token, "o-RrRt-FtsHSzQSOXYHK_V1_Jx84");
        System.out.println("OpenID：" + user.getOpenId());
        System.out.println("关注状态：" + user.getSubscribe());
        System.out.println("关注时间：" + user.getSubscribeTime());
        System.out.println("昵称：" + user.getNickname());
        System.out.println("性别：" + user.getSex());
        System.out.println("国家：" + user.getCountry());
        System.out.println("省份：" + user.getProvince());
        System.out.println("城市：" + user.getCity());
        System.out.println("语言：" + user.getLanguage());
        System.out.println("头像：" + user.getHeadImgUrl());
	}

}

