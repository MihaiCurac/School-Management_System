package sms.view.controller;
import javafx.fxml.FXMLLoader;
import sms.db.DBConnection;
import sms.dbController.SchoolController;
import sms.model.School;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sms.dbController.StudentController;


public class SchoolInfoController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            School s = SchoolController.schoolInfo();
            if (s != null) {
                SchoolNameField.setText(s.getSchoolName());
                SchoolAddressField.setText(s.getSchoolAddress());
                classAvailableField.setText(s.getClassAvailable());
                schoolTypeField.setText(s.getSchoolType());
                postalCodeField.setText(s.getPostalCode());
                dateOfEstdField.setText(s.getDateOfEstd());
                schoolIDField.setText(s.getSchoolID());
                nameOfPrincipalField.setText(s.getNameOfPrincipal());
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("No information about School found.");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SchoolController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private AnchorPane root;

    @FXML
    private TextField SchoolNameField;

    @FXML
    private TextField SchoolAddressField;

    @FXML
    private TextField classAvailableField;

    @FXML
    private TextField schoolTypeField;

    @FXML
    private TextField postalCodeField;

    @FXML
    private JFXButton updateDetails;

    @FXML
    private JFXButton addDetails;

    @FXML
    private TextField dateOfEstdField;

    @FXML
    private TextField schoolIDField;

    @FXML
    private TextField nameOfPrincipalField;

    @FXML
    private JFXButton printDetails;

    @FXML
    private JFXButton Back;

    @FXML
    void Back(ActionEvent event) {

        try {
            AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/MainDashboard.fxml")));
            root.getChildren().setAll(user);
        }catch(IOException e){
            System.out.println(e);
        }

    }

    @FXML
    void addDetails(ActionEvent event) {
        try {

            ValidationController v = new ValidationController();
            if (v.numbersOnly(classAvailableField)&&(v.numbersOnly(postalCodeField))&&v.validateDate(dateOfEstdField)) {

                String SchoolName = SchoolNameField.getText();
                String SchoolAddress = SchoolNameField.getText();
                String classAvailable = classAvailableField.getText();
                String schoolType = schoolTypeField.getText();
                String postalCode = postalCodeField.getText();
                String dateOfEstd = dateOfEstdField.getText();
                String schoolID = schoolIDField.getText();
                String nameOfPrincipal = nameOfPrincipalField.getText();

                School sch = new School(SchoolName, SchoolAddress, classAvailable, schoolType, postalCode, dateOfEstd, schoolID, nameOfPrincipal);
                int i = SchoolController.AddDetails(sch);
                if (i > 0) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("School Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Updated successfully!");
                    alert.showAndWait();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("School Information");
                    alert.setHeaderText(null);
                    alert.setContentText("There was an error when trying to add details.");
                    alert.showAndWait();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void updateDetails(ActionEvent event) {
        try {
            String SchoolName = SchoolNameField.getText();
            String SchoolAddress = SchoolAddressField.getText();
            String classAvailable = classAvailableField.getText();
            String schoolType = schoolTypeField.getText();
            String postalCode = postalCodeField.getText();
            String dateOfEstd = dateOfEstdField.getText();
            String schoolID = schoolIDField.getText();
            String nameOfPrincipal = nameOfPrincipalField.getText();

            School sch = new School(SchoolName,SchoolAddress,classAvailable,schoolType,postalCode,dateOfEstd,schoolID,nameOfPrincipal);
            int i = SchoolController.updateInfo(sch);
            if (i > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("Information updated successfully!");
                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("There was an error when trying to update details.");
                alert.showAndWait();
            }

        }catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(SchoolController.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
}
