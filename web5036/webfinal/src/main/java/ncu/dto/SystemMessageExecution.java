package ncu.dto;

import java.util.List;

public class SystemMessageExecution {
    private List<Friend> friendList;

    public SystemMessageExecution(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public List<Friend> getFriendList() {
        return friendList;
    }
}
