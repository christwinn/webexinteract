/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.response;

import uk.co.twinn.api.webexinteract.response.core.ApiResponseResult;

public class Duplicated<T> extends Created<T>{

    public Duplicated(ApiResponseResult<T> result){

        super(result);

    }


}
