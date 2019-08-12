package com.numerx.formboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.numerx.formboot.entity.Test;
import com.numerx.formboot.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author matrixorz
 * @data 2019-08-12 21:22
 */
@Controller
public class TestController {
    @Autowired
    TestMapper testMapper;

    /*查询所有结果*/
    @RequestMapping("/listTest")
    public String listTest(Model model, @RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
        PageHelper.startPage(start,size,"id desc"); //根据start和size设置分页，并设置id倒序排序
        List<Test> tests = testMapper.returnResult();
        PageInfo<Test> TestPageInfo = new PageInfo<>(tests); //根据返回的集合，创建PageInfo对象
        model.addAttribute("page",TestPageInfo);
        return "listTest";
    }

    /*插入数据*/
    @RequestMapping("addTest")
    public String AddTest(Test Test){
        testMapper.insert(Test.getName(),Test.getHp(),Test.getDamage());
        return "redirect:listTest";
    }

    /*删除数据*/
    @RequestMapping("deleteTest")
    public String DeleteTest(Test Test){
        testMapper.delete(Test.getId());
        return "redirect:listTest";
    }

    /*更新数据,根据id更改名字*/
    @RequestMapping("updateTest")
    public String UpdateTest(Test Test){
        testMapper.update(Test.getName(),Test.getHp(),Test.getDamage(),Test.getId());
        return "redirect:listTest";
    }

    /*编辑指定的数据*/
    @RequestMapping("editTest")
    public String EditTest(int id,Model model){
        Test Test = testMapper.returnById(id);
        model.addAttribute("Test",Test);
        return "editTest";
    }
}
