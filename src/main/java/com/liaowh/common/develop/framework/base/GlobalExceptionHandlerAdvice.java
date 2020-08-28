package com.liaowh.common.develop.framework.base;

import com.cmit.staff.job.tag.base.result.Result;
import com.cmit.staff.job.tag.base.result.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Result handleApplicationException(ApplicationException e) {

        String errorMsg = "ApplicationException";
        if (e!=null){
            errorMsg = e.getMessage();
            log.error(e.toString());
        }
        return ResultGenerator.genFailResult(errorMsg);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Result handleException(Exception e) {

        String errorMsg = "Exception";
        if (e!=null){
            errorMsg = e.getMessage();
            log.error(e.toString());
        }
        return ResultGenerator.genFailResult(errorMsg);
    }
}