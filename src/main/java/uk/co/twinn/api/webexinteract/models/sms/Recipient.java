/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.models.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Recipient {

    private String correlationId;
    private String countryCode;
    private List<String> phone;
    private HashMap<String, String> mergeFields;

    public Recipient(){}

    public Recipient correlationId(String correlationId){
        this.correlationId = correlationId;
        return this;
    }
    public Recipient countryCode(String countryCode){
        this.countryCode = countryCode;
        return this;
    }
    /*Each call to phone adds a new number that the message wil be sent to*/
    public Recipient phone(String e164phoneNumber){
        if (this.phone == null){
            this.phone = new ArrayList<>();
        }
        this.phone.add(cleanNumber(e164phoneNumber));
        return this;
    }

    private String cleanNumber(String number){
        //allow + 0123456789
        return number.replaceAll("[^\\d+]", "");
    }
    public Recipient mergeFields(HashMap<String, String> mergeFields) {
        this.mergeFields = mergeFields;
        return this;
    }

    @JsonProperty("correlation_id")
    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    @JsonProperty("merge_fields")
    public HashMap<String, String> getMergeFields() {
        return mergeFields;
    }

    public void setMergeFields(HashMap<String, String> mergeFields) {
        this.mergeFields = mergeFields;
    }
}
