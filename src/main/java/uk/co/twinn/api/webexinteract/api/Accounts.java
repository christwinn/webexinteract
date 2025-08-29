package uk.co.twinn.api.webexinteract.api;

import uk.co.twinn.api.webexinteract.builders.AccountBuilder;
import uk.co.twinn.api.webexinteract.builders.SmsBuilder;
import uk.co.twinn.api.webexinteract.models.sms.Recipient;

import java.util.List;

public class Accounts {

    protected Accounts() {}

    public static AccountBuilder.Reader read(){

        return new AccountBuilder.Reader();

    }

}
