package com.tensquare.article.service;

import com.tensquare.article.dao.CommentDao;
import com.tensquare.article.pojo.Comment;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Comment> findAll() {
		return commentDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Comment> findSearch(Map whereMap, int page, int size) {
		Specification<Comment> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return commentDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Comment> findSearch(Map whereMap) {
		Specification<Comment> specification = createSpecification(whereMap);
		return commentDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Comment findById(String id) {
		return commentDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param comment
	 */
	public void add(Comment comment) {
		comment.setId( idWorker.nextId()+"" );
		commentDao.save(comment);
	}

	/**
	 * 修改
	 * @param comment
	 */
	public void update(Comment comment) {
		commentDao.save(comment);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		commentDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Comment> createSpecification(Map searchMap) {

		return new Specification<Comment>() {

			@Override
			public Predicate toPredicate(Root<Comment> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 文章id
                if (searchMap.get("article")!=null && !"".equals(searchMap.get("article"))) {
                	predicateList.add(cb.like(root.get("article").as(String.class), "%"+(String)searchMap.get("article")+"%"));
                }
                // 用户id
                if (searchMap.get("userid")!=null && !"".equals(searchMap.get("userid"))) {
                	predicateList.add(cb.like(root.get("userid").as(String.class), "%"+(String)searchMap.get("userid")+"%"));
                }
                // 评论内容
                if (searchMap.get("content")!=null && !"".equals(searchMap.get("content"))) {
                	predicateList.add(cb.like(root.get("content").as(String.class), "%"+(String)searchMap.get("content")+"%"));
                }
                // 状态 0：正常 1：禁用
                if (searchMap.get("state")!=null && !"".equals(searchMap.get("state"))) {
                	predicateList.add(cb.like(root.get("state").as(String.class), "%"+(String)searchMap.get("state")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
