package mcacisi;

import mcacisi.CustomExceptions.DataStorageException;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDA {
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String user = "root";
    private static final String password = "";
    private static Connection conn;


    static void initialize() throws DataStorageException {
         try{
             Class.forName("com.mysql.cj.Driver");
             conn = DriverManager.getConnection(url,user,password);


             String createDB = "CREATE DATABASE IF NOT EXISTS registeredStudent";

             PreparedStatement ps = conn.prepareStatement(createDB);
             ps.executeUpdate();

             String useDB = "USE registeredStudent";
             ps.execute();

             String createTable = "CREATE TABLE IF NOT EXISTS tblStudents("+
                                  "student_No INT(9) PRIMARY KEY," +
                                  "lastname VARCHAR(100) NOT NULL," +
                                  "initials VARCHAR(100) NOT NULL," +
                                  "course VARCHAR(255) NOT NULL," +
                                  "yearOfStudy INT NOT NULL";


             int row = ps.executeUpdate();
                       if(row == 0){
                           JOptionPane.showMessageDialog(null,"Tables affected: " + row);

                       }else{
                           JOptionPane.showMessageDialog(null,"Tables affected: " + row + "\nTable created successfully");
                       }


         }catch (SQLException ex){
             throw new DataStorageException("Connection failed\n"+ex.getMessage());

         }catch (ClassNotFoundException ex){
             JOptionPane.showMessageDialog(null,"Loading class failed:\n" + ex.getMessage());
             return;
         }
    }


    
    static void add(StudentPD stud) throws DataStorageException{

    }

}
