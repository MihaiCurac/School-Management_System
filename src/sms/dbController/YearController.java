package sms.dbController;

import sms.db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class YearController {

    public static ArrayList<String> getYears() throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select distinct yearofstudy from students");

        ArrayList<String>yearlist=new ArrayList<>();
        while(rst.next()){
            yearlist.add(rst.getString("yearofstudy"));
        }
        return yearlist;
    }

}
