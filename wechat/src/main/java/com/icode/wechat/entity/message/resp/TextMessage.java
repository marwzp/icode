
package com.icode.wechat.entity.message.resp;

/**
 * 文本信息类
 * TODO javadoc for com.icode.wechat.entity.resp.TextMessage
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class TextMessage extends BaseMessage {

	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
