/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.response.core;

public class Msg extends ErrorMessage {

    public Msg(){
        super();
    }

    public Msg(String message){
        super( message );
    }

    public void setMessage(String message){

        super.setMessage(message);

    }

}
