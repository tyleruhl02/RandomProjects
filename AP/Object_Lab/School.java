package HighSchool.AP.Object_Lab;

/*
public class School {
    public final String Name;
    private Student[] enrolledStudents;
    private Course[] schoolCourses;

    public School(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public int enrolledStudents() {
        return enrolledStudents.length;
    }

    public Course[] getCourses() {
        return schoolCourses.clone();
    }

    public Student kidWithClassRank(int rank) {

    }
}
*/

import java.util.Arrays;

// Part A4: Nithin, David
public class School {
    final String Name;
    Student[] enrolledStudents;
    Course[] schoolCourses;

    // Maximum of 300 Students per school
    // Maximum of 300 Courses per school
    public School(String name) {
        Name = name;
    }

    // Returns name of school
    public String getName() {
        return Name;
    }

    // Returns number of enrolled students public int enrolledStudents();
    public int enrolledStudents() {
        return enrolledStudents.length;
    }

    /* Returns the array of courses. (Deep copy) */
    public Course[] getCourses() {
        Course[] newCoursesArray = new Course[schoolCourses.length];

        for (int i = 0; i < schoolCourses.length; i++) {
            newCoursesArray[i] = schoolCourses[i];
        }

        return newCoursesArray;
    }

    /* returns Student with specified class rank. Since you have implemented compareTo, * you can use Arrays.sort to sort enrolledStudets.
     */
    public Student kidWithClassRank(int rank) {
        Student[] newStudentArray = new Student[enrolledStudents.length];

        for (int i = 0; i < enrolledStudents.length; i++) {
            newStudentArray[i] = enrolledStudents[i];
        }

        Arrays.sort(newStudentArray);
        return newStudentArray[0];
    }

    /* Adds a student to the school. Returns false if the school is already full or if * Student is already enrolled at that school.
     */
    public boolean addStudent(Student someKid) {
        boolean full = false;
        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i] == null) full = true;
        }

        if (Arrays.asList(enrolledStudents).contains(someKid) || full) return false;

        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i] == null) {
                enrolledStudents[i] = someKid;
                break;
            }
        }

        return true;
    }

    /* Removes a student to the school. Also removes them from all of their courses. */
    public void unenrollStudent(Student someKid) {
        for (int i = 0; i < enrolledStudents.length-1; i++) {
            if (enrolledStudents[i].equals(someKid)) {
                for (int k = 0; k < enrolledStudents[i].schedule.length; k++) {
                    enrolledStudents[i].dropCourse(enrolledStudents[i].schedule[k]);
                }
                for (int j = i; j < enrolledStudents.length-1; j++) {
                    if (enrolledStudents[j] == null) break;
                    enrolledStudents[j] = enrolledStudents[j + 1];
                }
            }
        }

    }

    /* Creates a class.  Returns false if a class with exactly the same specifications
     * have already been made.
     */
    public boolean createClass(String Teacher, String title, boolean honors) {
        Course newCourse = new Course(Teacher, title, honors);

        for (int i = 0; i < schoolCourses.length; i++) {
            if (schoolCourses[i].equals(newCourse)) {
                newCourse = null;
                return false;
            }
        }

        return true;
    }

    public boolean enroll(Student kid, Course someCourse, boolean audited) {
        someCourse.enroll(kid, audited);
        return false;
    }

    public boolean unenroll(Student kid, Course someCourse) {
        someCourse.unenroll(kid);
        return false;
    }
}