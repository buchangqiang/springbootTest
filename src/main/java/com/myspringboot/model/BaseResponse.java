package com.myspringboot.model;

public class BaseResponse<T> {
    private int code;
    private String message;
    private T data;
    private  static  final  int SUCCESS_CODE=200;
    public  BaseResponse(int code,String message){
        this.setCode(code);
        this.setMessage(message);
    }

    public  BaseResponse(){
        this(SUCCESS_CODE,"");
    }

    public  BaseResponse(T data){
        this(SUCCESS_CODE,"");
        this.setData(data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
