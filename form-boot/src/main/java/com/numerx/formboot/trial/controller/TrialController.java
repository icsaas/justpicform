package com.numerx.formboot.trial.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.numerx.formboot.trial.entity.Trial;
import com.numerx.formboot.trial.mapper.TrialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author matrixorz
 * @data 2019-08-14 00:02
 */
@Controller
public class TrialController {
    @Autowired
    TrialMapper trialMapper;

    /*查询所有结果*/
    @RequestMapping("/listTrial")
    public String listTrial(Model model, @RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
        PageHelper.startPage(start,size,"id desc"); //根据start和size设置分页，并设置id倒序排序
        List<Trial> tests = trialMapper.returnResult();
        PageInfo<Trial> TrialPageInfo = new PageInfo<>(tests); //根据返回的集合，创建PageInfo对象
        model.addAttribute("page",TrialPageInfo);
        return "listTrial";
    }

    /*插入数据*/
    @RequestMapping("addTrial")
    public String AddTrial(Trial Trial){
        trialMapper.insert(Trial.getName(),Trial.getHp(),Trial.getDamage());
        return "redirect:listTrial";
    }

    /*删除数据*/
    @RequestMapping("deleteTrial")
    public String DeleteTrial(Trial Trial){
        trialMapper.delete(Trial.getId());
        return "redirect:listTrial";
    }

    /*更新数据,根据id更改名字*/
    @RequestMapping("updateTrial")
    public String UpdateTrial(Trial Trial){
        trialMapper.update(Trial.getName(),Trial.getHp(),Trial.getDamage(),Trial.getId());
        return "redirect:listTrial";
    }

    /*编辑指定的数据*/
    @RequestMapping("editTrial")
    public String EditTrial(int id,Model model){
        Trial Trial = trialMapper.returnById(id);
        model.addAttribute("Trial",Trial);
        return "editTrial";
    }
}
