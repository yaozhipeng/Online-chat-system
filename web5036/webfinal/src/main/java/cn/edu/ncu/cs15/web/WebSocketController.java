package cn.edu.ncu.cs15.web;

import cn.edu.ncu.cs15.dto.TestWebsocketMessage;
import cn.edu.ncu.cs15.dto.WebSocketInMessage;
import cn.edu.ncu.cs15.dto.WebSocketOutMessage;
import cn.edu.ncu.cs15.entity.Message;
import cn.edu.ncu.cs15.service.WebSocketService;
import cn.edu.ncu.cs15.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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

