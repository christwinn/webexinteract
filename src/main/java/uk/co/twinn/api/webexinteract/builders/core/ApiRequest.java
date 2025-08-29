/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.builders.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import uk.co.twinn.api.webexinteract.core.JacksonObjectMapper;

public class ApiRequest {

    private final JacksonObjectMapper json = new JacksonObjectMapper();
    public ApiRequest(){}

    protected ObjectMapper getObjectMapper(){
        return json.getObjectMapper();
    }

}
