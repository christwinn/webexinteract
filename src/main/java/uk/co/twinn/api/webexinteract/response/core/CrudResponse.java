/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.response.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import uk.co.twinn.api.webexinteract.response.error.ErrorResponse;

public class CrudResponse<T> extends ApiResponse<T>{

    protected T object = null;

    public CrudResponse(ApiResponseResult<T> result){

        super(result);

        if (result.getSuccess()){
            switch (result.getStatusCode()){
                case 200: case 201: case 204:
                    success = true;
                    this.object = result.getData();
                    break;
                default:
                    success = false;
                    if (result.getErrorResponse() != null){
                        this.error = result.getErrorResponse();
                    }else {
                        error = new ErrorResponse("Invalid response code:" + result.getStatusCode());
                    }
                    break;
            }
        }

    }

    @Override
    public boolean isSuccess() {
        return super.success; // && object != null;
    }

    public String toJson(){

        try {
            // covert Java object to JSON strings
            return getObjectMapper().writeValueAsString(this);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public T getResult(){
        /*T is set by the call*/
        return object;
    }

    public boolean hasResult(){
        return object != null;
    }

}
