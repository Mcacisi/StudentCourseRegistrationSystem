/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mcacisi;

/**
 *
 * @author Mcacisi Sithole
 */
public class Student {
    private String studentNo, lastname, initials, course;
    private int yearOfStudy;
    
    public Student(String studentNo, String lastname, String initials, int yearOfStudy, String course){
        this.studentNo = studentNo;
        this.lastname = lastname;
        this.initials = initials;
        this.yearOfStudy = yearOfStudy;
        this.course = course;
    }

    public String getStudentNo() {
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


    public void setStudentNo(String studentNo) {
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
    
}
