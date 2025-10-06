
package mcacisi;

import java.io.Serializable;

/**
 * THIS IS A STUDENT REGISTRATION SYSTEM WHICH WILL SAVE STUDENT IN A DATABASE
 * USING CRUD METHODS AND A 3-TIER ARCHITECTURE (PDDA CLASSES)
 * @author Mcacisi Sithole
 */


public class StudentPD implements Serializable{
    private String  lastname, initials, course;
    private int studentNo,yearOfStudy;
    
    public StudentPD(){
     studentNo = 0;
     lastname = "";
     initials = "";
     course = "";
     yearOfStudy = 0;
    }


    public StudentPD(int studentNo, String lastname, String initials, int yearOfStudy, String course){
        this.studentNo = studentNo;
        this.lastname = lastname;
        this.initials = initials;
        this.yearOfStudy = yearOfStudy;
        this.course = course;
    }

    
    
    public int getStudentNo() {
        return studentNo;
    }

    public String getLastname() {
        return lastname;
    }

    public String getInitials() {
        return initials;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }
    
    public String getCourse() {
        return course;
    }


    
    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }

    
    
    @Override
    public String toString(){
      return studentNo + "\t"+ lastname + "\t" + initials + "\t" + yearOfStudy + "\t" + course ;
     }


     //INVOKE ALL THE DA METHODS SINCE PD IS THE MIDDLEMAN

    
}
