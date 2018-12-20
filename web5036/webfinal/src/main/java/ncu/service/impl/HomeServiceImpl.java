package ncu.service.impl;


import ncu.service.HomeService;
import ncu.utils.TimeUtil;
import ncu.dao.*;
import ncu.dto.FindNewFriendExecution;
import ncu.dto.Friend;
import ncu.dto.Result;
import ncu.dto.SelfInformationExecution;
import ncu.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RelationDao relationDao;
    @Autowired
    private InformationDao informationDao;
    @Autowired
    private ImpressionDao impressionDao;
    @Autowired
    private MessageDao messageDao;

    @Override
    public Result<FindNewFriendExecution> findNewFriend(String fromId, String key) {
        List<Relation> relationList = relationDao.queryByFromId(fromId); // 朋友
        List<Information> informationList = informationDao.queryByName(key); // 通过名字查找
        User user = userDao.queryByEmail(key);  // 通过邮箱查找
        // 名字结果 + 邮箱结果 - 自己 - 朋友 = 新朋友
        Set<String> friendIdSet = new HashSet<>();
        for(Information information : informationList) {
            friendIdSet.add(information.getUserId());
        }
        friendIdSet.add(user.getId());
        for(Relation relation : relationList) {
            friendIdSet.remove(relation.getToId());
        }
        friendIdSet.remove(fromId);
        List<Friend> newFriendList = new ArrayList<>();
        for (String newFriendId : friendIdSet) {
            user = userDao.queryById(newFriendId);
            Information information = informationDao.queryById(newFriendId);
            Friend friend = new Friend(newFriendId, information.getName(), user.getEmail());
            newFriendList.add(friend);
        }
        FindNewFriendExecution execution = new FindNewFriendExecution(newFriendList);
        return new Result<>(true, execution);
    }

    @Override
    public void addNewFriendRequest(String fromId, String toId) {
        Relation relation = new Relation(toId, fromId, 0);
        relationDao.add(relation);
    }

    @Override
    @Transactional
    public void agreeNewFriend(String fromId, String toId) {
        Relation reverseRelation = new Relation(fromId, toId, 1);
        relationDao.modifyState(fromId, toId, 1);
        relationDao.add(reverseRelation);
    }

    @Override
    @Transactional
    public void updateSelfInformation(SelfInformationExecution execution) {
        Information information = new Information();
        information.setUserId(execution.getId());
        information.setName(execution.getName());
        information.setGender(execution.getGender());
        information.setHabit(execution.getHabit());
        information.setAddress(execution.getAddress());
        information.setPhone(execution.getPhone());
        informationDao.modify(information);
    }

    @Override
    @Transactional
    public void deleteFriend(String fromId, String toId) {
        relationDao.delete(fromId, toId);
        relationDao.delete(toId, fromId);
    }

    @Override
    @Transactional
    public void label(String fromId, String toId, String content) {
        Impression impression = impressionDao.query(fromId, toId);
        if (impression == null) {
            impression = new Impression(toId, fromId, content);
            impressionDao.add(impression);
        } else {
            impression.setDescription(content);
            impressionDao.modify(impression);
        }
    }

    @Override
    public String chatHistory(String id1, String id2) {
        Information information1 = informationDao.queryById(id1);
        Information information2 = informationDao.queryById(id2);
        List<Message> list = messageDao.queryAll(id1, id2);
        List<Message> list1 = messageDao.queryAll(id2, id1);
        list.addAll(list1);
        list.sort(Comparator.comparing(Message::getTime));
        StringBuilder builder = new StringBuilder();
        for(Message m : list) {
            String time = TimeUtil.timestampToLongString(m.getTime());
            String from = m.getFromId().equals(id1) ? information1.getName() : information2.getName();
            String content = m.getContent();
            builder.append("[").append(time).append("] ")
                    .append(from).append(": ")
                    .append(content).append("\r\n");
        }
        return builder.toString();
    }
}
