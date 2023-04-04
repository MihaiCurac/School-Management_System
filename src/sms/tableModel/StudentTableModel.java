package sms.tableModel;

public class StudentTableModel {

     int adNo;
     String fullName;
     String dob;
     String gender;
     String phone;
     String address;

    public StudentTableModel(int adNo, String fullName, String dob, String gender, String phone, String address) {
        this.adNo = adNo;
        this.fullName = fullName;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public StudentTableModel(int adNo) {
    }

    public int getAdNo() {
        return adNo;
    }

    public void setAdNo(int adNo) {
        this.adNo = adNo;
    }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

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
