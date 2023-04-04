package sms.model;

public class School {
    private String schoolName;
    private String schoolAddress;
    private String classAvailable;
    private String schoolType;
    private String postalCode;
    private String dateOfEstd;
    private String schoolID;
    private String nameOfPrincipal;

    public School(){

    }

    public School(String schoolName, String schoolAddress, String classAvailable, String schoolType, String postalCode, String dateOfEstd, String schoolID, String nameOfPrincipal) {
        this.schoolName = schoolName;
        this.schoolAddress = schoolAddress;
        this.classAvailable = classAvailable;
        this.schoolType = schoolType;
        this.postalCode = postalCode;
        this.dateOfEstd = dateOfEstd;
        this.schoolID = schoolID;
        this.nameOfPrincipal = nameOfPrincipal;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        schoolName = schoolName;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        schoolAddress = schoolAddress;
    }

    public String getClassAvailable() {
        return classAvailable;
    }

    public void setClassAvailable(String classAvailable) {
        this.classAvailable = classAvailable;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDateOfEstd() {
        return dateOfEstd;
    }

    public void setDateOfEstd(String dateOfEstd) {
        this.dateOfEstd = dateOfEstd;
    }

    public String getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(String schoolID) {
        this.schoolID = schoolID;
    }

    public String getNameOfPrincipal() {
        return nameOfPrincipal;
    }

    public void setNameOfPrincipal(String nameOfPrincipal) {
        this.nameOfPrincipal = nameOfPrincipal;
    }


}
