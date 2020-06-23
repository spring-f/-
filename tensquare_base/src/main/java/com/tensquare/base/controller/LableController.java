package com.tensquare.base.controller;

import com.tensquare.base.pojo.Lable;
import com.tensquare.base.service.LableService;
import com.tensquare.entity.PageResult;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/lable")
public class LableController {

    @Autowired
    private LableService lableService;

    //查询所有
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",lableService.findAll());
    }

    //根据id查询
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",lableService.findById(id));
    }
    //推荐标签列表
    @RequestMapping(value = "/toplist",method = RequestMethod.GET)
    public Result findByRecommend(){
        return new Result(true,StatusCode.OK,"查询成功",lableService.findByRecommend());
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Result findByState(){
        return new Result(true,StatusCode.OK,"查询成功",lableService.findByState());
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Lable lable){
        lableService.add(lable);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@RequestBody Lable lable,@PathVariable String id){
        lable.setId(id);
        lableService.update(lable);
        return new Result(true,StatusCode.OK,"更新成功");
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        lableService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Lable lable){
        return new Result(true,StatusCode.OK,"查询成功",lableService.findSearch(lable));
    }

    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result findSearchPageSize(@PathVariable int page,@PathVariable int size,@RequestBody Lable lable){
        Page<Lable> searchPageSize = lableService.findSearchPageSize(lable, page, size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<>(searchPageSize.getTotalElements(),
                searchPageSize.getContent()));
    }



}
