/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import uk.co.twinn.api.webexinteract.models.Listing;
import uk.co.twinn.api.webexinteract.response.core.ApiResponse;
import uk.co.twinn.api.webexinteract.response.core.ApiResponseResult;
import uk.co.twinn.api.webexinteract.response.error.ErrorResponse;

public class Listed<T> extends ApiResponse<Listing<T>> {

    protected Listing<T> listed;

    public Listed(ApiResponseResult<Listing<T>> result){

        super(result);

        if (result.getSuccess()){
            switch (result.getStatusCode()){
                case 200: case 201:
                    success = true;
                    this.listed = result.getData();
                    break;
                default:
                    success = false;
                    if (result.getErrorResponse() != null) {
                        error = result.getErrorResponse();
                    }else {
                        error = new ErrorResponse("Invalid response code:" + result.getStatusCode());
                    }
                    break;
            }
        }

    }

    public boolean isSuccess() {
        return super.success && listed != null;
    }

    public Listing<T> getResult(){
        return listed;
    }

    public String toJson(){

        try {
            // covert Java object to JSON strings
            return getObjectMapper().writeValueAsString(this);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


}
