package com.collaborate.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker	//enable broker based stomp messaging - Autodecting annotation @MessageMapping
@ComponentScan(basePackages="com.collaborate")
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer
{
	public void registerStompEndpoints(StompEndpointRegistry registry) 
	{
		registry.addEndpoint("/portfolio").withSockJS();	//to connect with websocket
		//withSockJs()=> it used beacouse some web brouser doesnot support web socket
		
	}

	public void configureClientInboundChannel(ChannelRegistration arg0) {
		// TODO Auto-generated method stub
		
	}

	public void configureClientOutboundChannel(ChannelRegistration arg0) {
		// TODO Auto-generated method stub
		
	}

	public void configureMessageBroker(MessageBrokerRegistry registry) 
	{
		System.out.println("configure");
		registry.enableSimpleBroker("/queue/","/topic/");	//server to broker to client
		//there are 2 destination prefix 1-/queue => is for chat message
		//								 2-/topic => is for newly joined user
		
		registry.setApplicationDestinationPrefixes("/app");	//from client to server
		
	}

	

}
