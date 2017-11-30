
package com.icode.wechat.entity.message.resp;


/**
 * 图文model
 * TODO javadoc for com.icode.wechat.entity.resp.Article
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class Article extends BaseMessage {

	// 图文消息名称
    private String Title;
    // 图文消息描述
    private String Description;
    // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
    private String PicUrl;
    // 点击图文消息跳转链接
    private String Url;
	
	public String getTitle() {
		return Title;
	}
	
	public void setTitle(String title) {
		Title = title;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String description) {
		Description = description;
	}
	
	public String getPicUrl() {
		return PicUrl;
	}
	
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	
	public String getUrl() {
		return Url;
	}
	
	public void setUrl(String url) {
		Url = url;
	}
    
    
	
}

