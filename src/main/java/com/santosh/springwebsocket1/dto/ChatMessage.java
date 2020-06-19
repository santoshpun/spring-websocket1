package com.santosh.springwebsocket1.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChatMessage {
    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

    private MessageType messageType;
    private String content;
    private String sender;

    public MessageType getType() {
        return messageType;
    }

    public void setType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
