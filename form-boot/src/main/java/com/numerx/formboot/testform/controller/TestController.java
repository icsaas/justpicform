package com.numerx.formboot.testform.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.numerx.formapi.core.Rest;
import com.numerx.formapi.core.anno.Log;
import com.numerx.formapi.core.controller.AppController;
import com.numerx.formboot.testform.entity.Test;
import com.numerx.formboot.testform.mapper.TestMapper;
import com.numerx.formboot.testform.service.ITestService;
import com.numerx.formboot.testform.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author matrixorz
 * @since 2019-08-13
 */
@RestController
@RequestMapping("/testform/test")
public class TestController extends AppController<Test, ITestService> {
    /**
     * 自定义方法分页多表连接查询博客
     *
     */
    @Autowired
    private TestMapper testMapper;

    @GetMapping("/findJoinPage")
    public Rest findJoinPage(@RequestParam(required = true,defaultValue="1")
                                      Integer page, @RequestParam (defaultValue="10")Integer size){
        QueryWrapper<Test> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .ge("id",20);


         Page<Map<Object, Object>> pageData = getS().selectTestPage(new Page<Map<Object,Object>>(page,size),queryWrapper);
        return Rest.okData(pageData);

    }

    @PostMapping("/insert")
    public Rest Insert(Test test){
        getS().save(test);
        ITestService ts = new TestServiceImpl();
        return Rest.ok();
    }

    @PostMapping("update")
    public Rest Update(@RequestParam(required = true,defaultValue="1")
                                   Integer id){
        getS().removeById(id);

        return Rest.ok();
    }

    /**
     * 记录日志测试
     * @see @Log 记录日志只在方法执行成功返回后执行，通过 com.numerx.formapi.core.log.LogAdvice AOP实现
     * @see 开发者可实现 LogApi接口的log方法完成记录日志具体的业务,此项目中完善service下的LogServiceImpl.java的log方法即可
     * @return rest
     */
    @GetMapping("/testLog")
    @Log(title="测试日志",value="这是日志内容,哈哈")
    public Rest testLog(){
        return Rest.ok();
    }


    public Rest testPage(){

         return Rest.ok();
    }

}
