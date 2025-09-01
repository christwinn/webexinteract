/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.response.error;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

public class ErrorResponse {

    private String traceId;
    private List<Error> errors;

    public ErrorResponse(){}

    public ErrorResponse(String message){
        errors = Collections.singletonList(new Error(message));
    }

    public String getTraceId() {
        //high chance it is null but let us not return null
        return traceId != null ? traceId : "";
    }

    @JsonProperty("trace_id")
    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
