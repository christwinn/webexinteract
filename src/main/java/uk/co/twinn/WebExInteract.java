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
import uk.co.twinn.api.webexinteract.models.sms.SmsTransaction;
import uk.co.twinn.api.webexinteract.response.Created;
import uk.co.twinn.api.webexinteract.response.Deleted;
import uk.co.twinn.api.webexinteract.response.Listed;
import uk.co.twinn.api.webexinteract.response.Read;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class WebExInteract {

    private static final String MY_MESSAGE = "Hello World";
    private static final String MY_SENDERNAME = "Groot";

    //enter number here in e164 (international dialling code) format or set country code and normal number
    //this is a junk number too many numbers, non numbers or + are cleansed
    private static final String PHONE_NUMBER = "+44A7005A1234561";

    /** SCRATCH PAD **/
    public static void main(String[] args) {

        /* As of 2025-08-29 This is all that the upstream API allows us to do...*/

        accounts();

        sendersList();

        //senderDelete();

        sendSms(PHONE_NUMBER);

    }
    private static void accounts() {

        Read<Account> read = Accounts.read().getResponse();

        if (read.isSuccess()) {

            System.out.println(
                new JacksonObjectMapper().toJson(read.getResult())
            );

        } else {

            System.out.println(
                new JacksonObjectMapper().toJson(read.getError())
            );

        }

    }

    private static void sendersList() {

        Listed<Sender> listed = Senders.list().getResponse();

        if (listed.isSuccess()) {

            System.out.println("SUCCESS");

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

            System.out.println("FAILURE");
            System.out.println(
                new JacksonObjectMapper().toJson(listed.getError())
            );

        }
    }

    private static void senderDelete() {

        Deleted<Sender> delete = Senders.delete("ssd_3XXXXXXXXXXXXXXXXXXXXX").getResponse();

        if (delete.isSuccess()){
            System.out.println("Success");
        }else{
            System.out.println("Error");
            System.out.println(
                new JacksonObjectMapper().toJson(delete.getError())
            );
        }

    }

    private static void sendSms(String phoneNumber){

        //you can add a list of recipients
        //you can also add a list of phoneNumbers under the Recipient
        Created<Sms> created =
            SendSms
                .send(MY_MESSAGE, MY_SENDERNAME)
                .addTo(new Recipient().countryCode("GB").phone(phoneNumber)) //set GB as country use 'normal' 07000123456 format
                //.addTo(new Recipient().phone(e164phoneNumber)) //use the +4470000123456 format
                //.setScheduleAt(ZonedDateTime.now().minusDays(2)) //cause in the past error
                //.setScheduleAt(ZonedDateTime.now().plusYears(2)) //cause too far in the future error
                .setSkipOptOutCheck(true)
                .getResponse();

        if (created.isSuccess()){
            //weirdly if we enter an incorrect phone number we receive response 200
            //surely this SHOULD be 400 invalid phone number?!
            //
            System.out.println(
                new JacksonObjectMapper().toJson(created.getResult())
            );

            for (SmsTransaction success : created.getResult().getMessages()){
                System.out.println("Success to " + success.getTo());
            }
            for (SmsTransaction success : created.getResult().getErrors()){
                System.out.println("Failure to " + success.getTo());
            }

            if (created.getResult().getErrors().isEmpty()){

                System.out.println("Success Success!");

            }else{

                System.out.println("Success with Error(s)!");

            }

        }else{

            System.out.println("FAILURE");
            System.out.println(
                new JacksonObjectMapper().toJson(created.getError())
            );

        }

    }

}
