
package com.icode.wechat.entity.message.resp;


/**
 * 音乐消息
 * TODO javadoc for com.icode.wechat.entity.resp.MusicMessage
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class MusicMessage extends BaseMessage {

	// 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
	
	
}

