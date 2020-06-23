package com.tensquare.base.common;

import com.tensquare.base.pojo.Lable;
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
public class SpecificationLable implements Specification {
    Lable lable;

    public SpecificationLable(Lable lable) {
        super();
        this.lable=lable;
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList=new ArrayList<Predicate>();
        if (StringUtils.isNotEmpty(lable.getLabelname())){
            predicateList.add(criteriaBuilder.like(root.get("labelname").as(String.class),
                    "%" + lable.getLabelname() + "%"));
        }
        if (StringUtils.isNotEmpty(lable.getState())){
            predicateList.add(criteriaBuilder.equal(root.get("state").as(String.class),
                    lable.getState()));
        }
        if (StringUtils.isNotEmpty(lable.getRecommend())){
            predicateList.add(criteriaBuilder.equal(root.get("recommend").as(String.class),
                    lable.getRecommend()));
        }

        return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
    }
}
