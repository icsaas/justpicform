package com.numerx.formweb.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author matrixorz
 * @data 2019-08-13 16:50
 */
@Controller
@RequestMapping("/")
public abstract class BaseController{

    @GetMapping
   public String index(){
       return "index";
   }





}
