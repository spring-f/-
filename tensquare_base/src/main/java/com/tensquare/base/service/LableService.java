package com.tensquare.base.service;

import com.tensquare.base.common.SpecificationLable;
import com.tensquare.base.dao.LableDao;
import com.tensquare.base.pojo.Lable;
import com.tensquare.entity.State;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class LableService {

    @Autowired
    private LableDao lableDao;

    @Autowired
    private IdWorker idWorker;

    public List<Lable> findAll() {
        return lableDao.findAll();
    }

    public Lable findById(String id) {
        return lableDao.findById(id).get();
    }

    public List<Lable> findByRecommend() {
        return lableDao.findByRecommend(State.STATE_0);
    }

    public Object findByState(){
        return lableDao.findByState(State.STATE_0);
    }

    public void add(Lable lable) {

        lable.setId(idWorker.nextId()+"");
        lable.setCount(0);
        lable.setFans(0);
        lable.setRecommend("0");
        lable.setState(State.STATE_0);
        lableDao.save(lable);
    }

    public void update(Lable lable) {
        lableDao.save(lable);
    }

    public void delete(String id) {
        lableDao.deleteById(id);
    }


    public List<Lable> findSearch(Lable lable) {
        return lableDao.findAll(new SpecificationLable(lable));
    }

    public Page<Lable> findSearchPageSize(Lable lable, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return lableDao.findAll(new SpecificationLable(lable), pageable);
    }


}