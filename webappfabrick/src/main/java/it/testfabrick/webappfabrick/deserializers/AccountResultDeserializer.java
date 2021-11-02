package it.testfabrick.webappfabrick.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import it.testfabrick.webappfabrick.model.Account;
import it.testfabrick.webappfabrick.model.AccountResult;
import it.testfabrick.webappfabrick.model.AccountResultPayload;

import java.io.IOException;
import java.util.ArrayList;

public class AccountResultDeserializer extends StdDeserializer<AccountResult> {

    public AccountResultDeserializer() {
        this(null);
    }
    private AccountResultDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public AccountResult deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode node = jp.getCodec().readTree(jp);

        String status = node.get("status").asText();

        if(status.equals( "OK")){
            JsonNode payload = node.get("payload");
            JsonNode list = payload.get("list");
            ArrayList<Account> accountList = new ArrayList<Account>();

            if(list.isArray()) {
                list.forEach( jsonNode -> {

                    String accountId = jsonNode.get("accountId").asText();
                    String iban = jsonNode.get("iban").asText();
                    String abiCode = jsonNode.get("abiCode").asText();
                    String cabCode = jsonNode.get("cabCode").asText();
                    String countryCode = jsonNode.get("countryCode").asText();
                    String internationalCin = jsonNode.get("internationalCin").asText();
                    String nationalCin = jsonNode.get("nationalCin").asText();
                    String account = jsonNode.get("account").asText();
                    String alis = "";// jsonNode.get("alis").asText();
                    String productName = jsonNode.get("productName").asText();
                    String holderName = jsonNode.get("holderName").asText();
                    String activatedDate = jsonNode.get("activatedDate").asText();
                    String currency = jsonNode.get("currency").asText();

                    Account a = new Account(
                            accountId
                            , iban
                            , abiCode
                            , cabCode
                            , countryCode
                            , internationalCin
                            , nationalCin
                            , account
                            , alis
                            , productName
                            , holderName
                            , activatedDate
                            , currency
                    );
                    accountList.add(a);
                });
                return new AccountResult(status, new AccountResultPayload(accountList));
            }

            return new AccountResult(status, new AccountResultPayload(accountList));

        }else{
            return new AccountResult(status, null);
        }

    }
}
