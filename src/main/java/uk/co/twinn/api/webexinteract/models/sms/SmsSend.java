/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.models.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;

public class SmsSend {

    private String messageBody;
    private String templateId;
    private String from;
    private List<Recipient> to;

    private ZonedDateTime scheduleAt;
    private ZonedDateTime validUntil;

    private Boolean skipOptOutCheck;

    private HashMap<String, String> globalMergeFields;

    public SmsSend(){}

    @JsonProperty("message_body")
    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    @JsonProperty("template_id")
    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<Recipient> getTo() {
        return to;
    }

    public void setTo(List<Recipient> to) {
        this.to = to;
    }

    @JsonProperty("schedule_at")
    public ZonedDateTime getScheduleAt() {
        return scheduleAt;
    }

    public void setScheduleAt(ZonedDateTime scheduleAt) {
        this.scheduleAt = scheduleAt;
    }

    @JsonProperty("valid_until")
    public ZonedDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(ZonedDateTime validUntil) {
        this.validUntil = validUntil;
    }

    @JsonProperty("skip_optout_check")
    public Boolean getSkipOptOutCheck() {
        return skipOptOutCheck;
    }

    public void setSkipOptOutCheck(Boolean skipOptOutCheck) {
        this.skipOptOutCheck = skipOptOutCheck;
    }

    @JsonProperty("global_merge_fields")
    public HashMap<String, String> getGlobalMergeFields() {
        return globalMergeFields;
    }

    public void setGlobalMergeFields(HashMap<String, String> globalMergeFields) {
        this.globalMergeFields = globalMergeFields;
    }

}