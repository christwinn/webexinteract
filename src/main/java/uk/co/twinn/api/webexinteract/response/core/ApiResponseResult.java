/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.response.core;

import uk.co.twinn.api.webexinteract.response.error.Error;
import uk.co.twinn.api.webexinteract.response.error.ErrorResponse;

import java.util.Collections;

public class ApiResponseResult<T>{

    /* Intermediary result parsed onto object or list dependant upon higher up the chain */

    private boolean success;
    private int     status;
    private ErrorResponse errorResponse;
    private T data;

    public ApiResponseResult(boolean success, int status){
        this.success = success;
        this.status = status;
    }

    public ApiResponseResult(boolean success, int status, String message){
        this.success = success;
        errorResponse = new ErrorResponse(message);
        this.status = status;
    }

    public ApiResponseResult(boolean success, int status, ErrorResponse errorResponse){
        this.success = success;
        this.errorResponse = errorResponse;
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

    public ErrorResponse getErrorResponse(){
        return errorResponse;
    }

    public T getData() {
        return data;
    }

}
