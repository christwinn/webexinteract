package uk.co.twinn.api.webexinteract.response;

import uk.co.twinn.api.webexinteract.response.core.ApiResponseResult;

public class Duplicated<T> extends Created<T>{

    public Duplicated(ApiResponseResult<T> result){

        super(result);

    }


}
