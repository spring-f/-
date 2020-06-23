package com.tensquare.base.dao;

import com.tensquare.base.pojo.Lable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface LableDao extends JpaRepository<Lable,String>, JpaSpecificationExecutor<Lable> {
    List findByRecommend(String recommend);

    List findByState(String state);


}
