package web.app;
import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class moc 
{
    public static Connection goc() 
    {
        Connection conn = null;
           try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:orcl";
             conn = DriverManager.getConnection(url,"harshit","h");
        } catch (Exception ex) 
        {
            ex.printStackTrace();
           }
           if(conn != null)
           {
               System.out.println("conn. created ");
           }
           return conn;
    }
    
    public static void main(String[] args) {
        moc.goc();
        
    }
    
}

