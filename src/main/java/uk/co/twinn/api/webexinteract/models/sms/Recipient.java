package uk.co.twinn.api.webexinteract.models.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

public class Recipient {

    private String correlationId;
    private String countryCode;
    private List<String> phone;
    private HashMap<String, String> mergeFields;

    public Recipient(){}

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
