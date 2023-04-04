package sms.view.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import sms.dbController.YearController;
import sms.dbController.StudentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sms.model.Student;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RegisterStudentController implements Initializable {
    @FXML
    private TextField adNoField;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField yearofstudyField;

    @FXML
    private TextField dobField;

    @FXML
    private JFXRadioButton genderField;

    @FXML
    private ToggleGroup g;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;

    @FXML
    private JFXButton Back;

    @FXML
    private AnchorPane root;



    @Override
    public void initialize(URL location, ResourceBundle resources){

    }

    @FXML
    void Back() {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StudentManagement.fxml")));
            root.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void AddStudent(ActionEvent event) {
        try {

            ValidationController v = new ValidationController();
            if (v.validateEmpty(adNoField) && v.validateEmpty(fullNameField) && v.validateEmpty(yearofstudyField)
                    && v.validateEmpty(dobField) && v.validateEmpty(phoneField) && v.numbersOnly(adNoField)
                    && v.numbersOnly(yearofstudyField) && v.validatePhone(phoneField)) {

                int adNo = Integer.parseInt(adNoField.getText());
                String fullName = fullNameField.getText();
                String yearofstudy = yearofstudyField.getText();
                String dob = dobField.getText();
                RadioButton selectedRadioButton = (RadioButton) g.getSelectedToggle(); //Getting Selected Radio Button
                String gender = selectedRadioButton.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();

                Student s = new Student(adNo, fullName, yearofstudy, dob, gender, phone, address);
                int i = StudentController.AddStudent(s);
                if (i > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Student Registration");
                    alert.setHeaderText(null);
                    alert.setContentText("Student " + adNo + " registered successfully!");
                    alert.showAndWait();

                    adNoField.setText(null);
                    fullNameField.setText(null);
                    yearofstudyField.setText(null);
                    dobField.setText(null);
                    adNoField.setText(null);
                    phoneField.setText(null);
                    fullNameField.setText(null);
                    addressField.setText(null);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Student Registration");
                    alert.setHeaderText(null);
                    alert.setContentText("There was an error when trying to add Student.");
                    alert.showAndWait();
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void reset() {

        adNoField.setText(null);
        fullNameField.setText(null);
        yearofstudyField.setText(null);
        dobField.setText(null);
        adNoField.setText(null);
        phoneField.setText(null);
        fullNameField.setText(null);
        addressField.setText(null);
    }

}



