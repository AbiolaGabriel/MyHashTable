import java.util.*;
import java.io.*;
/**
 * Write a description of class ExperimentController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ExperimentController{
    MyHashTable lafayette;
    String [] arr;
    int numFound;
    public ExperimentController(){
        this.lafayette = null;
    }

    public void run(){
        this.CSVInsertion();
        this.CSVInsertion2();
        this.CSVInsertion3();
        this.CSVInsertion4();
    }

    public long timetoInsert(int numOfItems, int hashTableSize){
        this.lafayette = new MyHashTable(hashTableSize);
        this.arr = new String[numOfItems];
        Student student = null;
        Scanner s1 = null;
        Scanner s2 = null;
        Scanner s3 = null;
        String line = "";
        if(numOfItems > 142857){
            numOfItems = 142857;
        }
        long startTime = System.currentTimeMillis();
        try{
            //System.out.println("Got here - inputing customers into hashtable");
            s1 = new Scanner(new FileReader("Lafayette.csv"));
            String ID = "";
            String Last = "";
            String First = "";
            int count = 1;
            while(count != numOfItems){
                line = s1.nextLine();
                //System.out.println("Taking data from line "+count);
                s2 = new Scanner(line);
                line = line.replaceAll(",", " ");
                s2 = new Scanner(line);
                while(s2.hasNext()){
                    ID = s2.next();
                    Last = s2.next();
                    First = s2.next();
                    //System.out.println("Got here");
                    student = new Student(ID,Last,First);
                }
                this.lafayette.insert(student);
                count++;
            }

        }
        catch(Exception e){
            System.err.println(e);
            System.out.println("Error");
        }
        long endTime = System.currentTimeMillis();
        try{
            s3 = new Scanner(new FileReader("LNumberIDs.csv"));
            int count = 0;
            while(count < numOfItems){
                this.arr[count]= s3.nextLine();
                count++;
            }
        }
        catch(Exception e){
            System.err.println(e);
            System.out.println("Error");
        }
        return (endTime - startTime);
    }

    public long timeFind(String[] IDs, MyHashTable h){
        int numFound = 0;
        long startTime = System.currentTimeMillis();
        for(int i = 0; i<IDs.length; i++){
            if(h.findStu(IDs[i]) != null){
                numFound++;
            }
        }
        long endTime = System.currentTimeMillis();
        this.numFound = numFound;
        return (endTime - startTime);
    }

    public void CSVInsertion(){
        int element = 100;
        int hashsize = 5;
        int elementcount = 1;
        int hashcount = 1;
        try{
            PrintWriter results = new PrintWriter("HashSize5.csv");
            results.println("NumberofElements,SizeofHashTable,InsertionTime,SearchTime");
            while(element <= 1000){
                for(int i = 0; i<10; i++){
                    long time = this.timetoInsert(element,hashsize);
                    long searchTime = this.timeFind(this.arr, this.lafayette);
                    results.println(element+","+hashsize+","+time+","+searchTime);
                }
                element = element + 100;
            }
            results.close();
        }
        catch(Exception e){
            System.err.println(e + " "+"Could not be printed");
        }
    }

    public void CSVInsertion2(){
        int element = 100;
        int hashsize = 10;
        int elementcount = 1;
        int hashcount = 1;
        try{
            PrintWriter results = new PrintWriter("HashSize10.csv");
            results.println("NumberofElements,SizeofHashTable,InsertionTime,SearchTime");
            while(element <= 1000){
                for(int i = 0; i<10; i++){
                    long time = this.timetoInsert(element,hashsize);
                    long searchTime = this.timeFind(this.arr, this.lafayette);
                    results.println(element+","+hashsize+","+time+","+searchTime);
                }
                element = element + 100;
            }
            results.close();
        }
        catch(Exception e){
            System.err.println(e + " "+"Could not be printed");
        }
    }

    public void CSVInsertion3(){
        int element = 100;
        int hashsize = 15;
        int elementcount = 1;
        int hashcount = 1;
        try{
            PrintWriter results = new PrintWriter("HashSize15.csv");
            results.println("NumberofElements,SizeofHashTable,InsertionTime,SearchTime");
            while(element <= 1000){
                for(int i = 0; i<10; i++){
                    long time = this.timetoInsert(element,hashsize);
                    long searchTime = this.timeFind(this.arr, this.lafayette);
                    results.println(element+","+hashsize+","+time+","+searchTime);
                }
                element = element + 100;
            }
            results.close();
        }
        catch(Exception e){
            System.err.println(e + " "+"Could not be printed");
        }
    }

    public void CSVInsertion4(){
        int element = 100;
        int hashsize = 20;
        int elementcount = 1;
        int hashcount = 1;
        try{
            PrintWriter results = new PrintWriter("HashSize20.csv");
            results.println("NumberofElements,SizeofHashTable,InsertionTime,SearchTime");
            while(element <= 1000){
                for(int i = 0; i<10; i++){
                    long time = this.timetoInsert(element,hashsize);
                    long searchTime = this.timeFind(this.arr, this.lafayette);
                    results.println(element+","+hashsize+","+time+","+searchTime);
                }
                element = element + 100;
            }
            results.close();
        }
        catch(Exception e){
            System.err.println(e + " "+"Could not be printed");
        }
    }
    

    public static void main(String [] args){
        ExperimentController one = new ExperimentController();
        one.run();
    }

}
