/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import java.util.Scanner;
/**
 *
 * @author Francesca Drummer (s4) and Anouk Prins (s4858956)
 */
public class Student {

    private static final Scanner scanner = new Scanner(System.in); //makes one scanner for the class
    private String firstName;
    private String secondName;
    private int studentNumber;
         
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //get the size of a student group
        System.out.println("How big is the group of students?");
        int groupSize = scanner.nextInt();
        
        //create a student group with the given size and prints the group
        Student[] group = createGroup(groupSize); 
        System.out.println(printGroup(groupSize, group));
        
        
        while(true) {
        checkGroup(groupSize, group);
        System.out.println(printGroup(groupSize, group));
        }
    }
    
    
    /**
     * constructor for a student
     * @param firstName
     * @param secondName
     * @param studentNumber 
     */
    private Student(String firstName, String secondName, int studentNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.studentNumber = studentNumber;
    }
    
    /**
     * @return String representation of Object student
     */
    public String toString() {
        return this.firstName + " " + this.secondName + ", " +  "s"+this.studentNumber;
    }
    
    /**
     * returns a  group in array shape containing the specified amount of student`
     * @param groupSize - the amount of students in a group
     * @return group of students
     */
    private static Student[] createGroup(int groupSize) {
        Student[] group = new Student[groupSize];
        
        for(int student = 0; student < groupSize; student++) {
            System.out.println("Please enter the first name of student number "+ student);
            String firstName = scanner.next();
            System.out.println("Please enter the second name of student number "+ student);
            String secondName = scanner.next();
            System.out.println("Please enter the student number as integer (without s) of student number "+ student);
            int studentNumber = scanner.nextInt();
            
            //create a new student entry
            Student myStudent = new Student( firstName,  secondName,  studentNumber);
            group[student] = myStudent;
        }
        
        return group;
    }
    
    /**
     * checks student number and if found, changes names
     * @param groupSize
     * @param group 
     */
    private static void checkGroup(int groupSize, Student[] group) {
        System.out.println("If you wish to change a name, enter student number (without s)");
        int studentNumber = scanner.nextInt();
        if(studentNumber<0) {
            System.exit(0); //terminates program
        }
        System.out.println("Please enter the first name of student with studentnumber "+ studentNumber);
        String firstName = scanner.next();
        System.out.println("Please enter the second name of student with studentnumber "+ studentNumber);
        String secondName = scanner.next();
        
        //searches trough group and changes names
        for(int count = 0; count<groupSize; count++) {
            if (studentNumber == group[count].studentNumber){
                group[count].firstName = firstName;
                group[count].secondName = secondName;
            }
            else {
                System.out.println("Error 404, student not found");
            }
        }
    }
    
    /**
     * prints all students in the group
     * @param groupSize
     * @param group
     * @return 
     */
    public static String printGroup(int groupSize, Student[] group) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The group now contains:"+'\n');
        for(int count = 0; count<groupSize; count++) {
            Student myStudent = group[count];
            stringBuilder.append(myStudent.toString()+'\n');
        }
        return stringBuilder.toString();
    }
    
}
