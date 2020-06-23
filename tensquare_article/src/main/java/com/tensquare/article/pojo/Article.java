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
@Table(name="tb_article")
public class Article implements Serializable{

	@Id
	private String id;//


	
	private String columnid;//专栏id
	private String userid;//用户id
	private String title;//文章标题
	private String content;//文章内容
	private String image;//文章封面
	private java.util.Date createtime;//创建时间
	private java.util.Date updatetime;//更新时间
	private String ispublic;//是否公开 0：不公开 1：公开
	private String istop;//是否置顶  0：不置顶 1：置顶
	private Long visits;//浏览数
	private Long thumbup;//点赞数
	private Long comment;//回复数
	private String state;//审核状态  0：未审核  1：已审核 2：用户禁用 3：管理员禁用
	private String channelid;//关联频道id
	private String url;//url地址
	private String type;//文章类型 0：分享 1：专栏

	
	public String getId() {		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getColumnid() {		
		return columnid;
	}
	public void setColumnid(String columnid) {
		this.columnid = columnid;
	}

	public String getUserid() {		
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTitle() {		
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {		
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {		
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public java.util.Date getCreatetime() {		
		return createtime;
	}
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public java.util.Date getUpdatetime() {		
		return updatetime;
	}
	public void setUpdatetime(java.util.Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getIspublic() {		
		return ispublic;
	}
	public void setIspublic(String ispublic) {
		this.ispublic = ispublic;
	}

	public String getIstop() {		
		return istop;
	}
	public void setIstop(String istop) {
		this.istop = istop;
	}

	public Long getVisits() {		
		return visits;
	}
	public void setVisits(Long visits) {
		this.visits = visits;
	}

	public Long getThumbup() {		
		return thumbup;
	}
	public void setThumbup(Long thumbup) {
		this.thumbup = thumbup;
	}

	public Long getComment() {		
		return comment;
	}
	public void setComment(Long comment) {
		this.comment = comment;
	}

	public String getState() {		
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getChannelid() {		
		return channelid;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}

	public String getUrl() {		
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {		
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	
}
