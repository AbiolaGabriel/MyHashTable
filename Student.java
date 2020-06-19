import java.util.*;
import java.io.*;
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student{
    private String firstName;
    private String lastName;
    private String studentID;

    public Student(String id,String last,String first){
        this.firstName = first;
        this.lastName = last;
        this.studentID = id;
    }

    public void setFirst(String x){
        this.firstName = x;
    }

    public void setLast(String x){
        this.lastName = x;
    }

    public void setID(String x){
        this.studentID = x;
    }

    public String getFirst(){
        return this.firstName;
    }

    public String getLast(){
        return this.lastName;
    }
    
    public String getFullName(){
        String full = this.firstName+" "+this.lastName;
        return full;
    }

    public String getID(){
        return this.studentID;
    }

}
