package sms.dbController;

import sms.db.DBConnection;
import sms.model.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffController {

    public static int AddStaff(Staff staff)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO staff VALUES(?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, staff.getEmpNo());
        stm.setObject(2, staff.getTeacherName());
        stm.setObject(3, staff.getTaughtSubject());
        stm.setObject(4, staff.getDob());
        stm.setObject(5, staff.getGender());
        stm.setObject(6, staff.getEmail());
        stm.setObject(7, staff.getPhone());
        stm.setObject(8, staff.getAddress());

        return  stm.executeUpdate();
    }

    public static Staff searchStaff(Integer empNo) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM staff WHERE empNo = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, empNo);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Staff staff = new Staff(rst.getInt(1),rst.getString(2),rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8));
            return staff;
        }
        return null;
    }

    public static Staff searchStaffByName(String teacherName) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM staff WHERE teacherName LIKE '%"+teacherName+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Staff staff = new Staff(rst.getInt(1),rst.getString(2),rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8));
            return staff;
        }
        return null;
    }

    public static int deleteStaff(Integer empNo) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM staff WHERE empNo ='"+empNo+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        return  stm.executeUpdate();
    }

    public static int updateStaff(Staff staff) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE staff SET empNo= ? ,teacherName= ?, taughtSubject = ?, dob= ? ,gender= ? ,email=? ,phone= ? ,address= ? WHERE empNo= '" +staff.getEmpNo()+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, staff.getEmpNo());
        stm.setObject(2, staff.getTeacherName());
        stm.setObject(3, staff.getTaughtSubject());
        stm.setObject(4, staff.getDob());
        stm.setObject(5, staff.getGender());
        stm.setObject(6, staff.getEmail());
        stm.setObject(7, staff.getPhone());
        stm.setObject(8, staff.getAddress());

        return  stm.executeUpdate();
    }
}
