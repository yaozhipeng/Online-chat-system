package cn.edu.ncu.cs15.entity;

public class Information {
    private String userId;
    private String name;
    private Integer gender;
    private String motto;
    private String school;
    private String phone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Information{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", motto='" + motto + '\'' +
                ", school='" + school + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
