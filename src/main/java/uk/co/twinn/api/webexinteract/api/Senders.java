/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.api;

import uk.co.twinn.api.webexinteract.builders.SenderBuilder;

public class Senders {

    protected Senders(){}

    public static SenderBuilder.Reader read(String senderId){

        return new SenderBuilder.Reader(senderId);

    }

    public static SenderBuilder.ListAll<?> list(){

        return new SenderBuilder.ListAll<>();

    }

}
