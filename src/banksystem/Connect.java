package banksystem;


import java.sql.*;

public class Connect {
    Connection c;
    Statement s;
    public Connect(){
        try {
//            Class.forName(com.mysql.cj.jdbc.Driver);
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Jeena@2004");
            s=c.createStatement();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}

