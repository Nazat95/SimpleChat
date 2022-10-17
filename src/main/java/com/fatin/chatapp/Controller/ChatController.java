package com.fatin.chatapp.Controller;

import com.fatin.chatapp.Model.ChatMessages;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping
    @SendTo("/topic/public")
    public ChatMessages newUser(@Payload ChatMessages chatMessages, SimpMessageHeaderAccessor accessor){
        accessor.getSessionAttributes().put("username",chatMessages.getSender());
        return chatMessages;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessages sendMessages(@Payload ChatMessages chatMessages){
        return chatMessages;
    }
}
