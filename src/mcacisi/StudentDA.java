package mcacisi;

import mcacisi.CustomExceptions.DataStorageException;
import mcacisi.CustomExceptions.NotFoundException;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDA {
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String user = "root";
    private static final String password = "";
    private static Connection conn;
    private static ArrayList <StudentPD> arrStud = new ArrayList<>();


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
                                  "initials VARCHAR(100) NOT NULL,"+
                                  "yearOfStudy INT NOT NULL," +
                                  "course VARCHAR(255) NOT NULL";


             int row = ps.executeUpdate();
                       if(row == 0){
                           JOptionPane.showMessageDialog(null,"Tables affected: " + row + "\nCheck database Query");

                       }else{
                           JOptionPane.showMessageDialog(null,"Tables affected: " + row + "\nTable created successfully");
                       }


         }catch (SQLException ex){
             throw new DataStorageException("Connection failed:\n"+ex.getMessage());

         }catch (ClassNotFoundException ex){
             JOptionPane.showMessageDialog(null,"Loading class failed:\n" + ex.getMessage());
             return;
         }
    }



    static void add(StudentPD stud) throws DataStorageException{
         try{
              String addQry = "INSERT INTO tblStudents(student_No,lastname,initials,yearOfStudy,course) VALUES(?,?,?,?,?)";

              PreparedStatement ps = conn.prepareStatement(addQry);
              ps.setInt(1,stud.getStudentNo());
              ps.setString(2,stud.getLastname());
              ps.setString(3,stud.getInitials());
              ps.setInt(4,stud.getYearOfStudy());
              ps.setString(5,stud.getCourse());


              int row = ps.executeUpdate();
                       if(row == 0){
                          JOptionPane.showMessageDialog(null,"Tables affected: " + row + "\nCheck database Query");

                       }else{
                          JOptionPane.showMessageDialog(null,"Tables affected: " + row + "\nTable created successfully");
                       }


         }catch (SQLException ex){
             throw new DataStorageException("Adding failed:\n" + ex.getMessage());
         }
    }



    static ArrayList<StudentPD> getAll() throws DataStorageException{
         return arrStud;
    }



    static void update(StudentPD stud) throws DataStorageException, NotFoundException {

    }



    static void delete(StudentPD stud) throws DataStorageException,NotFoundException{

    }



    static void search(StudentPD stud) throws DataStorageException,NotFoundException{

    }

}
