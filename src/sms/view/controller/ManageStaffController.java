package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sms.dbController.LoginController;
import sms.dbController.StaffController;
import sms.model.Staff;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageStaffController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private AnchorPane root;

    @FXML
    private TextField empNoField;

    @FXML
    private TextField teacherNameField;

    @FXML
    private TextField taughtSubjectField;

    @FXML
    private TextField dobField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField emailField;

    @FXML
    private JFXButton deleteStaff;

    @FXML
    private JFXButton update;

    @FXML
    private TextField genderField;

    @FXML
    private TextField EmpNo;

    @FXML
    private JFXButton searchStaff;

    @FXML
    private TextField empName;

    @FXML
    private JFXButton searchByName;

    @FXML
    private JFXButton btnShowAll;

    @FXML
    private JFXButton Back;

    LoginController log = new LoginController();

    @FXML
    void setbtnShowAll(ActionEvent event) {
        try {
            AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/PrintStaff.fxml")));
            root.getChildren().setAll(user);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void Back(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StaffManagement.fxml")));
            root.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void searchByName(ActionEvent event) {
        try {
            String teacherName = empName.getText();
            Staff s = StaffController.searchStaffByName(teacherName);
            if (s != null) {
                empNoField.setText(String.valueOf(s.getEmpNo()));
                teacherNameField.setText(s.getTeacherName());
                taughtSubjectField.setText(s.getTaughtSubject());
                dobField.setText(s.getDob());
                genderField.setText(s.getGender());
                emailField.setText(s.getEmail());
                phoneField.setText(s.getPhone());
                addressField.setText(s.getAddress());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Staff Search");
                alert.setHeaderText(null);
                alert.setContentText("Staff not found.");
                alert.showAndWait();

                empNoField.setText(null);
                teacherNameField.setText(null);
                taughtSubjectField.setText(null);
                dobField.setText(null);
                emailField.setText(null);
                genderField.setText(null);
                phoneField.setText(null);
                addressField.setText(null);
                empName.setText(null);
                EmpNo.setText(null);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void searchStaff(ActionEvent event) {
        try {
            int empNo = Integer.parseInt(EmpNo.getText());
            Staff s = StaffController.searchStaff(empNo);
            if (s != null) {
                empNoField.setText(String.valueOf(s.getEmpNo()));
                teacherNameField.setText(s.getTeacherName());
                taughtSubjectField.setText(s.getTaughtSubject());
                dobField.setText(s.getDob());
                genderField.setText(s.getGender());
                emailField.setText(s.getEmail());
                phoneField.setText(s.getPhone());
                addressField.setText(s.getAddress());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Staff Search");
                alert.setHeaderText(null);
                alert.setContentText("Staff not found.");
                alert.showAndWait();

                empNoField.setText(null);
                teacherNameField.setText(null);
                taughtSubjectField.setText(null);
                dobField.setText(null);
                emailField.setText(null);
                genderField.setText(null);
                phoneField.setText(null);
                addressField.setText(null);
                empName.setText(null);
                EmpNo.setText(null);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void deleteStaff(ActionEvent event) {
        try {
            int empNo = Integer.parseInt(empNoField.getText());
            Staff s = new Staff(Integer.parseInt(empNoField.getText()), teacherNameField.getText(), taughtSubjectField.getText() ,dobField.getText(),
                genderField.getText(), emailField.getText(), phoneField.getText(), addressField.getText());
                int deleteStaff = StaffController.deleteStaff(empNo);
                if (deleteStaff > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff " + empNo + " deleted successfully!");
                    alert.showAndWait();

                    empNoField.setText(null);
                    teacherNameField.setText(null);
                    taughtSubjectField.setText(null);
                    dobField.setText(null);
                    emailField.setText(null);
                    genderField.setText(null);
                    phoneField.setText(null);
                    addressField.setText(null);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("There was an error when trying to delete Staff.");
                    alert.showAndWait();
                }
        } catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void update(ActionEvent event) {
        try {

            ValidationController v = new ValidationController();

            if(v.validateEmpty(empNoField)&& v.validateEmpty(teacherNameField)&& v.validateEmpty(taughtSubjectField)&& v.validateEmpty(dobField)
                    && v.validateEmpty(phoneField)&& v.validateDate(dobField)
                    && v.validatePhone(phoneField)&& v.numbersOnly(empNoField)&& v.numbersOnly(phoneField)){


                int empNo = Integer.parseInt(empNoField.getText());
                String teacherName = teacherNameField.getText();
                String taughtSubject = taughtSubjectField.getText();
                String dob = dobField.getText();
                String gender = genderField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();

                Staff s = new Staff(empNo, teacherName, taughtSubject, dob, gender, email, phone, address);
                int i = StaffController.updateStaff(s);
                if (i > 0){

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff information updated successfully!");
                    alert.showAndWait();

                    empNoField.setText(null);
                    teacherNameField.setText(null);
                    taughtSubjectField.setText(null);
                    dobField.setText(null);
                    emailField.setText(null);
                    genderField.setText(null);
                    phoneField.setText(null);
                    addressField.setText(null);

                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("There was an error when trying to update Staff.");
                    alert.showAndWait();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

