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
