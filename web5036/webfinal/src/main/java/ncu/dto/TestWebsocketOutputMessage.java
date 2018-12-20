package ncu.dto;

public class TestWebsocketOutputMessage {
    private String from;
    private String text;
    private String time;

    public TestWebsocketOutputMessage(String from, String text, String time) {
        this.from = from;
        this.text = text;
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }
}
