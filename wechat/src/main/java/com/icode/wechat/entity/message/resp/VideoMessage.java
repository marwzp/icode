
package com.icode.wechat.entity.message.resp;

/**
 * 视频消息
 * TODO javadoc for com.icode.wechat.entity.resp.VideoMessage
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class VideoMessage extends BaseMessage {

	// 视频
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}

}
