package uk.co.twinn.api.webexinteract.response;

import uk.co.twinn.api.webexinteract.response.core.ApiResponseResult;

public class Deleted<T> extends Read<T> {

    public Deleted(ApiResponseResult<T> result){

        super(result);

    }

}
