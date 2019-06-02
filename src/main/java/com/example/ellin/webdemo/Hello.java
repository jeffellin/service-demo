package com.example.ellin.webdemo;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hello {

    @Id
    private String hello;

    private String phrase;

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
