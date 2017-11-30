
package com.icode.wechat.entity.widget.menu;

/**
 * 菜单按钮
 * TODO javadoc for com.icode.wechat.entity.widget.menu.Button
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月18日
 */
public class Button {

	private String name;//所有一级菜单、二级菜单都共有一个相同的属性，那就是name

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
