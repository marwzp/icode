
package com.icode.wechat.entity.message.resp;

/**
 * 语音model
 * TODO javadoc for com.icode.wechat.entity.resp.Voice
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class Voice extends BaseMessage {

	// 媒体文件id
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
