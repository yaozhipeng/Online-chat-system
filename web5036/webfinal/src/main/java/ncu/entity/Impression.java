package ncu.entity;

public class Impression {
    private String toId;
    private String fromId;
    private String description;

    public Impression() {
    }

    public Impression(String toId, String fromId, String description) {
        this.toId = toId;
        this.fromId = fromId;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Impression{" +
                "toId='" + toId + '\'' +
                ", fromId='" + fromId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
