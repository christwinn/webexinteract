/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.api;

import uk.co.twinn.api.webexinteract.builders.AccountBuilder;

public class Accounts {
    protected Accounts() {}

    public static AccountBuilder.Reader read(){

        return new AccountBuilder.Reader();

    }

}
