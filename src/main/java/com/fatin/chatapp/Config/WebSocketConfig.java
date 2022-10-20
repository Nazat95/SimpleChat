package com.fatin.chatapp.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Methods for creating endpoint and message broker
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Register a websocket endpoint for a client to use
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry){
        stompEndpointRegistry.addEndpoint("/websocket").withSockJS();
    }

    /**
     * Configure a message broker that will be used to route messages
     * @param messageBrokerRegistry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry){
        //messageBrokerRegistry.enableSimpleBroker("/topic");
        messageBrokerRegistry.setApplicationDestinationPrefixes("/app");
        messageBrokerRegistry.enableSimpleBroker("/session");
    }
}
