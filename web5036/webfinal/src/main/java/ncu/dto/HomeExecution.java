package ncu.dto;

import ncu.entity.Impression;
import ncu.entity.Information;

import java.util.List;
import java.util.Map;

public class HomeExecution {
    private List<Friend> friendList;
    private Map<String, Information> informationMap;
    private Map<String, List<Impression>> impressionListMap;

    public HomeExecution(List<Friend> friendList, Map<String, Information> informationMap, Map<String, List<Impression>> impressionListMap) {
        this.friendList = friendList;
        this.informationMap = informationMap;
        this.impressionListMap = impressionListMap;
    }

    public List<Friend> getFriendList() {
        return friendList;
    }

    public Map<String, Information> getInformationMap() {
        return informationMap;
    }

    public Map<String, List<Impression>> getImpressionListMap() {
        return impressionListMap;
    }
}
