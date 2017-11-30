
package com.icode.wechat.entity.message.event;

/**
 * 上报地理位置事件
 * TODO javadoc for com.icode.wechat.entity.event.LocationEvent
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class LocationEvent extends BaseEvent {

	// 地理位置纬度
	private String Latitude;

	// 地理位置经度
	private String Longitude;

	// 地理位置精度
	private String Precision;

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}

}
