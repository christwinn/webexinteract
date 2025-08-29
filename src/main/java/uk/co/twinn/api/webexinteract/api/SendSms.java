package uk.co.twinn.api.webexinteract.api;

import uk.co.twinn.api.webexinteract.builders.SmsBuilder;
import uk.co.twinn.api.webexinteract.models.sms.Recipient;

import java.util.List;

public class SendSms {

    protected SendSms(){}

    public static SmsBuilder.Creator<?> send(String messageBody, String from, List<Recipient> to){

        return new SmsBuilder.Creator<>(messageBody, from, to);

    }

    public static SmsBuilder.Creator<?> send(String messageBody, String from){

        return new SmsBuilder.Creator<>(messageBody, from);

    }

    public static SmsBuilder.Creator<?> send(){

        return new SmsBuilder.Creator<>();

    }

}
