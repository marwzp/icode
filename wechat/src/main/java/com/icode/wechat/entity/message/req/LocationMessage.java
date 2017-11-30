
package com.icode.wechat.entity.message.req;


/**
 * 地理位置消息类
 * TODO javadoc for com.icode.wechat.entity.LocationMessage
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class LocationMessage extends BaseMessage {

	// 地理位置维度
    private String Location_X;
    // 地理位置经度
    private String Location_Y;
    // 地图缩放大小
    private String Scale;
    // 地理位置信息
    private String Label;
	
	public String getLocation_X() {
		return Location_X;
	}
	
	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}
	
	public String getLocation_Y() {
		return Location_Y;
	}
	
	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}
	
	public String getScale() {
		return Scale;
	}
	
	public void setScale(String scale) {
		Scale = scale;
	}
	
	public String getLabel() {
		return Label;
	}
	
	public void setLabel(String label) {
		Label = label;
	}
    
    
    
	
	
}

