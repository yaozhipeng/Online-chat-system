package ncu.dto;

import java.util.List;

public class DownloadChatExecution {
    private List<Friend> friendList;

    public DownloadChatExecution(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public List<Friend> getFriendList() {
        return friendList;
    }
}
