package ncu.service.impl;

import ncu.dao.InformationDao;
import ncu.dao.MessageDao;
import ncu.dto.WebSocketInMessage;
import ncu.dto.WebSocketOutMessage;
import ncu.entity.Information;
import ncu.entity.Message;
import ncu.service.WebSocketService;
import ncu.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WebSocketServiceImpl implements WebSocketService {
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private InformationDao informationDao;
    @Override
    @Transactional
    public WebSocketOutMessage processMessage(String currentId, WebSocketInMessage in) {
        Message message = new Message(currentId, in.getFrom(), in.getText(), TimeUtil.nowTimestamp());
        if(!message.getFromId().equals(message.getToId())) {
            messageDao.add(message);
        }
        Information fromUser = informationDao.queryById(message.getFromId());
        Information toUser = informationDao.queryById(message.getToId());
        return new WebSocketOutMessage(
                message.getFromId(),
                fromUser.getName(),
                toUser.getUserId(),
                toUser.getName(),
                message.getContent(),
                TimeUtil.timestampToString(message.getTime())
        );
    }
}
