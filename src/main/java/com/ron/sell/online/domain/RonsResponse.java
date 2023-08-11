package com.ron.sell.online.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

    
public class RonsResponse {

    private List<String> codes =  new ArrayList<>();
    private List<String> messages =  new ArrayList<>();
    
    public RonsResponse(){

    }

   
    public RonsResponse(String code, String message) {
      //  messages.add(message);
        codes.add(code);
        messages.add(message);

    }

    public List<String> getCodes() {
        return this.codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }

    public List<String> getMessages() {
        return this.messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RonsResponse)) {
            return false;
        }
        RonsResponse ronsResponse = (RonsResponse) o;
        return Objects.equals(codes, ronsResponse.codes) && Objects.equals(messages, ronsResponse.messages) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codes, messages);
    }

    @Override
    public String toString() {
        return "{" +
            " codes='" + getCodes() + "'" +
            ", messages='" + getMessages() + "'" +
            "}";
    }
  
}