/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseCatalog;

import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseCatalog {
    private Department department;
    private String lastUpdated;
    private ArrayList<Course> courseList; 

    // Constructor to initialize CourseCatalog with a department
    public CourseCatalog(Department d) {
        this.department = d;
        this.courseList = new ArrayList<>();
    }

    // Method to get the list of courses
    public ArrayList<Course> getCourseList() {
        return courseList;
    }
    
    // Method to add a new course to the catalog
    public Course newCourse(String name, String courseNumber, int credits) {
        Course c = new Course(name, courseNumber, credits);
        courseList.add(c);
        return c;
    }
    
    // Method to retrieve a course by its course number
    public Course getCourseByNumber(String courseNumber) {
        for (Course c : courseList) {
            if (c.getCOurseNumber().equals(courseNumber)) {
                return c;
            }
        }
        return null; // Return null if the course is not found
    }
    
    // Method to browse all courses in the catalog
    public ArrayList<Course> browseCourses() {
        return new ArrayList<>(courseList); // Return a copy to prevent modification
    }
}