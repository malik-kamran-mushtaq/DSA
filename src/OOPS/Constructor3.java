/*
 * Copy constructor
 * Deep copy (where the new array is created, therefore changes are not reflected(made in line 18))
 */
package OOPS;
public class A147 {

    public static void main(String args[]){
        Student s1 = new Student();
        s1.name = "Kamran";
        s1.rollno = 123;
        s1.password = "abcd";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;

        Student s2 = new Student(s1);
        s2.password = "xyz";
        s1.marks[2] = 100;
        for(int i=0; i<3; i++){
            System.out.println(s2.marks[i]);
        }

    }
    
}

class Student{
    
    String name;
    int rollno;
    String password;
    int marks[];

    Student(Student s1){
        marks = new int[3];
        this.name = s1.name;
        this.rollno = s1.rollno;
        //this.marks = s1.marks; //shallow copy

        for(int i=0; i<marks.length; i++){  //Deep copy
            this.marks[i] = s1.marks[i];
        }
    }

    //Pramerterized constructor
    Student(String name){
        this.name = name;
        marks = new int[3];
    }

    //Pramerterized constructor
    Student(int rollno){
        this.rollno = rollno;
        marks = new int[3];
    }

    //Non-Pramerterized constructor
    Student(){
        marks = new int[3];
        System.out.println("Constructor is called...");
    }
}

