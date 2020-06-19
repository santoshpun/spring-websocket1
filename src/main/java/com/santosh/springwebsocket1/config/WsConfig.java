package com.santosh.springwebsocket1.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Slf4j
@Configuration
@EnableWebSocketMessageBroker
public class WsConfig implements WebSocketMessageBrokerConfigurer {

    public static final String ENDPOINT_CONNECT = "/socket";
    public static final String SUBSCRIBE_USER_PREFIX = "/private";
    public static final String SUBSCRIBE_USER_REPLY = "/reply";
    public static final String SUBSCRIBE_QUEUE = "/queue";
    public static final String CHANNEL_QUEUE = "/channel";

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry
                .enableSimpleBroker(SUBSCRIBE_QUEUE, SUBSCRIBE_USER_REPLY, CHANNEL_QUEUE);
        registry.setApplicationDestinationPrefixes("/app");
        registry.setUserDestinationPrefix(SUBSCRIBE_USER_PREFIX);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint(ENDPOINT_CONNECT)
                .setAllowedOrigins("*");

        registry
                .addEndpoint(ENDPOINT_CONNECT)
                .setAllowedOrigins("*")
                .withSockJS();
    }
}
