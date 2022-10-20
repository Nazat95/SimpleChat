package com.fatin.chatapp.Controller;

import com.fatin.chatapp.Model.ChatMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * Event listener for connecting and disconnecting
 */
@Component
public class EventListener {
    private static final Logger logger = LoggerFactory.getLogger(EventListener.class);

    @Autowired
    private SimpMessageSendingOperations sendingOperations;

    @org.springframework.context.event.EventListener
    public void connectListener(SessionConnectedEvent connectedEvent){
        logger.info("New Connection added");
    }
    @org.springframework.context.event.EventListener
    public void disconnectListener(SessionDisconnectEvent disconnectEvent){
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(disconnectEvent.getMessage());

        String username = (String) accessor.getSessionAttributes().get("username");
        if (username!=null){
            logger.info("User disconnected: " +username);
            ChatMessages chatMessages = new ChatMessages();
            chatMessages.setMessageType(ChatMessages.MessageType.LEAVE);
            chatMessages.setSender(username);
            sendingOperations.convertAndSend("/session/public", chatMessages);

        }

    }

}
