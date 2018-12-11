package cn.edu.ncu.cs15.service.impl;

import cn.edu.ncu.cs15.dao.InformationDao;
import cn.edu.ncu.cs15.dao.MessageDao;
import cn.edu.ncu.cs15.dto.WebSocketInMessage;
import cn.edu.ncu.cs15.dto.WebSocketOutMessage;
import cn.edu.ncu.cs15.entity.Information;
import cn.edu.ncu.cs15.entity.Message;
import cn.edu.ncu.cs15.service.WebSocketService;
import cn.edu.ncu.cs15.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

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
