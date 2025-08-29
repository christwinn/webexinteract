/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.models.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@JsonPropertyOrder({
    "account_uid",
    "account_status",
    "home_region",
    "default_currency",
    "account_balance",
    "created"
})
public class Account {

    private String accountUId;
    private String accountStatus;
    private String homeRegion;
    private String timeZone;
    private String defaultCurrency;
    private BigDecimal accountBalance;
    private LocalDateTime created;

    public Account(){}

    public String getAccountUId() {
        return accountUId;
    }

    @JsonProperty("account_uid")
    public void setAccountUId(String accountUId) {
        this.accountUId = accountUId;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    @JsonProperty("account_status")
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getHomeRegion() {
        return homeRegion;
    }
    @JsonProperty("home_region")
    public void setHomeRegion(String homeRegion) {
        this.homeRegion = homeRegion;
    }

    public String getTimeZone() {
        return timeZone;
    }
    @JsonProperty("time_zone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }
    @JsonProperty("default_currency")
    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }
    @JsonProperty("account_balance")
    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

}
