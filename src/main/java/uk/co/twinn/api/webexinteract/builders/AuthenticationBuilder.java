package uk.co.twinn.api.webexinteract.builders;

import uk.co.twinn.api.webexinteract.response.Message;
import uk.co.twinn.api.webexinteract.response.core.ApiResponseResult;
import uk.co.twinn.api.webexinteract.rest.Configuration;

public class AuthenticationBuilder {

    public static class Https{

        private String website;
        private String secret;

        public Https setWebsite(String website){
            this.website = website;
            return this;
        }

        public Https setSecret(String secret){
            this.secret = secret;
            return this;
        }

        /**
         *  Stores the provided details for later use by the system
         *  This only needs to be done once in our application
         */
        public Message getResponse(){

            new Configuration.Builder()
                .website(website)
                .secret(secret)
                .build();

            return new Message(
                new ApiResponseResult<>(
                    true,
                    200,
                    "{\"message\": \"The Authentication Configuration has been updated with the provided values.\"}"
                )
            );

        }

    }

}
