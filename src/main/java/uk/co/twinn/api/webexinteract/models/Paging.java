package uk.co.twinn.api.webexinteract.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Paging {

    private int currentPage;
    private int totalItems;
    private int totalPages;

    public Paging(){}

    @JsonProperty("current_page")
    public int getCurrentPage() {
        return currentPage;
    }

    @JsonProperty("current_page")
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @JsonProperty("total_items")
    public int getTotalItems() {
        return totalItems;
    }

    @JsonProperty("total_items")
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    @JsonProperty("total_pages")
    public int getTotalPages() {
        return totalPages;
    }

    @JsonProperty("total_pages")
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

}
