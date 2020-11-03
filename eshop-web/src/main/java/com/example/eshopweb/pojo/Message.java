package com.example.eshopweb.pojo;

public class Message {

    private String message;

    private int code;

    public Message(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
