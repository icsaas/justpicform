package com.numerx.formweb.component;

import com.numerx.formapi.core.advice.ExceptionAdvice;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * Created by
 */
@ControllerAdvice
@ResponseBody
public class RestExceptionAdvice extends ExceptionAdvice {

}
