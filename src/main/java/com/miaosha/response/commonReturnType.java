package com.miaosha.response;

/**
 * @author yaoheng
 * @date 2020/10/11 21:58
 */
//定义返回结果类型
public class commonReturnType {
    private String status;
    //如果status是success data返回前端所需的json数据
    //如果返回fail 则data返回公用的状态码
    private Object data;

    public static commonReturnType create(Object result){
       return commonReturnType.create(result,"success");
    }
    public static commonReturnType create(Object result,String status){
        commonReturnType commonReturnType = new commonReturnType();
        commonReturnType.setStatus(status);
        commonReturnType.setData(result);
        return commonReturnType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
