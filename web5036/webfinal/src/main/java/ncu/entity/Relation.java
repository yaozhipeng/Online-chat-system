package ncu.entity;

public class Relation {
    private String toId;
    private String fromId;
    private Integer state;

    public Relation() {
    }

    public Relation(String toId, String fromId, Integer state) {
        this.toId = toId;
        this.fromId = fromId;
        this.state = state;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "toId='" + toId + '\'' +
                ", fromId='" + fromId + '\'' +
                ", state=" + state +
                '}';
    }
}
