package cn.edu.ncu.cs15.dto;

public class SelfInformationExecution {
    private String id;
    private String name;
    private String email;
    private Integer gender;
    private String motto;
    private String school;
    private String phone;

    public SelfInformationExecution(String id, String name, String email, Integer gender, String motto, String school, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.motto = motto;
        this.school = school;
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

    public String getMotto() {
        return motto;
    }

    public String getSchool() {
        return school;
    }

    public String getPhone() {
        return phone;
    }
}
