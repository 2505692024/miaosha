package com.miaosha.error;

/**
 * @author yaoheng
 * @date 2020/10/11 22:28
 */
public interface cmmonRetrunError {
    public int getErrorCode();
    public String getErrorMsg();
    public cmmonRetrunError setErrMsg(String errMsg);
}
