package cn.edu.ncu.cs15.service;

import cn.edu.ncu.cs15.dto.WebSocketInMessage;
import cn.edu.ncu.cs15.dto.WebSocketOutMessage;

import java.sql.Timestamp;

public interface WebSocketService {
    WebSocketOutMessage processMessage(String currentId, WebSocketInMessage in);
}
