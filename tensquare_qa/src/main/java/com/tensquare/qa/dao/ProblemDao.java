package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProblemDao extends JpaRepository<Problem,String>, JpaSpecificationExecutor<Problem> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update tb_problem p set p.state =?1 where p.id = ?2",nativeQuery = true)
    public void delete(String state,String problemId);

    @Transactional
    @Query(value = "select p.* from tb_problem p where p.id in (select l.problemId from tb_pl l where l.tableid= ? ) " +
            "order by p.replytime desc ", nativeQuery = true)
    public Page<Problem> searchNewListLabelPageSize(int labelId, Pageable pageable);

    @Transactional
    @Query(value = "select p.* from tb_problem p where p.id in (select l.problemId from tb_pl l where l.tableid= ? ) " +
            " order by p.reply desc ",nativeQuery = true)
    public Page<Problem> searchHotListLabelPageSize(int labelId, Pageable pageable);
}
