package com.crm.handler;

import com.crm.exception.CrmException;
import com.crm.utils.ResponseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(CrmException.class)
    public ResponseEntity handeler(CrmException e){
        return ResponseEntity.status(e.getExceptionEnums().getCode()).body(new ResponseResult(e.getExceptionEnums()));
    }

}
