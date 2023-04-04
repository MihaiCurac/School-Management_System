package sms.model;

public class Student {

    private int adNo;
    private String fullName;
    private String yearofstudy;
    private String dob;
    private String gender;
    private String phone;
    private String address;


    public Student(int adNo, String fullName, String yearofstudy, String dob, String gender, String phone, String address) {
        this.adNo = adNo;
        this.fullName = fullName;
        this.yearofstudy = yearofstudy;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public Integer getAdNo() {return adNo;}

    public void setAdNo(int adNo) {
        this.adNo = adNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setyearofstudy(String yearofstudy) {this.yearofstudy = yearofstudy;}

    public String getyearofstudy() {return yearofstudy;}

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) { this.dob = dob; }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
