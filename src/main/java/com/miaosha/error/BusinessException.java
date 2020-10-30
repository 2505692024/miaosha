package com.miaosha.error;

/**
 * @author yaoheng
 * @date 2020/10/11 22:45
 */
//包装器业务异常类实现
public class BusinessException extends Exception implements cmmonRetrunError{
    private cmmonRetrunError cmmonRetrunError;
    //直接接受BusinessException的传参用于构造业务异常
    public BusinessException(cmmonRetrunError cmmonRetrunError){
        super();
        this.cmmonRetrunError=cmmonRetrunError;
    }
    public BusinessException(cmmonRetrunError cmmonRetrunError,String errMsg){
        super();
        this.cmmonRetrunError=cmmonRetrunError;
        this.cmmonRetrunError.setErrMsg(errMsg);
    }
    @Override
    public int getErrorCode() {
        return this.cmmonRetrunError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return this.cmmonRetrunError.getErrorMsg();
    }

    @Override
    public cmmonRetrunError setErrMsg(String errMsg) {
        this.cmmonRetrunError.setErrMsg(errMsg);
        return this;
    }
}
