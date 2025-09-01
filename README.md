# webexinteract
Use WebExInteract to send bulk SMS online. 
Instantly reach out to your customers with personalized SMS marketing messages, updates, alerts, OTPs, SMS attachments &amp; more.

The Upstream [API](https://docs.webexinteract.com/reference/sms-api) is still in it's infancy and so subsequently is this API! :disappointed:

What we and upstream can do however is:

    SendSms.send()
    Accounts.read()
    Senders.read()
    Senders.list()
    Senders.delete()

Enjoy :smiley:

Note: We use a 4 point versioning system: (Semantic Versioning 2.0.0 + 1) W.X.Y.Z  
    W: The Upstream API version that is being targetted  
    X: MAJOR version when we make incompatible API changes  
    Y: MINOR version when we add functionality in a backward compatible manner  
    Z: PATCH version when we make backward compatible bug fixes  

## Authentication

Create a file in user home ~ named /.webexinteract-api/config.json
Set contents as below. Change the secret.

```json
{
  "website" : "api.webexinteract.com", 
  "secret": "abc_1234567890abcdef1234567890abcdef"
}
```

## Account
```java
private static void accounts() {

    Read<Account> read = Accounts.read().getResponse();

    if (read.isSuccess()) {

        System.out.println(
            new JacksonObjectMapper().toJson(read.getResult())
        );

    } else {

        System.out.println(
            new JacksonObjectMapper().toJson(read.getError())
        );

    }

}

```
## Send SMS
```java
private static void sendSms(String phoneNumber){

    //you can add a list of recipients or a single recipient
    //you can also add a list of phoneNumbers under the Recipient
    Created<Sms> created =
        SendSms
            .send(MY_MESSAGE, MY_SENDERNAME)
            .addTo(new Recipient().countryCode("GB").phone(phoneNumber)) //set GB as country use 'normal' 07000123456 format
            //.addTo(new Recipient().phone(e164phoneNumber)) //use the +4470000123456 format
            //.setScheduleAt(ZonedDateTime.now().minusDays(2)) //cause in the past error
            //.setScheduleAt(ZonedDateTime.now().plusYears(2)) //cause too far in the future error
            .setSkipOptOutCheck(true)
            .getResponse();

    if (created.isSuccess()){
        //if we enter an incorrect phone number we receive response 200
        //but getErrors is not empty
        //so if we enter lots of numbers we have a list of messages that succeed
        //and a list of those that failed
        System.out.println(
            new JacksonObjectMapper().toJson(created.getResult())
        );

        for (SmsTransaction success : created.getResult().getMessages()){
            System.out.println("Success to " + success.getTo());
        }
        for (SmsTransaction success : created.getResult().getErrors()){
            System.out.println("Failure to " + success.getTo());
        }

        if (created.getResult().getErrors().isEmpty()){

            System.out.println("Success Success!");

        }else{

            System.out.println("Success with Error(s)!");

        }

    }else{

        System.out.println("FAILURE");
        System.out.println(
            new JacksonObjectMapper().toJson(created.getError())
        );

    }

}
```

## Senders
### List
```java
private static void sendersList() {

    Listed<Sender> listed = Senders.list().getResponse();

    if (listed.isSuccess()) {

        System.out.println("SUCCESS");

        System.out.println(
            new JacksonObjectMapper().toJson(
                listed.getResult()
            )
        );

        System.out.println(
            new JacksonObjectMapper().toJson(
                listed.getResult().getPaging()
            )
        );

        for (Sender sender : listed.getResult().getItems()) {
            System.out.println(
                    new JacksonObjectMapper().toJson(sender)
            );

            Read<Sender> read = Senders.read(sender.getId()).getResponse();
            
            if (read.isSuccess()) {
                System.out.println(
                    "READ IT BACK" + new JacksonObjectMapper().toJson(read.getResult())
                );
            }

        }

        //There is an API option to delete. but NOT create.
        //We do not have a sandbox so for now I have not implemented delete

    } else {

        System.out.println("FAILURE");
        System.out.println(
            new JacksonObjectMapper().toJson(listed.getError())
        );

    }
}
```

### Delete 
```java 
private static void senderDelete() {

    Deleted<Sender> delete = Senders.delete("ssd_3XXXXXXXXXXXXXXXXXXXXX").getResponse();

    if (delete.isSuccess()){
        System.out.println("Success");
    }else{
        System.out.println("Error");
        System.out.println(
            new JacksonObjectMapper().toJson(delete.getError())
        );
    }

}    
```