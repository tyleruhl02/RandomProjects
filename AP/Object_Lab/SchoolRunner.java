package HighSchool.AP.Object_Lab;

// Part A5: Aidan Parkhurst, Patrick Hajdukiewicz
public class SchoolRunner {
    //double to make percentages easier
    private static final double NUM_TESTS = 20;
    private static double totalTests = 0;
    private static int testsPassed;
    //https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static String handleResult(boolean passed) {
        if(passed)
            testsPassed++;
        totalTests++;
        return passed ? ANSI_GREEN + "PASSED" + ANSI_RESET : ANSI_RED + "FAILED" + ANSI_RESET;
    }

    //4 Total Tests
    private static void testGrade() {
        try {
            /*----------GRADE TESTS----------*/
            System.out.println(ANSI_PURPLE + "-- Testing Grade --" + ANSI_RESET);
            Course blank = new Course("N/A","WHATEVER", true);

            //Constructor tests
            Grade constructed = new Grade(false, true, 85, blank);
            boolean gradeConstruct = (constructed.audited() && !constructed.honors() && constructed.gradeValue() == 85);
            System.out.printf("TESTING: Grade Constructor: %s\n", handleResult(gradeConstruct));

            Grade capped = new Grade(false, true, 9999999, blank);
            Grade min = new Grade(false, true, -10, blank);
            boolean gradeCapped = (capped.audited() && !capped.honors() && capped.gradeValue() == 1000 && min.audited()
                    && !min.honors() && min.gradeValue() == 0);
            System.out.printf("TESTING: Grade Constructor Limits: %s\n", handleResult(gradeCapped));

            //Honors tests
            Grade honorCalc = new Grade(true, true, 85, blank);
            boolean gradeHonor = (honorCalc.honors() && honorCalc.gradeValue() == (int)(85*1.05));
            System.out.printf("TESTING: Honors Grade Correction: %s" + ANSI_RESET + "\n", handleResult(gradeHonor));

            Grade honorRound = new Grade(true, true, 10, blank);
            boolean gradeRounding = (honorRound.honors() && honorRound.gradeValue() == 11);
            System.out.printf("TESTING: Honors Grade Rounding: %s" + ANSI_RESET + "\n", handleResult(gradeRounding));
        } catch (Exception e) {
            System.out.println(ANSI_RED + "ERROR WHILE TESTING GRADE; CANNOT CONTINUE" + ANSI_RESET);
        }
    }

    //6 total tests
    private static void testStudent() {
        try {
            /*----------STUDENT TESTS----------*/
            System.out.println(ANSI_PURPLE + "-- Testing Student --" + ANSI_RESET);
            School aSchool = new School("Top School");

            //Constructor tests
            Student studentConstructed = new Student("JJ", 2002, aSchool);
            boolean studentConstruct = (studentConstructed.Name.equals("JJ") && studentConstructed.getGradYear() == 2002
                    && studentConstructed.getAcademy().equals(aSchool));
            System.out.printf("TESTING: Student Constructor: %s\n", handleResult(studentConstruct));

            //Handling course tests
            Student takesCourses = new Student("Gotta Learn", 2002, aSchool);
            int preCourses = takesCourses.schedule.length;
            Course named1 = new Course("adsf", "Tdafds", true);
            Course named2 = new Course("adsf", "Tdafds", true);
            takesCourses.addCourse(named1);
            takesCourses.addCourse(named2);
            for(int i = 0; i < 8; i++) {
                Course c = new Course("","" + i,false);
                takesCourses.addCourse(c);
            }
            int postCourses = takesCourses.schedule.length;
            boolean coursesAdded = (preCourses == 0 && postCourses == 10);
            System.out.printf("TESTING: Adding Courses to Student: %s\n", handleResult(coursesAdded));

            Course overLimit = new Course("This","Is over the limit", true);
            boolean coursesCapped = !takesCourses.addCourse(overLimit);
            System.out.printf("TESTING: Course Count Capped by Student: %s\n", handleResult(coursesCapped));

            boolean coursesRemoved = takesCourses.dropCourse(named1) && takesCourses.schedule.length == 9;
            System.out.printf("TESTING: Course Removed from Student: %s\n", handleResult(coursesRemoved));


            //Grade tests
            takesCourses.addCourse(named1);
            named1.setGrade(takesCourses, 100);
            named2.setGrade(takesCourses, 100);
            boolean goodGPACorrect = takesCourses.getGPA() == 4.0;
            named1.setGrade(takesCourses, 0);
            named2.setGrade(takesCourses, 0);
            boolean badGPACorrect = takesCourses.getGPA() == 0.0;
            System.out.printf("TESTING: GPA Correct: %s\n", handleResult(goodGPACorrect && badGPACorrect));

            Student takesSameCourses = new Student("Quickly", 2002, aSchool);
            takesSameCourses.addCourse(named1);
            takesSameCourses.addCourse(named2);
            named1.setGrade(takesSameCourses,100);
            named2.setGrade(takesSameCourses,100);
            boolean compareCorrect = takesSameCourses.compareTo(takesCourses) > 0;
            System.out.printf("TESTING: Comparing GPA Correct: %s\n", handleResult(compareCorrect));
        } catch (Exception e) {
            System.out.println(ANSI_RED + "ERROR WHILE TESTING STUDENT; CANNOT CONTINUE" + ANSI_RESET);
        }

    }

    //10 tests total
    private static void testCourse() {
        try {
            /*----------COURSE TESTS----------*/
            System.out.println(ANSI_PURPLE + "-- Testing Course --" + ANSI_RESET);

            //Constructor tests
            Course courseConstructed = new Course("Mrs.Con","Structor",true);
            boolean courseConstruct = (courseConstructed.courseTitle().equals("Structor")
                    && courseConstructed.courseTeacher().equals("Mrs.Con"));
            System.out.printf("TESTING: Course Constructor: %s" + ANSI_RESET + "\n", handleResult(courseConstruct));

            //Enrollment tests
            Course forStudents = new Course("Someone", "StudentsJoining", false);
            int preStudents = forStudents.numberEnrolled();
            for(int i = 0; i < 20; i++) {
                Student s = new Student("",2002, new School(""));
                if(!forStudents.enroll(s, true))
                    break;
            }
            int postStudents = forStudents.numberEnrolled();
            boolean studentsAdded = (preStudents == 0 && postStudents == 20);
            System.out.printf("TESTING: Enrolling in Course: %s" + ANSI_RESET + "\n", handleResult(studentsAdded));

            if(studentsAdded) {
                forStudents.unenroll(forStudents.enrolledStudents()[1]);
            }
            boolean studentsRemoved = (studentsAdded && forStudents.numberEnrolled() == 19);
            System.out.printf("TESTING: Unenrolling in Course: %s" + ANSI_RESET + "\n", handleResult(studentsRemoved));

            boolean studentsUpdated = true;
            for(Student student : forStudents.enrolledStudents()) {
                if(student.schedule.length != 1)
                    studentsUpdated = false;
            }
            System.out.printf("TESTING: Students Schedules Updated: %s" + ANSI_RESET + "\n", handleResult(studentsUpdated));

            Student toBeEnrolled = new Student("",2002, new School(""));
            boolean enrollCapped = !forStudents.enroll(toBeEnrolled, true);
            System.out.printf("TESTING: Enroll Count Capped at 20: %s" + ANSI_RESET + "\n", handleResult(enrollCapped));

            for(int i = 0; i < 9; i++) {
                Course c = new Course("", "", true);
                c.enroll(toBeEnrolled, true);
            }

            Course getsCopied = new Course("This Course", "Will be deep copied", true);
            Student alsoCopied = new Student("One of a kind!", 2002, new School(""));
            getsCopied.enroll(alsoCopied, true);

            boolean deepCopied = getsCopied.enrolledStudents().length > 0 && !(getsCopied.enrolledStudents()[0].hashCode() == alsoCopied.hashCode());
            System.out.printf("TESTING: Deep Copy of Students: %s" + ANSI_RESET + "\n", handleResult(deepCopied));

            Course eleventh = new Course("This","Is over the limit", true);
            boolean scheduleLimitting = !eleventh.enroll(toBeEnrolled, true);
            System.out.printf("TESTING: Max 10 Enrollments: %s" + ANSI_RESET + "\n", handleResult(scheduleLimitting));

            //Grading tests
            Course holdsGrades = new Course("This Course", "Has grades", false);
            Student toBeGraded = new Student("William", 2002, new School(""));
            holdsGrades.enroll(toBeGraded, true);
            holdsGrades.setGrade(toBeGraded, 99);

            boolean storedGrades = (holdsGrades.gradeOf(toBeGraded).gradeValue() == 99);
            System.out.printf("TESTING: Grades Stored Properly: %s" + ANSI_RESET + "\n", handleResult(storedGrades));

            Course holdsHonorsGrades = new Course("This Course", "Has honors grades", true);
            holdsHonorsGrades.enroll(toBeGraded, true);
            holdsHonorsGrades.setGrade(toBeGraded, 85);

            boolean storedHonorsGrades = (holdsHonorsGrades.gradeOf(toBeGraded).gradeValue() == (int)(85*1.05));
            System.out.printf("TESTING: Honors Grades Stored Properly: %s" + ANSI_RESET + "\n", handleResult(storedHonorsGrades));

            Student betterStudent = new Student("The Best", 2002, new School(""));
            holdsGrades.enroll(betterStudent, true);
            holdsGrades.setGrade(betterStudent, 100);
            boolean topStudentFound = holdsGrades.topStudent().equals(betterStudent);
            System.out.printf("TESTING: Top Student Found: %s" + ANSI_RESET + "\n", handleResult(topStudentFound));
        } catch (Exception e) {
            System.out.println(ANSI_RED + "ERROR WHILE TESTING COURSE; CANNOT CONTINUE" + ANSI_RESET);
        }
    }

    //1 total test
    private static void testSchool() {
        try {
            /*----------SCHOOL TESTS----------*/
            System.out.println(ANSI_PURPLE + "-- Testing School --" + ANSI_RESET);

            //Constructor tests
            School schoolConstructed = new School("BCA");
            boolean schoolConstruct = (schoolConstructed.getName().equals("BCA"));
            System.out.printf("TESTING: School Constructor: %s" + ANSI_RESET + "\n", handleResult(schoolConstruct));

        } catch (Exception e) {
            System.out.println(ANSI_RED + "ERROR WHILE TESTING SCHOOL; CANNOT CONTINUE" + ANSI_RESET);
        }


    }
    public static void main(String[] args) {
        System.out.println(ANSI_BLUE + "-- Aidan P & Patrick H's PowerSchool Tester --" + ANSI_RESET);
        testsPassed = 0;
        totalTests = 0;

        testGrade();
        testStudent();
        testCourse();
        testSchool();

        double percentPassed = (testsPassed / totalTests) * 100;
        String resultColor = ANSI_WHITE;
        if(percentPassed <= 50)
            resultColor = ANSI_RED;
        else if(percentPassed <= 99)
            resultColor = ANSI_YELLOW;
        else if(percentPassed == 100)
            resultColor = ANSI_GREEN;

        System.out.println(ANSI_BLUE + "-- Final Results --" + ANSI_RESET);
        System.out.printf(resultColor + "%d/%.0f passed (%.2f%%)\n" + ANSI_RESET, testsPassed, totalTests, percentPassed);

        int testsSkipped = (int)(NUM_TESTS - totalTests);
        double percentSkipped = (testsSkipped/NUM_TESTS) * 100;
        if(testsSkipped > 0)
            System.out.printf(ANSI_RED + "%d tests skipped (%.2f%%)\n" + ANSI_RESET, testsSkipped,percentSkipped);
    }
}