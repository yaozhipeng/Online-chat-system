package ncu.entity;

import java.sql.Timestamp;

public class Message {
    private String toId;
    private String fromId;
    private String content;
    private Timestamp time;

    public Message() {
    }

    public Message(String toId, String fromId, String content, Timestamp time) {
        this.toId = toId;
        this.fromId = fromId;
        this.content = content;
        this.time = time;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MessageDao{" +
                "toId='" + toId + '\'' +
                ", fromId='" + fromId + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}
