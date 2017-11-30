
package com.icode.wechat.entity.message.event;

/**
 * 扫描带参数二维码事件
 * TODO javadoc for com.icode.wechat.entity.event.QRCodeEvent
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class QRCodeEvent extends BaseEvent {

	// 事件KEY值
	private String EventKey;

	// 用于换取二维码图片
	private String Ticket;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

}
