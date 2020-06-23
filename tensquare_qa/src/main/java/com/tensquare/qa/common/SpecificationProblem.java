package com.tensquare.qa.common;


import com.tensquare.qa.pojo.Problem;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Data
public class SpecificationProblem implements Specification {
    Problem problem;

    public SpecificationProblem(Problem problem) {
        super();
        this.problem = problem;
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> arrayList=new ArrayList();
        if (StringUtils.isNotEmpty(problem.getTitle())){
            arrayList.add(criteriaBuilder.like(root.get("title").as(String.class),"%"+problem.getTitle()+"%"));
        }
        if (StringUtils.isNotEmpty(problem.getContent())){
            arrayList.add(criteriaBuilder.like(root.get("content").as(String.class),"%"+problem.getContent()+"%"));
        }
        if (StringUtils.isNotEmpty(problem.getContent())){
            arrayList.add(criteriaBuilder.like(root.get("content").as(String.class),"%"+problem.getContent()+"%"));
        }
        if (StringUtils.isNotEmpty(problem.getNickname())){
            arrayList.add(criteriaBuilder.like(root.get("nickname").as(String.class),"%"+problem.getNickname()+"%"));
        }
        Predicate[] predicates1 = arrayList.toArray(new Predicate[arrayList.size()]);
        return criteriaBuilder.and(predicates1);
    }
}
