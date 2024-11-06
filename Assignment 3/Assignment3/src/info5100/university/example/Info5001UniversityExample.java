/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author kal bugrara
 */

public class Info5001UniversityExample {

    public static void main(String[] args) {
        // Initialize the Department
        Department department = new Department("Management Information Systems");
        
        

        // Manage Course Catalog
        CourseCatalog courseCatalog = department.getCourseCatalog();
        Course coreCourse = courseCatalog.newCourse("Application Engineering", "INFO5100", 4);
        Course elective1 = courseCatalog.newCourse("Data Science", "INFO6200", 4);
        Course elective2 = courseCatalog.newCourse("Machine Learning", "INFO6300", 4);
        Course elective3 = courseCatalog.newCourse("Web Design", "INFO6100", 4);
        Course elective4 = courseCatalog.newCourse("Database Systems", "INFO6500", 4);
        Course elective5 = courseCatalog.newCourse("Mobile App Development", "INFO6600", 4);
        
        List<Course> electiveCourses = new ArrayList<>();
        electiveCourses.add(elective1); // Assuming elective1 is already created
        electiveCourses.add(courseCatalog.newCourse("Data Science", "INFO6200", 4));
        electiveCourses.add(courseCatalog.newCourse("Machine Learning", "INFO6300", 4));
        electiveCourses.add(courseCatalog.newCourse("Database Systems", "INFO6500", 4));
        electiveCourses.add(courseCatalog.newCourse("Web Development", "INFO6100", 4));
        electiveCourses.add(courseCatalog.newCourse("Mobile App Development", "INFO6600", 4));


        // Faculty Directory Management
        FacultyDirectory facultyDirectory = department.getFacultyDirectory();
        FacultyProfile faculty1 = facultyDirectory.newFacultyProfile(new Person("Prof. John Smith"));
        FacultyProfile faculty2 = facultyDirectory.newFacultyProfile(new Person("Prof. Lisa Brown"));
        FacultyProfile faculty3 = facultyDirectory.newFacultyProfile(new Person("Prof. James White"));
        FacultyProfile faculty4 = facultyDirectory.newFacultyProfile(new Person("Prof. Emily Green"));
        FacultyProfile faculty5 = facultyDirectory.newFacultyProfile(new Person("Prof. Sarah Blue"));

        // Course Schedule Management for Fall 2023 Semester
        CourseSchedule courseSchedule = department.newCourseSchedule("Fall2023");
        createCourseOffers(courseSchedule, coreCourse, elective1, elective2, elective3, elective4, elective5, faculty1, faculty2, faculty3, faculty4, faculty5);

        // Student Directory and Registration
        Map<String, StudentProfile> students = registerStudents(department, courseSchedule, coreCourse, electiveCourses);
        // Set Faculty Ratings
        setFacultyRatings(courseSchedule);

        // Generate Semester Report
        generateSemesterReport(students, courseSchedule);

        // Calculate and display total department revenue
        int totalRevenue = department.calculateRevenuesBySemester("Fall2023");
        System.out.println("Total Department Revenue for Fall 2023: $" + totalRevenue);
    }

    private static void createCourseOffers(CourseSchedule courseSchedule, Course coreCourse,
                                            Course elective1, Course elective2, Course elective3,
                                            Course elective4, Course elective5,
                                            FacultyProfile faculty1, FacultyProfile faculty2,
                                            FacultyProfile faculty3, FacultyProfile faculty4,
                                            FacultyProfile faculty5) {
        // Create course offers and assign faculty members
        CourseOffer offerCore = courseSchedule.newCourseOffer(coreCourse.getCOurseNumber());
        offerCore.AssignAsTeacher(faculty1);
        offerCore.generatSeats(20); // Generate 20 seats for the core course

        CourseOffer offerElective1 = courseSchedule.newCourseOffer(elective1.getCOurseNumber());
        offerElective1.AssignAsTeacher(faculty2);
        offerElective1.generatSeats(20); // Generate 20 seats for the elective course

        CourseOffer offerElective2 = courseSchedule.newCourseOffer(elective2.getCOurseNumber());
        offerElective2.AssignAsTeacher(faculty3);
        offerElective2.generatSeats(20); // Generate 20 seats for the elective course

        CourseOffer offerElective3 = courseSchedule.newCourseOffer(elective3.getCOurseNumber());
        offerElective3.AssignAsTeacher(faculty4);
        offerElective3.generatSeats(20); // Generate 20 seats for the elective course

        CourseOffer offerElective4 = courseSchedule.newCourseOffer(elective4.getCOurseNumber());
        offerElective4.AssignAsTeacher(faculty5);
        offerElective4.generatSeats(20); // Generate 20 seats for the elective course

        CourseOffer offerElective5 = courseSchedule.newCourseOffer(elective5.getCOurseNumber());
        offerElective5.AssignAsTeacher(faculty1); // Assign the same faculty for demonstration
        offerElective5.generatSeats(20); // Generate 20 seats for the elective course

        // Add course offers to the course schedule
        courseSchedule.addCourseOffer(offerCore);
        courseSchedule.addCourseOffer(offerElective1);
        courseSchedule.addCourseOffer(offerElective2);
        courseSchedule.addCourseOffer(offerElective3);
        courseSchedule.addCourseOffer(offerElective4);
        courseSchedule.addCourseOffer(offerElective5);
    }

