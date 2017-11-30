
package com.icode.wechat.entity.message.event;

/**
 * 自定义菜单事件
 * TODO javadoc for com.icode.wechat.entity.event.MenuEvent
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class MenuEvent extends BaseEvent {

	// 事件KEY值，与自定义菜单接口中KEY值对应
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

}
