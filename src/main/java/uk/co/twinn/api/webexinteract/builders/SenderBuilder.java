/*
 * Copyright (c)  2025
 * Author: Chris Twinn
 * Refer to LICENCE file
 */

package uk.co.twinn.api.webexinteract.builders;

import com.fasterxml.jackson.core.type.TypeReference;
import uk.co.twinn.api.webexinteract.models.Listing;
import uk.co.twinn.api.webexinteract.models.senders.Sender;
import uk.co.twinn.api.webexinteract.response.Deleted;
import uk.co.twinn.api.webexinteract.response.Listed;
import uk.co.twinn.api.webexinteract.response.Read;

import java.util.List;

import static uk.co.twinn.api.webexinteract.defines.EndPoints.SENDERS;

public class SenderBuilder {

    public static class Reader extends CoreReader.ReaderCoreStringKey<Sender>{

        public Reader(String senderId){
            super(senderId);
        }

        public Read<Sender> getResponse(){
            return super.getResponse(SENDERS, new TypeReference<Sender>() {});
        }

    }

    public static class Deleter extends CoreDeleter.DeleterCoreStringKey<Sender>{

        public Deleter(String senderId){
            super(senderId);
        }

        public Deleted<Sender> getResponse(){
            return super.getResponse(SENDERS, new TypeReference<Sender>() {});
        }

    }

    public static class ListAll<T extends ListAll<T>> extends CoreSeek.SearchCore<Sender, T> {

        /**
         * @param pageNumber Defaults to 1 page if not given.<br>
         *                   Use in conjunction with page_size to return a subset.
         * @return T
         */
        public T setPageNumber(int pageNumber) {
            addNameValuePair("page_number", pageNumber);
            return self();
        }

        /**
         * @param pageSize Defaults to 25 items if not given.<br/>
         *                Determines the number of items returned per page.
         * @return T
         */
        public T setPageSize(int pageSize) {
            addNameValuePair("page_size", pageSize);
            return self();
        }

        public Listed<Sender> getResponse(){

            return super.getResponse(
                    SENDERS,
                    build(),
                    new TypeReference<Listing<Sender>>() {}
            );

        }

    }
}
