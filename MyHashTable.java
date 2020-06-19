import java.util.*;
import java.io.*;
/**
 * Write a description of class MyHashTable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyHashTable{
    LinkedList<Student>[] arr;
    int totalStudents;
    public MyHashTable(int n){
        this.arr = new LinkedList[n];
        for(int i = 0; i<arr.length; i++){
            arr[i] = new LinkedList<Student>();
        }
        this.totalStudents = 0;
    }

    public boolean insert(Student s){
        if(findStu(s.getID()) != null){
            System.out.println(s.getFirst()+" already here");
            return false;
        }
        int index = hashCode(s.getID());
        arr[index].add(s);
        totalStudents++;
        return true;
    }

    public Student findStu(String LNum){
        int index = hashCode(LNum);
        int x = 0;
        ListIterator<Student> ite = arr[index].listIterator(x);
        while(ite.hasNext()){
            Student temp = ite.next();
            if(temp.getID().equals(LNum)){
                return temp;
            }
        }
        return null;
    }

    public Student remove(String LNum){
        int index = hashCode(LNum);
        int x = 0;
        ListIterator<Student> ite = arr[index].listIterator(x);
        while(ite.hasNext()){
            Student temp = ite.next();
            if(temp.getID().equals(LNum)){
                arr[index].remove(temp);
                totalStudents--;
                return temp;
            }
        }
        return null;
    }

    public int hashCode(String x){
        int hashVal = 0;
        for(int i = 0; i<x.length(); i++){
            String y = x.substring(1,2);
            hashVal += y.charAt(0);
        }
        return hashVal%(this.arr.length);
    }

    public void print(){
        int count = 1;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != null){
                ListIterator<Student> ite = arr[i].listIterator(0);
                while(ite.hasNext()){
                    Student temp = ite.next();
                    System.out.println(temp.getFullName());
                    count++;
                }
            }
        }
        System.out.println("There are a total of "+count+" students");
    }

}
