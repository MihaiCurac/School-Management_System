package sms.dbController;

import sms.db.DBConnection;
import sms.model.School;
import sms.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolController {

    public static School schoolInfo() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM schoolinfo";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            School s=new School(rst.getString("SchoolName"),rst.getString("SchoolAddress"),rst.getString("classAvailable"),
                    rst.getString("schoolType"), rst.getString("postalCode"), rst.getString("dateOfEstd"),
                    rst.getString("schoolID"), rst.getString("nameOfPrincipal"));

            return s;
        }
        return null;
    }

    public static int AddDetails(School school)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO schoolinfo VALUES(?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, school.getSchoolName());
        stm.setObject(2, school.getSchoolAddress());
        stm.setObject(3, school.getClassAvailable());
        stm.setObject(4, school.getSchoolType());
        stm.setObject(5, school.getPostalCode());
        stm.setObject(6, school.getDateOfEstd());
        stm.setObject(7, school.getSchoolID());
        stm.setObject(8, school.getNameOfPrincipal());


        return  stm.executeUpdate();
    }

    public static int updateInfo(School school) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE schoolinfo SET SchoolName= ? ,SchoolAddress= ? " +
                ",classAvailable= ? ,schoolType= ? ,postalCode= ? " +
                ",dateOfEstd=? ,schoolID=?" + ",nameOfPrincipal=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, school.getSchoolName());
        stm.setObject(2, school.getSchoolAddress());
        stm.setObject(3, school.getClassAvailable());
        stm.setObject(4, school.getSchoolType());
        stm.setObject(5, school.getPostalCode());
        stm.setObject(6, school.getDateOfEstd());
        stm.setObject(7, school.getSchoolID());
        stm.setObject(8, school.getNameOfPrincipal());


        return  stm.executeUpdate();
    }
}
