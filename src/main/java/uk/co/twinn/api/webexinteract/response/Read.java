package uk.co.twinn.api.webexinteract.response;

import uk.co.twinn.api.webexinteract.response.core.ApiResponseResult;
import uk.co.twinn.api.webexinteract.response.core.CrudResponse;

public class Read<T> extends CrudResponse<T> {

    public Read(ApiResponseResult<T> result){

        super(result);

    }


}
