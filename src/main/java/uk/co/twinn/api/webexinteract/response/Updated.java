package uk.co.twinn.api.webexinteract.response;

import uk.co.twinn.api.webexinteract.response.core.ApiResponseResult;

public class Updated<T> extends Created<T> {

    public Updated(ApiResponseResult<T> result){

        super(result);

    }

}
