
package com.icode.wechat.entity.message.req;

/**
 * 语音消息
 * TODO javadoc for com.icode.wechat.entity.VoiceMessage
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class VoiceMessage extends BaseMessage {

	// 媒体ID
	private String MediaId;

	// 语音格式
	private String Format;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

}
