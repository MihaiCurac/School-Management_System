package sms.model;

public class Staff {

    private int empNo;
    private String teacherName;
    private String taughtSubject;
    private String dob;
    private String gender;
    private String email;
    private String phone;
    private String address;

    public Staff(int empNo, String teacherName, String taughtSubject, String dob, String gender, String email, String phone, String address) {
        this.empNo = empNo;
        this.teacherName = teacherName;
        this.taughtSubject = taughtSubject;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTaughtSubject() { return taughtSubject; }

    public void setTaughtSubject(String taughtSubject) { this.taughtSubject = taughtSubject; }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {this.email = email; }

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
