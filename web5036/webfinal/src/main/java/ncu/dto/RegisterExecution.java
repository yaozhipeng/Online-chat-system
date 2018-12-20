package ncu.dto;

public class RegisterExecution {
    private String email;

    public RegisterExecution() {
    }

    public RegisterExecution(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
