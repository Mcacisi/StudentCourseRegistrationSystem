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
    String studentNo, lastname, initials, course;
    int yearOfStudy;
    
    public Student(String studentNo, String lastname, String initials, String course, int yearOfStudy){
        this.studentNo = studentNo;
        this.lastname = lastname;
        this.initials = initials;
        this.course = course;
        this.yearOfStudy = yearOfStudy;
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

    public String getCourse() {
        return course;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
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

    public void setCourse(String course) {
        this.course = course;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
    
    @Override
    public String toString(){
      return studentNo + "\t"+ lastname + "\t" + initials + "\t" + course + "\t" +  yearOfStudy;
     }
    
}
