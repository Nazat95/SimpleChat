package com.fatin.chatapp.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatMessages {
    private String content;
    private String sender;
    private MessageType messageType;

    public enum MessageType{
        JOIN, CHAT, LEAVE;
    }
}
