package cn.edu.ncu.cs15.dto;

import java.util.List;

public class FindNewFriendExecution {
    private List<Friend> newFriendList;

    public FindNewFriendExecution(List<Friend> newFriendList) {
        this.newFriendList = newFriendList;
    }

    public List<Friend> getNewFriendList() {
        return newFriendList;
    }
}
