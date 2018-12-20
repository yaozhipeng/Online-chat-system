package ncu.dto;

import ncu.entity.Information;
import ncu.entity.User;

import java.util.List;
import java.util.Map;

public class SelfLabelExecution {
    private List<User> fromUserList;
    private Map<String, Information> fromInformationMap;
    private Map<String, String> impressionMap;

    public SelfLabelExecution(List<User> fromUserList, Map<String, Information> fromInformationMap, Map<String, String> impressionMap) {
        this.fromUserList = fromUserList;
        this.fromInformationMap = fromInformationMap;
        this.impressionMap = impressionMap;
    }

    public List<User> getFromUserList() {
        return fromUserList;
    }

    public Map<String, Information> getFromInformationMap() {
        return fromInformationMap;
    }

    public Map<String, String> getImpressionMap() {
        return impressionMap;
    }
}
