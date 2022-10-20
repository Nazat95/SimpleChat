package com.fatin.chatapp.Controller;

import com.fatin.chatapp.Model.ChatMessages;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * Methods responsible for receiving and broadcasting message between clients
 */
@Controller
public class ChatController {
    @MessageMapping("/session.newUser")
    @SendTo("/session/public")
    public ChatMessages newUser(@Payload ChatMessages chatMessages, SimpMessageHeaderAccessor accessor){
        accessor.getSessionAttributes().put("username",chatMessages.getSender());
        return chatMessages;
    }

    @MessageMapping("/chat.sendMessages")
    @SendTo("/session/public")
    public ChatMessages sendMessages(@Payload ChatMessages chatMessages){
        return chatMessages;
    }
}
