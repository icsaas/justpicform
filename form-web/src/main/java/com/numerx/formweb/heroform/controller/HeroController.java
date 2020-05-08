package com.numerx.formweb.heroform.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.numerx.formapi.core.Rest;
import com.numerx.formapi.core.anno.Log;
import com.numerx.formapi.core.controller.AppController;
import com.numerx.formweb.heroform.entity.Hero;
import com.numerx.formweb.heroform.mapper.HeroMapper;
import com.numerx.formweb.heroform.service.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

/**
 * <p>
 *  controller class
 * </p>
 *
 * @author matrixorz
 * @since 2019-08-14
 */
@RestController
@RequestMapping("/heroform/hero")
public class HeroController extends  AppController<Hero, IHeroService> {
    @Autowired
    private HeroMapper heroMapper;
    @GetMapping("/findJoinPage")
    public Rest findJoinPage(@RequestParam(required = true,defaultValue="1")
                                     Integer page, @RequestParam (defaultValue="10")Integer size){
        Page<Map<Object, Object>> pageData = getS().selectHeroPage(new Page<Map<Object,Object>>(page,size));
        return Rest.okData(pageData);

    }

    /**
     * 记录日志测试
     * @see @Log 记录日志只在方法执行成功返回后执行，通过 com.numerx.formapi.core.log.LogAdvice AOP实现
     * @return rest
     */
    @GetMapping("/testLog")
    @Log(title="测试日志",value="这是日志内容,哈哈")
    public Rest testLog(){
        return Rest.ok();
    }

}
