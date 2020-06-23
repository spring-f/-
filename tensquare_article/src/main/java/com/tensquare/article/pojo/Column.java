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
@Table(name="tb_column")
public class Column implements Serializable{

	@Id
	private String id;//


	
	private String name;//专栏名称
	private String summary;//专栏内容
	private String userid;//用户id
	private java.util.Date createtime;//创建时间
	private java.util.Date updatetime;//更新时间
	private String state;//栏目状态 0：正常 1：用户禁用 2：管理员禁用

	
	public String getId() {		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {		
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getUserid() {		
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getState() {		
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}


	
}
