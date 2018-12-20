package ncu.dto;

import java.util.List;

public class LabelFriendExecution {
    private List<Friend> friendList;

    public LabelFriendExecution(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public List<Friend> getFriendList() {
        return friendList;
    }
}
