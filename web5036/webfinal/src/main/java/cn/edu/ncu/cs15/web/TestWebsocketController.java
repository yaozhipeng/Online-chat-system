//package cn.edu.ncu.cs15.web;
//
//import cn.edu.ncu.cs15.dto.TestWebsocketMessage;
//import cn.edu.ncu.cs15.dto.TestWebsocketOutputMessage;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Controller
//public class TestWebsocketController {
//    @MessageMapping("/chat")
//    @SendTo("/topic/messages")
//    public TestWebsocketOutputMessage send(TestWebsocketMessage message) {
//        String time = new SimpleDateFormat("HH:mm").format(new Date());
//        return new TestWebsocketOutputMessage(message.getFrom(), message.getText(), time);
//    }
//}
