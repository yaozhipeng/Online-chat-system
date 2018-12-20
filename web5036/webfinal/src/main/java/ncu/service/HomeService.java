package ncu.service;


import ncu.dto.FindNewFriendExecution;
import ncu.dto.Result;
import ncu.dto.SelfInformationExecution;

public interface HomeService {
    Result<FindNewFriendExecution> findNewFriend(String fromId, String key);
    void addNewFriendRequest(String fromId, String toId);
    void agreeNewFriend(String fromId, String toId);
    void updateSelfInformation(SelfInformationExecution execution);
    void deleteFriend(String fromId, String toId);
    void label(String fromId, String toId, String content);
    String chatHistory(String id1, String id2);
}
