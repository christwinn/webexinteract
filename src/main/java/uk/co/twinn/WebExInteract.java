/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn;

import uk.co.twinn.api.webexinteract.api.Accounts;
import uk.co.twinn.api.webexinteract.api.SendSms;
import uk.co.twinn.api.webexinteract.api.Senders;
import uk.co.twinn.api.webexinteract.core.JacksonObjectMapper;
import uk.co.twinn.api.webexinteract.models.account.Account;
import uk.co.twinn.api.webexinteract.models.senders.Sender;
import uk.co.twinn.api.webexinteract.models.sms.Recipient;
import uk.co.twinn.api.webexinteract.models.sms.Sms;
import uk.co.twinn.api.webexinteract.response.Created;
import uk.co.twinn.api.webexinteract.response.Listed;
import uk.co.twinn.api.webexinteract.response.Read;

public class WebExInteract {

    private static final String MY_MESSAGE = "Hello World";
    private static final String MY_SENDERNAME = "Groot";

    //enter number here in e164 (international dialling code) format
    private static final String PHONE_NUMBER = "+447005777222"; //this is a junk number

    public static void main(String[] args) {

        /* As of 2025-08-29 This is all that the upstream API allows us to do...*/

        accounts();

        senders();

        sendSms(PHONE_NUMBER);

    }
    private static void accounts() {

        Read<Account> read = Accounts.read().getResponse();

        if (read.isSuccess()) {

            System.out.println(
                    new JacksonObjectMapper().toJson(read.getResult())
            );

        } else {

            System.out.println(read.getError().getMessage());

        }

    }

    private static void senders() {

        Listed<Sender> listed = Senders.list().getResponse();

        if (listed.isSuccess()) {

            System.out.println(
                new JacksonObjectMapper().toJson(listed.getResult())
            );

            listed.getResult().getPaging();

            for (Sender sender : listed.getResult().getItems()) {
                System.out.println(
                    new JacksonObjectMapper().toJson(sender)
                );

                Read<Sender> read = Senders.read(sender.getId()).getResponse();
                if (read.isSuccess()) {
                    System.out.println(
                        "READ IT BACK" + new JacksonObjectMapper().toJson(read.getResult())
                    );
                }

            }

            //There is an API option to delete. but NOT create.
            //We do not have a sandbox so for now I have not implemented delete

        } else {

            System.out.println(listed.getError().getMessage());

        }

    }

    private static void sendSms(String phoneNumber){

        //you can add a list of recipients
        //you can also add a list of phoneNumbers under the Recipient
        Created<Sms> created =
            SendSms
                .send(MY_MESSAGE, MY_SENDERNAME)
                .addTo(new Recipient().phone(phoneNumber))
                .setSkipOptOutCheck(true)
                .getResponse();

        if (created.isSuccess()){
            //weirdly if we enter an incorrect phone number we receive response 200
            //surely this SHOULD be 400 invalid phone number?!
            //
            System.out.println(
                new JacksonObjectMapper().toJson(created.getResult())
            );

        }else{

            System.out.println(created.getError().getMessage());

        }

    }

}
