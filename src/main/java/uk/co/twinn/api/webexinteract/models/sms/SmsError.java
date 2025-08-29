/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.models.sms;

public class SmsError extends SmsTransaction{

    private String message;

    public SmsError(){super();}


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
