
package com.icode.wechat.entity.message.req;

/**
 * 图片消息类
 * TODO javadoc for com.icode.wechat.entity.ImageMessage
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class ImageMessage extends BaseMessage {

	// 图片链接
	private String PicUrl;

	private String MediaId;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
