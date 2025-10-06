package mcacisi;

import mcacisi.CustomExceptions.DataStorageException;

import java.sql.Connection;
import java.sql.SQLException;

public class StudentDA {
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String user = "root";
    private static final String password = "";
    private static Connection conn;


    static void initialize() throws DataStorageException {
         try{
             String createDB = "CREATE DATABASE IF NOT EXISTS registeredStudent(" +
                     "student_No VARCHAR";

         }catch (SQLException ex){
             throw new DataStorageException("Connection failed\n"+ex.getMessage());
         }
    }


}
