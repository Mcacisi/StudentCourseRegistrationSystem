package mcacisi;

import mcacisi.CustomExceptions.DataStorageException;
import mcacisi.CustomExceptions.NotFoundException;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class StudentDA {
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String user = "root";
    private static final String password = "";
    private static Connection conn;
    private static ArrayList <StudentPD> arrStud = new ArrayList<>();


    static void initialize() throws DataStorageException {
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             conn = DriverManager.getConnection(url,user,password);


             String createDB = "CREATE DATABASE IF NOT EXISTS registeredStudent";

             PreparedStatement ps = conn.prepareStatement(createDB);
             ps.executeUpdate();

             String useDB = "USE registeredStudent";
             ps = conn.prepareStatement(useDB);
             ps.execute();

             String createTable = "CREATE TABLE IF NOT EXISTS tblStudents("+
                                  "student_No INT(9) PRIMARY KEY," +
                                  "lastname VARCHAR(100) NOT NULL," +
                                  "initials VARCHAR(100) NOT NULL,"+
                                  "yearOfStudy INT NOT NULL," +
                                  "course VARCHAR(255) NOT NULL)";


             int row = ps.executeUpdate();
                       if(row == 0){
                           JOptionPane.showMessageDialog(null,"Tables affected: " + row + "\nCheck database Query");

                       }else{
                           JOptionPane.showMessageDialog(null,"Tables affected: " + row + "\nTable created successfully");
                       }


         }catch (SQLException ex){
             throw new DataStorageException("Connection failed:\n"+ex.getMessage());

         }catch (DataStorageException ex){
             JOptionPane.showMessageDialog(null,"Loading class failed:\n" + ex.getMessage());
             return;

         }catch (ClassNotFoundException ex){
             JOptionPane.showMessageDialog(null,"Driver class not found:\n" + ex.getMessage());
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
        try{
            String selectQry = "SELECT * FROM tblStudents";

            PreparedStatement ps = conn.prepareStatement(selectQry);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int stud_No = rs.getInt("student_No");
                String lastname = rs.getString("lastname");
                String initials = rs.getString("initials");
                int yearOfStudy = rs.getInt("yearOfStudy");
                String course = rs.getString("course");

                StudentPD student = new StudentPD(stud_No,lastname,initials,yearOfStudy,course);
                arrStud.add(student);
            }

        } catch (SQLException ex) {
            throw new DataStorageException("Retieving failed:\n"+ ex.getMessage());
        }

         return arrStud;
    }



    static void update(StudentPD stud) throws DataStorageException, NotFoundException {
           try{
               String updateQry = "UPDATE tblStudents SET lastname=?, initials=?, yearOfStudy=?, course=? WHERE student_No=?";

               PreparedStatement ps = conn.prepareStatement(updateQry);
               ps.setString(1,stud.getLastname());
               ps.setString(2,stud.getInitials());
               ps.setInt(3,stud.getYearOfStudy());
               ps.setString(4,stud.getCourse());
               ps.setInt(5,stud.getStudentNo());

               int row = ps.executeUpdate();
                       if(row==0){
                           throw new NotFoundException("Student not found ");

                       }else{
                           JOptionPane.showMessageDialog(null,"Student details updated successfully");
                       }

           } catch (SQLException ex) {
               throw new DataStorageException("Updating Failde:\n" + ex.getMessage());
           }
    }



    static void delete(int student_No) throws DataStorageException,NotFoundException{
          try{
              String deleteQry = "DELETE FROM tblStudents WHERE student_No=?";

              PreparedStatement ps = conn.prepareStatement(deleteQry);
              ps.setInt(1,student_No);

              int row = ps.executeUpdate();
                       if(row == 0){
                           throw new NotFoundException("Student not found");

                       }else{
                           JOptionPane.showMessageDialog(null,"Student Deleted");
                       }

          } catch (SQLException ex) {
              throw new DataStorageException("Deleteing student not successful\n"+ ex.getMessage());
          }
    }




    static StudentPD search(int student_No) throws DataStorageException,NotFoundException {
        StudentPD student = new StudentPD();

        try {
            String searchQry = "SELECT * FROM tblStudents WHERE student_No=? ";
            PreparedStatement ps = conn.prepareStatement(searchQry);
            ps.setInt(1, student_No);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                student.setStudentNo(rs.getInt("student_No"));
                student.setLastname(rs.getString("lastname"));
                student.setInitials(rs.getString("initials"));
                student.setYearOfStudy(rs.getInt("yearOfStudy"));
                student.setCourse(rs.getString("course"));

            } else {
                throw new NotFoundException("Student not found:\n" + student_No + student.getLastname());
            }


        } catch (SQLException ex) {
            throw new RuntimeException("Searching failed:\n" + ex);
        }
        return student;
    }
}

