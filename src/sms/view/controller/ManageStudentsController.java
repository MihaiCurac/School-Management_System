package sms.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import sms.db.DBConnection;
import sms.dbController.StudentController;
import sms.model.Student;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ManageStudentsController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private AnchorPane manageStudents;

    @FXML
    private TextField AdNo;

    @FXML
    private TextField adNoField;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField yearofstudyField;

    @FXML
    private TextField dobField;

    @FXML
    private TextField genderField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField AdNo1;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton searchStudent;

    @FXML
    private JFXButton btnShowAll;

    @FXML
    private JFXButton Back;

    @FXML
    void setbtnShowAll(ActionEvent event) {
        try {
            AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/PrintStudents.fxml")));
            manageStudents.getChildren().setAll(user);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void Back(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StudentManagement.fxml")));
            manageStudents.getChildren().setAll(studentMgmt);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void btnDelete(ActionEvent event) {
        try {
            String adNo = adNoField.getText();
            Student s = new Student(Integer.parseInt(adNoField.getText()), fullNameField.getText(), yearofstudyField.getText(), dobField.getText(),
                    genderField.getText(), phoneField.getText(), addressField.getText());
            int deleteStudent = StudentController.deleteStudent(adNo);
            if (deleteStudent > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Delete Student");
                alert.setHeaderText(null);
                alert.setContentText("Student " + adNo + " has been deleted successfully!");
                alert.showAndWait();

                AdNo.setText(null);
                adNoField.setText(null);
                fullNameField.setText(null);
                yearofstudyField.setText(null);
                dobField.setText(null);
                genderField.setText(null);
                phoneField.setText(null);
                addressField.setText(null);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Delete Student");
                alert.setHeaderText(null);
                alert.setContentText("There was an error when trying to delete Student.");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void btnUpdate(ActionEvent event) throws SQLException {
        try {

            ValidationController v = new ValidationController();
            if (v.numbersOnly(adNoField) && v.validatePhone(phoneField) && v.validateDate(dobField)) {
                int adNo = Integer.parseInt(adNoField.getText());
                String fullName = fullNameField.getText();
                String yearofstudy = yearofstudyField.getText();
                String dob = dobField.getText();
                String gender = genderField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();

                Student s = new Student(adNo, fullName, yearofstudy, dob, gender, phone, address);
                int i = StudentController.updateStudent(s);
                if (i > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Student Management");
                    alert.setHeaderText(null);
                    alert.setContentText("Student " + adNo + " updated successfully!");
                    alert.showAndWait();

                    AdNo.setText(null);
                    adNoField.setText(null);
                    fullNameField.setText(null);
                    yearofstudyField.setText(null);
                    dobField.setText(null);
                    genderField.setText(null);
                    phoneField.setText(null);
                    addressField.setText(null);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Student Management");
                    alert.setHeaderText(null);
                    alert.setContentText("There was an error when trying to update Student.");
                    alert.showAndWait();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void searchStudent(ActionEvent event) {
        try {
            int adNo = Integer.parseInt(AdNo.getText());
            Student s = StudentController.searchStudent(adNo);
            if (s != null) {
                adNoField.setText(String.valueOf(s.getAdNo()));
                fullNameField.setText(s.getFullName());
                yearofstudyField.setText(s.getyearofstudy());
                dobField.setText(s.getDob());
                genderField.setText(s.getGender());
                phoneField.setText(s.getPhone());
                addressField.setText(s.getAddress());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Student Search");
                alert.setHeaderText(null);
                alert.setContentText("Student not found!");
                alert.showAndWait();

                AdNo.setText(null);
                adNoField.setText(null);
                fullNameField.setText(null);
                yearofstudyField.setText(null);
                dobField.setText(null);
                genderField.setText(null);
                phoneField.setText(null);
                addressField.setText(null);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}



