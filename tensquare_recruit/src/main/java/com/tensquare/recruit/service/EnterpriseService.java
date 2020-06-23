package com.tensquare.recruit.service;

import com.tensquare.recruit.common.SpecificationEnterprise;
import com.tensquare.recruit.dao.EnterpriseDao;
import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;
    @Autowired
    private IdWorker idWorker;

    public List<Enterprise> find() {
        return enterpriseDao.findAll();
    }

    public Enterprise findById(String enterpriseId) {
        return enterpriseDao.findById(enterpriseId).get();
    }

    public void updateById(Enterprise enterprise) {
        enterpriseDao.save(enterprise);
    }

    public void delete(String enterpriseId) {
        enterpriseDao.deleteById(enterpriseId);
    }

    public void add(Enterprise enterprise) {
        enterprise.setId(idWorker.nextId()+"");
        enterprise.setState("0");
        enterprise.setIshot("1");
        enterpriseDao.save(enterprise);
    }

    public List<Enterprise> findByIsHot() {
        return enterpriseDao.findByIshot("0");
    }

    public List<Enterprise> findBySearch(Enterprise enterprise) {
        return enterpriseDao.findAll(new SpecificationEnterprise(enterprise));
    }

    public Page<Enterprise> findBySearchPageSize(Enterprise enterprise, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return enterpriseDao.findAll(new SpecificationEnterprise(enterprise),pageable);
    }
}
