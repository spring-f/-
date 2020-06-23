package com.tensquare.qa.service;

import com.tensquare.qa.common.SpecificationProblem;
import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.pojo.Problem;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class ProblemService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private ProblemDao problemDao;

    public List<Problem> find() {
        return problemDao.findAll();
    }

    public Problem findById(String problemId) {
        return problemDao.findById(problemId).get();
    }

    public void add(Problem problem) {
        problem.setId(idWorker.nextId()+"");
        problem.setCreatetime(new Date(System.currentTimeMillis()));
        problem.setUpdatetime(problem.getCreatetime());
        problemDao.save(problem);
    }

    public void update(Problem problem) {
        problem.setUpdatetime(new Date(System.currentTimeMillis()));
        problemDao.save(problem);
    }

    public void delete(String problemId) {
        problemDao.delete("2",problemId);
    }

    public List<Problem> search(Problem problem) {
        return problemDao.findAll(new SpecificationProblem(problem)) ;
    }


    public Page<Problem> searchPageSize(Problem problem, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return problemDao.findAll(new SpecificationProblem(problem),pageable) ;
    }

    public Page<Problem> searchNewListLabelPageSize(int labelId, int page, int size) {
        PageRequest pageable= PageRequest.of(page - 1, size);
        return problemDao.searchNewListLabelPageSize(labelId,pageable);
    }

    public Page<Problem> searchHotListLabelPageSize(int labelId, int page, int size) {
        PageRequest pageable = PageRequest.of(page - 1, size);
        return problemDao.searchHotListLabelPageSize(labelId,pageable);
    }

}
