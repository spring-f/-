package com.tensquare.qa.controller;

import com.tensquare.entity.PageResult;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import com.tensquare.qa.pojo.Problem;
import com.tensquare.qa.service.ProblemService;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/problem")
@CrossOrigin
public class ProblemController {


    @Autowired
    private ProblemService problemService;

    @RequestMapping(method = RequestMethod.GET)
    public Result find(){
        return new Result(true, StatusCode.OK,"查询成功",problemService.find());
    }

    @RequestMapping(value = "/{problemId}",method = RequestMethod.GET)
    public Result findById(@PathVariable String problemId){
        return new Result(true, StatusCode.OK,"查询成功",problemService.findById(problemId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Problem problem){
        problemService.add(problem);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    @RequestMapping(value = "/{problemId}",method = RequestMethod.PUT)
    public Result update(@PathVariable String problemId,@RequestBody Problem problem){
        problem.setId(problemId);
        problemService.update(problem);
        return new Result(true, StatusCode.OK,"更新成功");
    }

    @RequestMapping(value = "/{problemId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String problemId){
        problemService.delete(problemId);
        return new Result(true, StatusCode.OK,"删除成功");
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result search(@RequestBody Problem problem){
        return new Result(true, StatusCode.OK,"查询成功",problemService.search(problem));
    }
    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result searchPageSize(@RequestBody Problem problem,@PathVariable int page,@PathVariable int size){
        Page<Problem> pageSize=problemService.searchPageSize(problem,page,size);
        return new Result(true, StatusCode.OK,"查询成功",new PageResult<Problem>(pageSize.getTotalElements(),pageSize.getContent()));
    }

    @RequestMapping(value = "/newlist/{labelId}/{page}/{size}",method = RequestMethod.POST)
    public Result searchNewListLabelPageSize(@PathVariable int labelId,@PathVariable int page,
                                             @PathVariable int size){
        Page<Problem> pageSize=problemService.searchNewListLabelPageSize(labelId,page,size);
        return new Result(true, StatusCode.OK,"查询成功",new PageResult<Problem>(pageSize.getTotalElements(),pageSize.getContent()));
    }

    @RequestMapping(value = "/hotlist/{labelId}/{page}/{size}",method = RequestMethod.POST)
    public Result searchHotListLabelPageSize(@PathVariable int labelId,@PathVariable int page,
                                             @PathVariable int size){
        Page<Problem> pageSize=problemService.searchHotListLabelPageSize(labelId,page,size);
        return new Result(true, StatusCode.OK,"查询成功",new PageResult<Problem>(pageSize.getTotalElements(),pageSize.getContent()));
    }
}
