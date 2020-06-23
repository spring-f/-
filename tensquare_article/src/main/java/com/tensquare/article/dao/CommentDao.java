package com.tensquare.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.article.pojo.Comment;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface CommentDao extends JpaRepository<Comment,String>,JpaSpecificationExecutor<Comment>{
	
}
