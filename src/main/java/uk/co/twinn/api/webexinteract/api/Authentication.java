/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.api;

import uk.co.twinn.api.webexinteract.builders.AuthenticationBuilder;

public class Authentication {

    protected Authentication(){}

    public static AuthenticationBuilder.Https Https(){

        return new AuthenticationBuilder.Https();

    }

}
