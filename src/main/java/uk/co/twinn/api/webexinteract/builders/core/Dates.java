/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.builders.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dates {

    public static String localDateToIso8601(LocalDate date){

        if (date != null){

            return date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        }else{

            return "";

        }

    }

}
