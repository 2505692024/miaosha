package com.miaosha.controller;

import com.miaosha.error.BusinessException;
import com.miaosha.error.EnuBusinessError;
import com.miaosha.response.commonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yaoheng
 * @date 2020/10/11 23:34
 */
public class BaseController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleException(HttpServletRequest request, Exception ex) {
        Map<String, Object> responseData = new HashMap<>();
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            responseData.put("errorCode", businessException.getErrorCode());
            responseData.put("errMsg", businessException.getErrorMsg());

        } else {
            responseData.put("errorCode", EnuBusinessError.UNKNOWN_ERROR.getErrorCode());
            responseData.put("errMsg", EnuBusinessError.UNKNOWN_ERROR.getErrorMsg());
        }
        return commonReturnType.create(responseData, "fail");
    }
}
