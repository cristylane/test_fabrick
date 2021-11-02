package it.testfabrick.webappfabrick.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import it.testfabrick.webappfabrick.deserializers.AccountResultDeserializer;

@JsonDeserialize(using = AccountResultDeserializer.class)
public class AccountResult {
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AccountResultPayload getPayload() {
        return payload;
    }

    public void setPayload(AccountResultPayload payload) {
        this.payload = payload;
    }

    private String status;
    private AccountResultPayload payload;

    public AccountResult(String status, AccountResultPayload payload) {
        this.status = status;
        this.payload = payload;
    }
}
