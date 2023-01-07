package HighSchool.AP.Object_Lab;

/*public class Course {
    private String courseTitle;
    private String teacher;
    private Student[] enrolledStudents;
    private Grade[] Grades;
    private boolean honors;

    public Course(String teacher, String title, boolean honors) {
        courseTitle = title;
        this.teacher = teacher;
        this.honors = honors;
    }

    public String courseTitle() {
        return courseTitle;
    }

    public String courseTeacher() {
        return teacher;
    }

    public Grade gradeOf(Student someStudent) {
        int index = 0;
        for (int i = 0; i < enrolledStudents.length; i++) {
            if(enrolledStudents[i].equals(someStudent)) {
                index = i;
                break;
            }
        }
        return new Grade(true, true, Grades[index].gradeValue(), this);
    }

    public int numberEnrolled() {
        return enrolledStudents.length;
    }

    public Student[] enrolledStudents() {
        return enrolledStudents.clone();
    }

    public Student topStudent() {
        double topGPA = 0;
        int index = 0;
        for (int i = 0; i < enrolledStudents.length; i++) {
            if(enrolledStudents[i].getGPA() > topGPA) {
                topGPA = enrolledStudents[i].getGPA();
                index = i;
            }
        }
        return enrolledStudents[index];
    }

    public boolean enroll(Student someStudent, boolean audited) {
        if(enrolledStudents.length >= 20) {
            return false;
        }
        else {
            boolean successful = someStudent.addCourse(this);
            if(successful) {
                Student[] newArray = new Student[enrolledStudents.length+1];
                Grade[] newArray2 = new Grade[enrolledStudents.length+1];
                for (int i = 0; i < enrolledStudents.length; i++) {
                    newArray[i] = enrolledStudents[i];
                    newArray2[i] = Grades[i];
                }
                newArray[newArray.length-1] = someStudent;
                newArray2[newArray2.length-1] = gradeOf(someStudent);
                enrolledStudents = newArray.clone();
                Grades = newArray2.clone();
                return true;
            }
            return false;
        }
    }

    public void unenroll(Student someStudent) {
        someStudent.dropCourse(this);
    }
}
*/

import java.util.ArrayList;
import java.util.Arrays;

// Part A3: Nithin, David
public class Course {
    String courseTitle;
    String teacher;
    Student[] enrolledStudents;
    Grade[] Grades; // Must correspond 1-1 with enrolledStudents. boolean honors;
    boolean honors;

    public Course(String Teacher, String title, boolean honors) {
        this.courseTitle = title;
        this.teacher = Teacher;
        this.honors = honors;
        enrolledStudents = new Student[0];
        Grades = new Grade[0];
    }

    // Accessors
    public String courseTitle() {
        return courseTitle;
    }

    public String courseTeacher() {
        return teacher;
    }

    // Why is it named “gradeOf”, not “getGrade”?
    public Grade gradeOf(Student someStudent) {
        //System.out.println(enrolledStudents.length);
        //System.out.println(enrolledStudents[0].name);
        //System.out.println(someStudent.name);
        for (int i=0; i<enrolledStudents.length; i++) {
            if (enrolledStudents[i].equals(someStudent))
            {
                return Grades[i];
            }
        }
        /*System.out.println();
        System.out.println(courseTitle);
        System.out.println();
        for (int i = 0; i < someStudent.schedule.length; i++) {
            System.out.println(someStudent.schedule[i].courseTitle);
        }
        System.out.println();*/
        return null;
    }

    public int numberEnrolled() {
        return enrolledStudents.length;
    }

    // returns a deep copy of the enrolled students
    public Student[] enrolledStudents() {
        Student[] ret = new Student[enrolledStudents.length];
        for (int i=0; i<enrolledStudents.length; i++) {
            ret[i] = enrolledStudents[i];
        }
        return ret;
    }

    // returns the top student in this course. (Can arbitrarily choose between a tie) public Student topStudent();
    public Student topStudent() {
        Student best = enrolledStudents[0];
        for (int i=1; i<enrolledStudents.length; i++) {
            if (best.compareTo(enrolledStudents[i])==-1) {
                best = enrolledStudents[i];
            }
        }
        return best;
    }

    public void setGrade(Student someStudent, int grade) {
        for (int i=0; i<enrolledStudents.length; i++) {
            if (enrolledStudents[i].equals(someStudent)) {
                Grades[i] = new Grade(honors, Grades[i].audited(), grade, this);
            }
        }
    }

    /* Enrolls Student and returns true if successful.
     * Returns false if: course would give Student more than 10 classes, student is already * enrolled, or if enrollment would cause more than 20 students to be in the course. */
    public boolean enroll(Student someStudent, boolean audited) {
        if (someStudent.schedule.length == 10 || enrolledStudents.length == 20) {
            return false;
        }
        for (int i=0; i<enrolledStudents.length; i++) {
            if (enrolledStudents[i].equals(someStudent)) {
                return false;
            }
        }
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Grade> grades = new ArrayList<Grade>();
        for (int i=0; i<enrolledStudents.length; i++) {
            students.add(enrolledStudents[i]);
            grades.add(Grades[i]);
        }
        students.add(someStudent);
        enrolledStudents = Arrays.asList(students.toArray()).toArray(new Student[students.toArray().length]);
        grades.add(new Grade(honors, audited, 1000, this));
        Grades = Arrays.asList(grades.toArray()).toArray(new Grade[grades.toArray().length]);
        return true;
    }

    public void unenroll(Student someStudent) {
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Grade> grades = new ArrayList<Grade>();
        for (int i=0; i<enrolledStudents.length; i++) {
            if (!enrolledStudents[i].equals(someStudent)) {
                students.add(enrolledStudents[i]);
                grades.add(Grades[i]);
            }
        }
        enrolledStudents = Arrays.asList(students.toArray()).toArray(new Student[students.toArray().length]);
        Grades = Arrays.asList(grades.toArray()).toArray(new Grade[grades.toArray().length]);

    }
}