/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.builders;

import com.fasterxml.jackson.core.type.TypeReference;
import uk.co.twinn.api.webexinteract.response.Created;
import uk.co.twinn.api.webexinteract.rest.Rest;

public class CoreCreator<S, T> {

    @SuppressWarnings("unchecked")
    T self() {
        return (T) this;
    }

    Created<S> getCreate(String endPoint, String parameters, TypeReference<?> type){

        return new Created<>(
            new Rest<S>().create(
                endPoint,
                parameters,
                type
            )
        );

    }

}
