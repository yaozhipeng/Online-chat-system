package ncu.dto;

import java.util.List;

public class ManagerFriendExecution {
    private List<Friend> friendList;

    public ManagerFriendExecution(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public List<Friend> getFriendList() {
        return friendList;
    }
}
