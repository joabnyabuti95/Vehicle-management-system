/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dislayauthers;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java .sql.SQLException;


/**
 *
 * @author carloz
 */
public class DislayAuthers {
    static final String DATABASE_URL ="jdbc:mysql://localhost/Transport";
    //

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection connection = null;//manages connection
        Statement statement = null;//query statement
        ResultSet resultSet = null;//manages result
        //connect to database books and query database
        try
        {
            //establish connection to database
            connection = DriverManager.getConnection(DATABASE_URL, "carlos","vehicle");
            //create Statement for quering database
            statement = connection.createStatement();
            //query database 
            resultSet = statement.executeQuery("SELECT vehicle_id, no_of seats, FROM  Vehicles");
            
            //process query result
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Authers Table of Transport Database:\n");
            for (int i=1;i<= numberOfColumns;i++)
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            System.out.println();
            
            while (resultSet.next())
            {
                for (int i=1;i<=numberOfColumns;i++)
                    System.out.printf("%-8s\t",resultSet.getObject(i));
                System.out.println();
                
            }
            
        }
        catch( SQLException sqlException)
        {
            sqlException.printStackTrace();
            
                
        // TODO code application logic here
    }//end catch
    
        finally//ensure resultset,statemnet, statement and connection are close;
        {
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
            }//end try
            catch(Exception  exception)
            {
                exception.printStackTrace();
                
            
                
            }
           } 
    }   
}
    

