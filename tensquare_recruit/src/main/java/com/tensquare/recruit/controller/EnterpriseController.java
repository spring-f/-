package com.tensquare.recruit.controller;

import com.tensquare.entity.PageResult;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @RequestMapping(method = RequestMethod.GET)
    public Result find(){
        return new Result(true, StatusCode.OK,"查询成功",enterpriseService.find());
    }
    @RequestMapping(value = "/{enterpriseId}")
    public Result findById(@PathVariable String enterpriseId){
        return new Result(true,StatusCode.OK,"查询成功",enterpriseService.findById(enterpriseId));
    }
    @RequestMapping(value = "/{enterpriseId}",method = RequestMethod.PUT)
    public Result updateById(@PathVariable String enterpriseId, @RequestBody Enterprise enterprise){
        enterprise.setId(enterpriseId);
        enterpriseService.updateById(enterprise);
        return new Result(true,StatusCode.OK,"更新成功");
    }
    @RequestMapping(value = "/{enterpriseId}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String enterpriseId){
        enterpriseService.delete(enterpriseId);
        return new Result(true,StatusCode.OK,"删除成功");
    }
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Enterprise enterprise){
        enterpriseService.add(enterprise);
        return new Result(true,StatusCode.OK,"添加成功");
    }
    @RequestMapping(value = "/search/hotlist")
    public Result findByIsHot(){
        return new Result(true,StatusCode.OK,"查询成功",enterpriseService.findByIsHot());
    }
    @RequestMapping(value = "/search")
    public Result findBySearch(@RequestBody Enterprise enterprise){
        return new Result(true,StatusCode.OK,"查询成功",enterpriseService.findBySearch(enterprise));
    }
    @RequestMapping(value = "/search/{page}/{size}")
    public Result findBySearchPageSize(@RequestBody Enterprise enterprise,@PathVariable int page,
                                 @PathVariable int size){
         Page<Enterprise> pagelist =enterpriseService.findBySearchPageSize(enterprise,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Enterprise>(pagelist.getTotalElements(),
                pagelist.getContent()));
    }
}
