/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.ui;

import com.sg.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author austinmann
 */
public class ClassRosterView {
    
    private UserIO io;
    
    public ClassRosterView(UserIO io) {
        this.io = io;
    }
        
        public int printMenuAndGetSelection() {
            io.print("Main Menu");
            io.print("1. List Student IDs");
            io.print("2. Create New Student");
            io.print("3. View a Student");
            io.print("4. Remove a Student");
            io.print("5. Exit");
            
            return io.readInt("Please select from the above choices", 1, 5);   
        }
        
        public Student getNewStudentInfo() {
            String studentID = io.readString("Please enter student ID");
            String firstName = io.readString("Please enter student first name");
            String lastName = io.readString("Please enter student last name");
            String cohort = io.readString("Please enter cohort");
            Student currentStudent = new Student(studentID);
            currentStudent.setFirstName(firstName);
            currentStudent.setLastName(lastName);
            currentStudent.setCohort(cohort);
            return currentStudent;
        }
        
        public void displayCreateStudentBanner() {
            io.print("=== Create New Student ===");
        }
        
        public void displayCreateSuccessBanner() {
            io.print("Student successfully created. Please hit enter to continue.");
        }
        
        public void displayStudentList(List<Student> studentList) {
            for (Student currentStudent : studentList) {
                io.print(currentStudent.getStudentID() + ": "
                + currentStudent.getFirstName() + " " 
                + currentStudent.getLastName());  
            }
            io.print("Please hit enter to continue.");
        }
        
        public void displayDisplayAllBanner() {
            io.print("=== Display All Students ===");
        }
        
        public void displayDisplayStudentBanner() {
            io.print("=== Display Student ===");
        }
        
        public String getStudentIDChoice() {
            return io.readString("Please enter the student ID");
        }
        
        public void displayStudent(Student student) {
            if (student != null) {
                io.print(student.getStudentID());
                io.print(student.getFirstName() + " " + student.getLastName());
                io.print(student.getCohort());
                io.print(" ");
            } else {
                io.print("No such student");
            }
            io.print("Please hit enter to continue.");
        }
        
        public void displayRemoveStudentBanner() {
            io.print("=== Remove Student ===");
        }
        
        public void displayRemoveSuccessBanner() {
            io.print("Student sucessfully removed. Please hit enter to continue.");
        }
        
        public void displayExitBanner() {
            io.print("Good Bye!");
        }
        
        public void displayUnknownCommandBanner() {
            io.print("Unknown Command!");
        }
        
        public void displayErrorMessage(String errorMessage) {
            io.print("=== ERROR ===");
            io.print(errorMessage);
        }


}
