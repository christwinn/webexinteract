package uk.co.twinn.api.webexinteract.response;

import uk.co.twinn.api.webexinteract.response.core.ApiResponseResult;
import uk.co.twinn.api.webexinteract.response.core.CrudResponse;

public class Ran<T> extends CrudResponse<T> {

    public Ran(ApiResponseResult<T> result){

        super(result);

    }


}
