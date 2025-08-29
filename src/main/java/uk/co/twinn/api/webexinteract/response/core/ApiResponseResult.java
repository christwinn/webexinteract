/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.response.core;

public class ApiResponseResult<T>{

    private boolean success;
    private int     status;
    private String  message = "";

    private T data;

    public ApiResponseResult(boolean success, int status, String message){
        this.success = success;
        this.message = message;
        this.status = status;
    }

    public ApiResponseResult(boolean success, int status, T data){
        this.success = success;
        this.data = data;
        this.status = status;
    }

    public ApiResponseResult(){

    }

    public boolean getSuccess() {
        return success;
    }

    public int getStatusCode() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
