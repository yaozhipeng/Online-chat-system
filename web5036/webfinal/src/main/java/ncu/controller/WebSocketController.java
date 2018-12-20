package ncu.controller;

import ncu.dto.WebSocketInMessage;
import ncu.dto.WebSocketOutMessage;
import ncu.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private WebSocketService webSocketService;

    @MessageMapping("/chat/{toId}")
    public void chat(@DestinationVariable("toId") String toId, WebSocketInMessage message) {
        WebSocketOutMessage out = webSocketService.processMessage(toId, message);
        simpMessagingTemplate.convertAndSend("/topic/chat/" + toId, out);
    }
}

