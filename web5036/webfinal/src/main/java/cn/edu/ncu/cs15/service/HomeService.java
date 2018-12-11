package cn.edu.ncu.cs15.service;

import cn.edu.ncu.cs15.dto.*;

public interface HomeService {
    Result<FindNewFriendExecution> findNewFriend(String fromId, String key);
    void addNewFriendRequest(String fromId, String toId);
    void agreeNewFriend(String fromId, String toId);
    void updateSelfInformation(SelfInformationExecution execution);
    void deleteFriend(String fromId, String toId);
    void label(String fromId, String toId, String content);
    String chatHistory(String id1, String id2);
}
