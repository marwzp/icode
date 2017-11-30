
package com.icode.wechat.entity.message.resp;

/**
 * 响应消息类
 * TODO javadoc for com.icode.wechat.entity.resp.BaseMessage
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class BaseMessage {

	// 接收方帐号（收到的OpenID）
	private String ToUserName;

	// 开发者微信号
	private String FromUserName;

	// 消息创建时间 （整型）
	private long CreateTime;

	// 消息类型
	private String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

}
