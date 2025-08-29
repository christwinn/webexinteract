package uk.co.twinn.api.webexinteract.api;

import uk.co.twinn.api.webexinteract.builders.SmsBuilder;
import uk.co.twinn.api.webexinteract.models.sms.Recipient;

import java.util.List;

public class SendSms {

    public static SmsBuilder.Creator<?> create(String messageBody, String templateId, String from, List<Recipient> to){

        return new SmsBuilder.Creator<>(messageBody, templateId, from, to);

    }

    public static SmsBuilder.Creator<?> send(String messageBody, String templateId, String from){

        return new SmsBuilder.Creator<>(messageBody, templateId, from);

    }

    public static SmsBuilder.Creator<?> send(){

        return new SmsBuilder.Creator<>();

    }

}
