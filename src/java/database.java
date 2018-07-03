/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author shubham
 */
public class database {
        
public static Connection getconnection(){

    Connection conn = null;
    
    try{

        Class.forName("java.sql.Driver");

       conn = DriverManager.getConnection("jdbc:mysql://localhost/businesstrip","root","shubham3597");

    }

    catch(Exception e){
    

    }
    
    
    return conn;

}
    
}