    private static Map<String, StudentProfile> registerStudents(Department department, CourseSchedule courseSchedule, 
                                                            Course coreCourse, List<Course> electiveCourses) {
    PersonDirectory personDirectory = department.getPersonDirectory();
    StudentDirectory studentDirectory = department.getStudentDirectory();
    Map<String, StudentProfile> students = new HashMap<>();

    for (int i = 1; i <= 10; i++) {
        Person person = personDirectory.newPerson("01123" + i);
        StudentProfile student = studentDirectory.newStudentProfile(person);
        students.put("Student" + i, student);

        // Course load for Fall 2023 semester
        CourseLoad courseLoad = student.newCourseLoad("Fall2024");
        
        // Register for the core course
        registerForCourse(courseLoad, courseSchedule, coreCourse);

        // Register for one random elective course
        Course selectedElective = electiveCourses.get(i % electiveCourses.size());
        registerForCourse(courseLoad, courseSchedule, selectedElective);
    }
    return students;
}

private static void registerForCourse(CourseLoad courseLoad, CourseSchedule courseSchedule, Course course) {
    CourseOffer courseOffer = courseSchedule.getCourseOfferByNumber(course.getCOurseNumber());
    if (courseOffer != null) {
        courseLoad.newSeatAssignment(courseOffer);
    } else {
        System.out.println("Elective course offer not found for: " + course.getCOurseNumber());
    }
}
    
    private static void setFacultyRatings(CourseSchedule courseSchedule) {
        CourseOffer[] courseOffers = courseSchedule.getAllCourseOffers();

        // Debugging information
        System.out.println("Total Course Offers: " + courseOffers.length);

        // Set random faculty ratings for demonstration
        for (CourseOffer courseOffer : courseOffers) {
            if (courseOffer.getFacultyProfile() != null) {
                FacultyAssignment assignment = courseOffer.getFacultyProfile().getFacultyAssignment();
                if (assignment != null) {
                    assignment.setProfRating(3.0 + (Math.random() * 2)); // Random rating between 3.0 and 5.0
                }
            }
        }
    }

    private static void generateSemesterReport(Map<String, StudentProfile> students, CourseSchedule courseSchedule) {
    System.out.println("=== Fall 2023 Semester Report ===");
    
    for (StudentProfile student : students.values()) {
        System.out.println("\n-------------------------------------");
        System.out.println("Student ID: " + student.getPerson().getPersonId());
        System.out.println("Courses Registered:");
        
        CourseLoad courseLoad = student.getCourseLoadBySemester("Fall2023");
        double totalCredits = 0.0;
        double totalGradePoints = 0.0;
        
        // Check if the student has a course load for the semester
        if (courseLoad != null) {
            for (CourseOffer courseOffer : courseSchedule.getAllCourseOffers()) {
                // Verify if the student is registered for this course
                if (courseLoad.isRegisteredForCourse(courseOffer)) {
                    // Display course details
                    System.out.println(" - Course: " + courseOffer.getSubjectCourse().getCourseName());
                    System.out.println("   Course Number: " + courseOffer.getSubjectCourse().getCOurseNumber());
                    System.out.println("   Faculty: " + (courseOffer.getFacultyProfile() != null ? 
                                         courseOffer.getFacultyProfile() : "N/A"));
                    System.out.println("   Credits: " + courseOffer.getSubjectCourse().getCredits());

                    // Simulate grade assignment
                    double grade = 1.0 + (Math.random() * 3); // Random grade between 1.0 and 4.0
                    System.out.println("   Grade: " + String.format("%.2f", grade));
                    
                    // Update total credits and grade points
                    totalCredits += courseOffer.getSubjectCourse().getCredits();
                    totalGradePoints += grade * courseOffer.getSubjectCourse().getCredits();
                }
            }
            
            // Calculate and display GPA
            double gpa = totalCredits > 0 ? totalGradePoints / totalCredits : 0.0;
            System.out.println("Total Credits: " + totalCredits);
            System.out.println("GPA: " + String.format("%.2f", gpa));
        } else {
            System.out.println("No courses registered for this semester.");
        }
    }
    System.out.println("-------------------------------------");
}
}