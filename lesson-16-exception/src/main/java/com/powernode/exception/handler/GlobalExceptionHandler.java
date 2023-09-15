package com.powernode.exception.handler;


import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 控制器增强 Advice -> 增强
@ControllerAdvice
public class GlobalExceptionHandler {

/*    @ExceptionHandler({ArithmeticException.class})
    public String handlerArithmeticException(ArithmeticException e, Model model) {
        String error = e.getMessage();
        model.addAttribute("error", error);
        return "exp";
    }*/

    @ExceptionHandler({ArithmeticException.class})
    @ResponseBody
    public Map<String, String> handlerReturnDataException(ArithmeticException e) {
        Map<String, String> error = new HashMap<>();
        error.put("msg", e.getMessage());
        error.put("tips", "被除数不能为0");
        return error;
    }

    // JSR303 的验证参数异常
    @ExceptionHandler({BindException.class})
    @ResponseBody
    public Map<String, Object> handlerJSR303Exception(BindException e) {
        System.out.println("========JSR303========");
        Map<String, Object> map = new HashMap<>();
        BindingResult result = e.getBindingResult();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (int i = 0; i < fieldErrors.size(); i++) {
                FieldError field = fieldErrors.get(i);
                map.put(i + "-" + field.getField(), field.getDefaultMessage());
            }
        }
        return map;
    }
}
