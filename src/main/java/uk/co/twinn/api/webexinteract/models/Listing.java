package uk.co.twinn.api.webexinteract.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.co.twinn.api.webexinteract.models.senders.Sender;

import java.util.List;

public class Listing<T> {

    private Paging paging;
    private List<T> items;

    public Listing(){}

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<T> getItems() {
        return items;
    }
    @JsonProperty("items") //!??!
    public void setItems(List<T> senders) {
        this.items = items;
    }

}
