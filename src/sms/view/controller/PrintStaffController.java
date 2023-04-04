package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sms.db.DBConnection;
import sms.tableModel.StaffTableModel;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PrintStaffController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton generate;

    @FXML
    private JFXButton Back;

    @FXML
    private TableView<StaffTableModel> staffTable;

    @FXML
    private TableColumn<StaffTableModel, String> EmpNoColumn;

    @FXML
    private TableColumn<StaffTableModel, String> NameColumn;

    @FXML
    private TableColumn<StaffTableModel, String> taughtSubjectColumn;

    @FXML
    private TableColumn<StaffTableModel, String> dobColumn;

    @FXML
    private TableColumn<StaffTableModel, String> genderColumn;

    @FXML
    private TableColumn<StaffTableModel, String> emailColumn;

    @FXML
    private TableColumn<StaffTableModel, String> phoneColumn;

    @FXML
    private TableColumn<StaffTableModel, String> addressColumn;

    ObservableList<StaffTableModel> staffList = FXCollections.observableArrayList();

    @FXML
    void Back() {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StaffManagement.fxml")));
            root.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void generate() {

        try{
            staffTable.getItems().clear();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "select * from staff";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {

                    StaffTableModel staff = new StaffTableModel(rs.getInt("empNo"),rs.getString("teacherName"),
                    rs.getString("taughtSubject"), rs.getString("dob"),rs.getString("gender"),
                    rs.getString("email"), rs.getString("phone"),rs.getString("address"));
                    staffList.add(staff);
                }

            EmpNoColumn.setCellValueFactory(new PropertyValueFactory<>("empNo"));
            NameColumn.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
            taughtSubjectColumn.setCellValueFactory(new PropertyValueFactory<>("taughtSubject"));
            dobColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
            phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
            addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

            staffTable.setItems(staffList);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
