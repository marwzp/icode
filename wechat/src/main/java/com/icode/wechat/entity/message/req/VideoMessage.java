
package com.icode.wechat.entity.message.req;

/**
 * 视频消息类
 * TODO javadoc for com.icode.wechat.entity.VideoMessage
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class VideoMessage extends BaseMessage {

	// 媒体ID
    private String MediaId;
    // 语音格式
    private String ThumbMediaId;
	
	public String getMediaId() {
		return MediaId;
	}
	
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
    
    

}
