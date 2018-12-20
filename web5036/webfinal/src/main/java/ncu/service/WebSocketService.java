package ncu.service;

import ncu.dto.WebSocketInMessage;
import ncu.dto.WebSocketOutMessage;

public interface WebSocketService {
    WebSocketOutMessage processMessage(String currentId, WebSocketInMessage in);
}
