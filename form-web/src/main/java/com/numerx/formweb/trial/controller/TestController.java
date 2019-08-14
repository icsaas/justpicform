package com.numerx.formweb.trial.controller;

import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import com.numerx.formweb.trial.manager.TestManager;
import com.numerx.formweb.trial.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author matrixorz
 * @data 2019-08-11 23:17
 */
@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private TestManager testManager;

    @Autowired
    private BaseMysqlCRUDManager baseMysqlCRUDManager;

   @RequestMapping("/index")
    public String index(){

       Test test = new Test();
       test.setName("sss333");
//       test.setNumber(9L);
//       test.setDescription("adfsdfe");
//
//       baseMysqlCRUDManager.delete(test);
       baseMysqlCRUDManager.save(test);
       int count = testManager.findTestCount();
       return "index";
   }
}
