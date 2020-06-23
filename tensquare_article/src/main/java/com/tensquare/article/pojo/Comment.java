package com.tensquare.article.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_comment")
public class Comment implements Serializable{

	@Id
	private String id;//


	
	private String article;//文章id
	private String userid;//用户id
	private String content;//评论内容
	private java.util.Date createtime;//评论时间
	private String state;//状态 0：正常 1：禁用

	
	public String getId() {		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getArticle() {		
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}

	public String getUserid() {		
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getContent() {		
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public java.util.Date getCreatetime() {		
		return createtime;
	}
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public String getState() {		
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}


	
}
