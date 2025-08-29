package uk.co.twinn;

import uk.co.twinn.api.webexinteract.api.Accounts;
import uk.co.twinn.api.webexinteract.api.Senders;
import uk.co.twinn.api.webexinteract.core.JacksonObjectMapper;
import uk.co.twinn.api.webexinteract.models.account.Account;
import uk.co.twinn.api.webexinteract.models.senders.Sender;
import uk.co.twinn.api.webexinteract.response.Listed;
import uk.co.twinn.api.webexinteract.response.Read;

public class WebExInteract {

    public static void main(String[] args) {

        /* As of 2025-08-29 This is all that the upstream API allows us to do...*/
        Read<Account> read = Accounts.read().getResponse();

        if (read.isSuccess()){

            System.out.println(
                new JacksonObjectMapper().toJson(read.getResult())
            );

        }else{

            System.out.println(read.getError().getMessage());

        }

        Listed<Sender> listed = Senders.listing().getResponse();

        if (listed.isSuccess()){

            System.out.println(
                new JacksonObjectMapper().toJson(listed.getResult())
            );

            listed.getResult().getPaging();

            for (Sender sender : listed.getResult().getItems()){
                System.out.println(
                    new JacksonObjectMapper().toJson(sender)
                );
            }

        }else{

            System.out.println(listed.getError().getMessage());

        }

        /*Created<Sms> created =
            Smses
                .create("Hello World", "", "Mackays")
                .setSkipOptOutCheck(true)
                .getResponse();

        if (created.isSuccess()){

            System.out.println(
                    new JacksonObjectMapper().toJson(created.getResult())
            );

        }else{

            System.out.println(created.getError().getMessage());

        }*/

    }

}
