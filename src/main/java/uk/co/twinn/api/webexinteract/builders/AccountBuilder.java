package uk.co.twinn.api.webexinteract.builders;

import com.fasterxml.jackson.core.type.TypeReference;
import uk.co.twinn.api.webexinteract.models.account.Account;
import uk.co.twinn.api.webexinteract.response.Read;

import static uk.co.twinn.api.webexinteract.defines.EndPoints.ACCOUNT;

public class AccountBuilder {

    public static class Reader extends CoreReader.ReaderNoParameters<Account>{

        public Reader(){
            super();
        }

        public Read<Account> getResponse(){
            return super.getResponse(ACCOUNT, new TypeReference<Account>() {});
        }

    }

}
