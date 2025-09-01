/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.builders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import uk.co.twinn.api.webexinteract.builders.core.ApiRequest;
import uk.co.twinn.api.webexinteract.models.sms.Recipient;
import uk.co.twinn.api.webexinteract.models.sms.SmsSend;
import uk.co.twinn.api.webexinteract.models.sms.Sms;
import uk.co.twinn.api.webexinteract.response.Created;
import uk.co.twinn.api.webexinteract.response.core.ApiResponseResult;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static uk.co.twinn.api.webexinteract.defines.EndPoints.SMS;

public class SendSmsBuilder extends ApiRequest {

    protected final SmsSend smsSend = new SmsSend();

    public SendSmsBuilder(){}

    private SendSmsBuilder(Creator<?> creator){

        smsSend.setMessageBody(creator.messageBody);
        smsSend.setTemplateId(creator.templateId);
        smsSend.setFrom(creator.from);
        smsSend.setTo(creator.to);

        smsSend.setScheduleAt(creator.scheduleAt);
        smsSend.setValidUntil(creator.validUntil);

        smsSend.setSkipOptOutCheck(creator.skipOptOutCheck);
        smsSend.setGlobalMergeFields(creator.globalMergeFields);

    }

    public String endPoint(){

        return SMS;

    }

    public String toJson(){

        try {

            // covert Java object to JSON strings
            return getObjectMapper().writeValueAsString(smsSend);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public static class Creator<T extends Creator<T>> extends CoreCreator<Sms, T>{

        private String messageBody;
        private String templateId;
        private String from;
        private List<Recipient> to;

        private ZonedDateTime scheduleAt;
        private ZonedDateTime validUntil;

        private Boolean skipOptOutCheck;

        private HashMap<String, String> globalMergeFields;

        public Creator(){
            this.to = new ArrayList<>();
        }
        public Creator(String messageBody, String from){
            this();
            this.messageBody = messageBody;
            this.templateId = templateId;
            this.from = from;
        }
        public Creator(String messageBody, String from, List<Recipient> to){
            this(messageBody, from);
            this.to.addAll(to);
        }

        public T setMessageBody(String messageBody){
            this.messageBody = messageBody;
            return self();
        }
        public T setTemplateId(String templateId){
            this.templateId = templateId;
            return self();
        }
        public T setFrom(String from){
            this.from = from;
            return self();
        }
        public T setTo(List<Recipient> recipients){
            this.to.addAll(recipients);
            return self();
        }

        public T addTo(Recipient recipient){
            this.to.add(recipient);
            return self();
        }

        public T setScheduleAt(ZonedDateTime scheduleAt){
            this.scheduleAt = scheduleAt;
            return self();
        }

        public T setValidUntil(ZonedDateTime validUntil){
            this.validUntil = validUntil;
            return self();
        }

        public T setSkipOptOutCheck(Boolean skipOptOutCheck){
            this.skipOptOutCheck = skipOptOutCheck;
            return self();
        }

        public T setGlobalMergeField(HashMap<String, String> globalMergeFields){
            this.globalMergeFields = globalMergeFields;
            return self();
        }

        public T addGlobalMergeField(String name, String value){
            if (globalMergeFields == null){
                this.globalMergeFields = new HashMap<>();
            }
            this.globalMergeFields.put(name, value);
            return self();
        }

        protected SendSmsBuilder build(){ return new SendSmsBuilder(this);}

        private Created<Sms> getFailure(String reason){
            return new Created<>(
                new ApiResponseResult<>(
                    false,
                    0,
                    reason
                )
            );
        }

        public Created<Sms> getResponse(){


            if (to == null || to.isEmpty()) {
                return getFailure("Recipients(To) are mandatory");
            } else if (from == null || from.isEmpty()) {
                return getFailure("Sender(from) is mandatory");
            }else if (messageBody == null && templateId == null){
                return getFailure("Template OR MessageBody is required");
            }else if (messageBody != null && templateId != null){
                return getFailure("Note: Only one of messageBody or templateId should be present in the request.");
            }else if (templateId != null && templateId.isEmpty()){
                return getFailure("Template is required");
            }else if (messageBody != null && messageBody.isEmpty()){
                return getFailure("MessageBody is required");
            } else {
                SendSmsBuilder create = build();
                return super.getCreate(create.endPoint(), create.toJson(), new TypeReference<Sms>() {
                });
            }

        }

    }

}
