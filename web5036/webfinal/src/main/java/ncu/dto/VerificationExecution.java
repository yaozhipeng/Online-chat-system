package ncu.dto;

import java.util.List;

public class VerificationExecution {
    private List<Friend> friendList;

    public VerificationExecution(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public List<Friend> getFriendList() {
        return friendList;
    }
}
