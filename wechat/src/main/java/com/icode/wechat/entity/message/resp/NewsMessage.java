
package com.icode.wechat.entity.message.resp;

import java.util.List;


/**
 * 文本消息
 * TODO javadoc for com.icode.wechat.entity.resp.NewsMessage
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年9月16日
 */
public class NewsMessage extends BaseMessage {

	// 图文消息个数，限制为10条以内
    private int ArticleCount;
    // 多条图文消息信息，默认第一个item为大图
    private List<Article> Articles;
	
	public int getArticleCount() {
		return ArticleCount;
	}
	
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	
	public List<Article> getArticles() {
		return Articles;
	}
	
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
    
	
}

