/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.api;

import uk.co.twinn.api.webexinteract.builders.SendSmsBuilder;
import uk.co.twinn.api.webexinteract.models.sms.Recipient;

import java.util.List;

public class SendSms {

    protected SendSms(){}

    public static SendSmsBuilder.Creator<?> send(String messageBody, String from, List<Recipient> to){

        return new SendSmsBuilder.Creator<>(messageBody, from, to);

    }

    public static SendSmsBuilder.Creator<?> send(String messageBody, String from){

        return new SendSmsBuilder.Creator<>(messageBody, from);

    }

    public static SendSmsBuilder.Creator<?> send(){

        return new SendSmsBuilder.Creator<>();

    }

}
