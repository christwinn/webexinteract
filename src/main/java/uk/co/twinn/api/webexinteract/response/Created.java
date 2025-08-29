package uk.co.twinn.api.webexinteract.response;

import uk.co.twinn.api.webexinteract.response.core.ApiResponseResult;
import uk.co.twinn.api.webexinteract.response.core.CrudResponse;

public class Created<T> extends CrudResponse<T> {

    public Created(ApiResponseResult<T>result){

        super(result);

    }

}
