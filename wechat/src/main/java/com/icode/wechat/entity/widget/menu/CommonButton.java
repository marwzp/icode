
package com.icode.wechat.entity.widget.menu;

/**
 * 描述: 子菜单项 :没有子菜单的菜单项，有可能是二级菜单项，也有可能是不含二级菜单的一级菜单。 </br>
 * TODO javadoc for com.icode.wechat.entity.widget.menu.CommonButton
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月18日
 */
public class CommonButton extends Button {

	private String type;

	private String key;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
