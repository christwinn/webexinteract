/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.response.core;

public class ErrorData {

    private int status;
    private int resource_id;

    public ErrorData(){}

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the resource_id
     */
    public int getResource_id() {
        return resource_id;
    }

    /**
     * @param resource_id the resource_id to set
     */
    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }
}
