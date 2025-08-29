/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.builders;

import com.fasterxml.jackson.core.type.TypeReference;
import uk.co.twinn.api.webexinteract.models.Listing;
import uk.co.twinn.api.webexinteract.response.Listed;
import uk.co.twinn.api.webexinteract.rest.Rest;

import java.util.List;

public class CoreList<S, T> {

    @SuppressWarnings("unchecked")
    T self() {
        return (T) this;
    }

    Listed<S> getResponse(String endPoint, String parameters, TypeReference<?> type){

        return new Listed<>(
            new Rest<Listing<S>>().listAll(
                endPoint,
                parameters,
                type
            )
        );

    }

}
