
package com.icode.wechat.entity.message.resp;

/**
 * TODO javadoc for com.icode.wechat.entity.resp.VoiceMessage
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class VoiceMessage extends BaseMessage {

	// 语音
	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}

}
