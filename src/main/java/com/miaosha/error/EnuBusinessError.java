package com.miaosha.error;

/**
 * @author yaoheng
 * @date 2020/10/11 22:31
 */
public enum EnuBusinessError implements cmmonRetrunError {
    //通用的错误类型
    PARAMETER_VALIDATION_ERROR(00001,"参数不合法"),
    UNKNOWN_ERROR(10002,"未知错误"),
    //20000开头为用户信息相关性错误
    USER_NOT_EXIST(20001, "用户不存在");
    private EnuBusinessError(int errCode,String errMsg){
        this.errCode=errCode;
        this.errMsg=errMsg;
    }
    private int errCode;
    private String errMsg;

    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errMsg;
    }

    @Override
    public cmmonRetrunError setErrMsg(String errMsg) {
        this.errMsg=errMsg;
        return this;
    }
}
