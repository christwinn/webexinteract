package uk.co.twinn.api.webexinteract.models.senders;

public class Sender {

    private String id;
    private String name;
    private String status;

    private Sender(){}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
