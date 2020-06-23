package com.tensquare.recruit.common;


import com.tensquare.recruit.pojo.Enterprise;
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
public class SpecificationEnterprise implements Specification {
    Enterprise enterprise;

    public SpecificationEnterprise(Enterprise enterprise) {
        super();
        this.enterprise=enterprise;
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList=new ArrayList<Predicate>();
        if (StringUtils.isNotEmpty(enterprise.getName())){
            predicateList.add(criteriaBuilder.like(root.get("name").as(String.class),
                    "%" + enterprise.getName() + "%"));
        }
        if (StringUtils.isNotEmpty(enterprise.getSummary())){
            predicateList.add(criteriaBuilder.like(root.get("summary").as(String.class),
                    "%" + enterprise.getSummary()+ "%"));
        }
        if (StringUtils.isNotEmpty(enterprise.getAddress())){
            predicateList.add(criteriaBuilder.like(root.get("address").as(String.class),
                    "%"+enterprise.getAddress()+"%"));
        }
        if (StringUtils.isNotEmpty(enterprise.getLabels())){
            predicateList.add(criteriaBuilder.like(root.get("labels").as(String.class),
                    "%"+enterprise.getLabels()+"%"));
        }
        if (StringUtils.isNotEmpty(enterprise.getCoordinate())){
            predicateList.add(criteriaBuilder.like(root.get("coordinate").as(String.class),
                    "%"+enterprise.getCoordinate()+"%"));
        }
        if (StringUtils.isNotEmpty(enterprise.getIshot())){
            predicateList.add(criteriaBuilder.like(root.get("ishot").as(String.class),
                    "%"+enterprise.getIshot()+"%"));
        }
        if (StringUtils.isNotEmpty(enterprise.getLogo())){
            predicateList.add(criteriaBuilder.like(root.get("logo").as(String.class),
                    "%"+enterprise.getLogo()+"%"));
        }
        if (enterprise.getJobcount()!=null&&!"".equals(enterprise.getJobcount())){
            predicateList.add(criteriaBuilder.equal(root.get("jobcount").as(Integer.class),
                    enterprise.getJobcount()));
        }
        if (StringUtils.isNotEmpty(enterprise.getUrl())){
            predicateList.add(criteriaBuilder.equal(root.get("url").as(String.class),
                    enterprise.getUrl()));
        }
        if (StringUtils.isNotEmpty(enterprise.getState())){
            predicateList.add(criteriaBuilder.equal(root.get("state").as(String.class),
                    enterprise.getState()));
        }

        return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
    }
}
