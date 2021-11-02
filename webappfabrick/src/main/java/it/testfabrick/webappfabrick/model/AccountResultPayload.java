package it.testfabrick.webappfabrick.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

public class AccountResultPayload {

    public AccountResultPayload(List<Account> list) {
        if(list != null) {
            this.list = list;
        }else{
            this.list = new ArrayList<Account>();
        }
    }

    public List<Account> getList() {
        return list;
    }

    public void setList(List<Account> list) {
        this.list = list;
    }

    private List<Account> list;
}
