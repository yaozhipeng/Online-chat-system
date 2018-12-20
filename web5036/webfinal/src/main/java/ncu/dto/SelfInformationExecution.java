package ncu.dto;

public class SelfInformationExecution {
    private String id;
    private String name;
    private String email;
    private Integer gender;
    private String habit;
    private String address;
    private String phone;



    public SelfInformationExecution(String id, String name, String email, Integer gender, String habit, String address, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.habit = habit;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getGender() {
        return gender;
    }

    public String getHabit() {
        return habit;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
