package uk.co.twinn.api.webexinteract.response.core;

public class ErrorMessage {
    private String code;
    private String message;
    private ErrorData data;

    public ErrorMessage(){}

    public ErrorMessage(String message){
        this.message = message;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    /*@Nonnull*/
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the data
     */
    public ErrorData getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(ErrorData data) {
        this.data = data;
    }

}
