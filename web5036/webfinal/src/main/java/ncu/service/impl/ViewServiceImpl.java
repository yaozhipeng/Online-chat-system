package ncu.service.impl;

import ncu.dao.ImpressionDao;
import ncu.dao.InformationDao;
import ncu.dao.RelationDao;
import ncu.dao.UserDao;
import ncu.dto.*;
import ncu.entity.Impression;
import ncu.entity.Information;
import ncu.entity.Relation;
import ncu.entity.User;
import ncu.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ViewServiceImpl implements ViewService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private InformationDao informationDao;
    @Autowired
    private RelationDao relationDao;
    @Autowired
    private ImpressionDao impressionDao;

    @Override
    public Result<DownloadChatExecution> downloadChat(String currentId) {
        List<Friend> friendList = getFriendList(currentId);
        DownloadChatExecution execution = new DownloadChatExecution(friendList);
        return new Result<>(true, execution);
    }

    @Override
    public Result<HomeExecution> home(String currentId) {
        List<Friend> friendList = new ArrayList<>();
        Map<String, Information> informationMap = new HashMap<>();
        Map<String, List<Impression>> impressionListMap = new HashMap<>();
        // 找到根据relation表所有好友
        List<Relation> relationList = relationDao.queryByFromId(currentId);
        relationList = relationList.stream()
                .filter(relation -> relation.getState() != null && relation.getState() == 1)
                .collect(Collectors.toList());
        for(Relation r : relationList) {
            String id = r.getToId();
            User user = userDao.queryById(id);
            Information information = informationDao.queryById(id);
            friendList.add(new Friend(id, information.getName(), user.getEmail()));
            informationMap.put(id, information);
            List<Impression> impressionList = impressionDao.queryByToId(id);
            impressionListMap.put(id, impressionList);
        }
        HomeExecution execution = new HomeExecution(friendList, informationMap, impressionListMap);
        return new Result<>(true, execution);
    }

    @Override
    public Result<LabelFriendExecution> labelFriend(String currentId) {
        List<Friend> friendList = getFriendList(currentId);
        LabelFriendExecution execution = new LabelFriendExecution(friendList);
        return new Result<>(true, execution);
    }

    @Override
    public Result<ManagerFriendExecution> managerFriend(String currentId) {
        List<Friend> friendList = getFriendList(currentId);
        ManagerFriendExecution execution = new ManagerFriendExecution(friendList);
        return new Result<>(true, execution);
    }

    @Override
    public Result<SelfInformationExecution> selfInformation(String currentId) {
        User user = userDao.queryById(currentId);
        Information information = informationDao.queryById(currentId);
        SelfInformationExecution execution = new SelfInformationExecution(
                currentId,
                information.getName(),
                user.getEmail(),
                information.getGender(),
                information.getHabit(),
                information.getAddress(),
                information.getPhone()
        );
        return new Result<>(true, execution);
    }

    @Override
    public Result<SelfLabelExecution> selfLabel(String currentId) {
        List<Impression> impressionList = impressionDao.queryByToId(currentId);
        List<User> userList = new ArrayList<>();
        Map<String, Information> informationMap = new HashMap<>();
        Map<String, String> impressionMap = new HashMap<>();
        for (Impression impression : impressionList) {
            String id = impression.getFromId();
            User user = userDao.queryById(id);
            Information information = informationDao.queryById(id);
            userList.add(user);
            informationMap.put(id, information);
            impressionMap.put(id, impression.getDescription());
        }
        SelfLabelExecution execution = new SelfLabelExecution(userList, informationMap, impressionMap);
        return new Result<>(true, execution);
    }

    @Override
    public Result<VerificationExecution> verification(String currentId) {
        List<Relation> relationList = relationDao.queryByToId(currentId);
        List<Friend> friendList = new ArrayList<>();
        for (Relation r : relationList) {
            if (r.getState() != null && r.getState() == 0) {
                String id = r.getFromId();
                User user = userDao.queryById(id);
                Information information = informationDao.queryById(id);
                friendList.add(new Friend(id,information.getName(), user.getEmail()));
            }
        }
        VerificationExecution execution = new VerificationExecution(friendList);
        return new Result<>(true, execution);
    }

    private List<Friend> getFriendList(String currentId) {
        List<Friend> friendList = new ArrayList<>();
        List<Relation> relationList = relationDao.queryByFromId(currentId);
        for (Relation r : relationList) {
            if (r.getState() != null && r.getState() == 1) {
                String id = r.getToId();
                User user = userDao.queryById(id);
                Information information = informationDao.queryById(id);
                friendList.add(new Friend(id, information.getName(), user.getEmail()));
            }
        }
        return friendList;
    }
}
