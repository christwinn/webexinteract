/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.models.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.co.twinn.api.webexinteract.response.core.ErrorMessage;

import java.util.List;

public class Sms {

    private String requestId;
    private List<SmsTransaction> messages;

    private List<ErrorMessage> errors;

    public Sms(){}

    @JsonProperty("request_id")
    public String getRequestId() {
        return requestId;
    }

    @JsonProperty("request_id")
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public List<SmsTransaction> getMessages() {
        return messages;
    }

    public void setMessages(List<SmsTransaction> messages) {
        this.messages = messages;
    }

    public List<ErrorMessage> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorMessage> errors) {
        this.errors = errors;
    }
}
