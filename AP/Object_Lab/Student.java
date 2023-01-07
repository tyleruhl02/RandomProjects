package HighSchool.AP.Object_Lab;

/*public class Student implements Comparable<Student> {
    private String name;
    private int gradYear;
    private School Academy;
    public Course[] schedule;

    public Student(String name, int gradYear, School Academy) {
        this.name = name;
        this.gradYear = gradYear;
        this.Academy = Academy;
    }

    public String getName() {
        return name;
    }

    public int getGradYear() {
        return gradYear;
    }

    public School getAcademy() {
        return Academy;
    }

    public double getGPA() {
        Grade[] grades = new Grade[schedule.length];
        for (int i = 0; i < schedule.length; i++) {
            grades[i] = schedule[i].gradeOf(this);
        }
        double[] GPAs = new double[schedule.length];
        int[] boundaries = {930, 900, 870, 830, 800, 770, 730, 700, 670, 630, 600, 0};
        double[] GPAvalues = {4.0, 3.8, 3.33, 3.0, 2.8, 2.33, 2.0, 1.8, 1.33, 1.0, 0.8, 0.0};
        for (int i = 0; i < schedule.length; i++) {
            int grade = schedule[i].gradeOf(this).gradeValue();
            double GPAgrade = 0;
            for (int j = 0; j < boundaries.length; j++) {
                if(grade > boundaries[j]) {
                    if(schedule[i].gradeOf(this).audited()) {
                        GPAvalues[j] = -1;
                    }
                    else {
                        GPAgrade = GPAvalues[j];
                    }
                    break;
                }
            }
            GPAs[i] = GPAgrade;
        }
        int numOfNonAuditedClasses = 0;
        double GPAsum = 0;
        for (int i = 0; i < GPAs.length; i++) {
            if(Math.round(GPAs[i]) != -1) {
                GPAsum += GPAs[i];
                numOfNonAuditedClasses++;
            }
        }
        return GPAsum / numOfNonAuditedClasses;
    }

    @Override
    public int compareTo(Student someOtherKid) {
        if(getGPA() - someOtherKid.getGPA() > 0) {
            return 1;
        }
        else if (getGPA() - someOtherKid.getGPA() < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }

    public boolean addCourse(Course someCourse) {
        boolean containsNull = false;
        for (int i = 0; i < schedule.length; i++) {
            if(schedule[i].courseTitle().equals(someCourse.courseTitle())) {
                return false;
            }
            if(schedule[i].courseTitle() == null) {
                containsNull = true;
            }
        }
        if(!containsNull) {
            return false;
        }
        for (int i = 0; i < schedule.length; i++) {
            if(schedule[i].courseTitle() == null) {
                schedule[i] = someCourse;
                return true;
            }
        }
        return false;
    }

    public boolean dropCourse(Course someCourse) {
        for (int i = 0; i < schedule.length; i++) {
            if(schedule[i].courseTitle().equals(someCourse.courseTitle())) {
                schedule[i] = null;
                return true;
            }
        }
        return false;
    }
}*/
//
//import java.util.Arrays;
//
//public class Student implements Comparable<Student> {
//    String name;
//    int gradYear;
//    School Academy;
//    Course[] schedule;
//
//    public Student(String name, int gradYear, School Academy) {
//        this.name = name;
//        this.gradYear = gradYear;
//        this.Academy = Academy;
//        schedule = new Course[0];
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getGradYear() {
//        return gradYear;
//    }
//
//    public School getAcademy() {
//        return Academy;
//    }
//
//    public double getGPA() {
//        double[] GPAs = new double[schedule.length];
//        int[] boundaries = {930, 900, 870, 830, 800, 770, 730, 700, 670, 630, 600, 0};
//        double[] GPAvalues = {4.0, 3.8, 3.33, 3.0, 2.8, 2.33, 2.0, 1.8, 1.33, 1.0, 0.8, 0.0};
//        for (int i = 0; i < schedule.length; i++) {
//            //System.out.println(schedule[i].courseTitle);
//            //System.out.println(i + "ENROLLED STUDENTS LENGTH:" + schedule[i].);
//            //System.out.println(schedule[i].gradeOf(this));
//            //System.out.println(schedule[i].enrolledStudents.length);
//            //System.out.println(Arrays.toString(schedule));
//            /*Course a = schedule[i];
//            System.out.println(a);
//            Grade b = a.gradeOf(this);
//            System.out.println(b);
//            int c = b.gradeValue();
//            System.out.println(c);
//            System.out.println();*/
//            //System.out.println(schedule[i].gradeOf(this).gradeValue());
//            int grade = 0;
//            try {
//                grade = schedule[i].gradeOf(this).gradeValue();
//                double GPAgrade = 0;
//                for (int j = 0; j < boundaries.length; j++) {
//                    if(grade > boundaries[j]) {
//                        if(schedule[i].gradeOf(this).audited()) {
//                            GPAvalues[j] = -1;
//                        }
//                        else {
//                            GPAgrade = GPAvalues[j];
//                        }
//                        break;
//                    }
//                }
//                GPAs[i] = GPAgrade;
//            }
//            catch (NullPointerException e) {
//                GPAs[i] = -1;
//            }
//        }
//        int numOfNonAuditedClasses = 0;
//        double GPAsum = 0;
//        for (int i = 1; i < GPAs.length; i++) {
//            if(Math.round(GPAs[i]) != -1) {
//                GPAsum += GPAs[i];
//                numOfNonAuditedClasses++;
//            }
//        }
//        return GPAsum / numOfNonAuditedClasses;
//    }
//
//    @Override
//    public int compareTo(Student someOtherKid) {
//        if(getGPA() - someOtherKid.getGPA() > 0) {
//            return 1;
//        }
//        else if (getGPA() - someOtherKid.getGPA() < 0) {
//            return -1;
//        }
//        else {
//            return 0;
//        }
//    }
//
//    public boolean addCourse(Course someCourse) {
//        if(schedule.length < 10) {
//            for (int i = 0; i < schedule.length; i++) {
//                if(schedule[i].equals(someCourse)) {
//                    return false;
//                }
//            }
//            Course[] newSchedule = new Course[schedule.length+1];
//            for (int i = 0; i < schedule.length; i++) {
//                newSchedule[i] = schedule[i];
//            }
//            newSchedule[schedule.length] = someCourse;
//            schedule = newSchedule.clone();
//            someCourse.enroll(this, false); //
//            return true;
//        }
//        return false;
//    }
//
//    public boolean dropCourse(Course someCourse) {
//        if(schedule.length > 0) {
//            for (int i = 0; i < schedule.length; i++) {
//                if(schedule[i].equals(someCourse)) {
//                    Course[] newSchedule = new Course[schedule.length-1];
//                    for (int j = 0; j < schedule.length; j++) {
//                        if(j<i) {
//                            newSchedule[j] = schedule[j];
//                        }
//                        else if(j>i) {
//                            newSchedule[j-1] = schedule[j];
//                        }
//                    }
//                    schedule = newSchedule.clone();
//                    someCourse.unenroll(this);
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//}

public class Student implements Comparable<Student> {
    String Name;
    int gradYear;
    School Academy;
    Course[] schedule;

    public Student(String name, int gradYear, School Academy) {
        this.Name = name;
        this.gradYear = gradYear;
        this.Academy = Academy;
        schedule = new Course[0];
    }

    public String getName() {
        return Name;
    }

    public int getGradYear() {
        return gradYear;
    }

    public School getAcademy() {
        return Academy;
    }

    public double getGPA() {
        double[] GPAs =             {4.0,   3.8,    3.33,   3.0,    2.8,    2.33,   2.0,    1.8,    1.33,   1.0,    0.8,    0};
        double[] GPAboundaries =    {93,    90,     87,     83,     80,     77,     73,     70,     67,     63,     60,     0};
        int[] grades = new int[schedule.length];
        for (int i = 0; i < schedule.length; i++) {
            grades[i] = schedule[i].gradeOf(this).gradeValue();
        }
        //double[] GPAValues = new double[schedule.length];
        double totalGPA = 0;
        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < GPAboundaries.length; j++) {
                if(grades[i] > GPAboundaries[j]) {
                    //GPAValues[i] = GPAs[j];
                    totalGPA += GPAs[j];
                    break;
                }
            }
        }
        return totalGPA / grades.length;
        //return 0;
    }

    @Override
    public int compareTo(Student someOtherKid) {
        double myGPA = getGPA();
        double otherKidGPA = someOtherKid.getGPA();

        if(myGPA - otherKidGPA > 0) {
            return 1;
        }
        if(myGPA - otherKidGPA < 0) {
            return -1;
        }
        return 0;
    }

    private boolean takesCourse(Course someCourse) {
        for (int i = 0; i < schedule.length; i++) {
            if(schedule[i].equals(someCourse)) {
                return true;
            }
        }
        return false;
    }

    public boolean addCourse(Course someCourse) {
        if(schedule.length < 10 && !takesCourse(someCourse)) {
            Course[] newSchedule = new Course[schedule.length+1];
            for (int i = 0; i < schedule.length; i++) {
                newSchedule[i] = schedule[i];
            }
            newSchedule[schedule.length] = someCourse;
            schedule = newSchedule.clone();
            return true;
        }
        return false;
    }

    public boolean dropCourse(Course someCourse) {
        if(takesCourse(someCourse)) {
            Course[] newSchedule = new Course[schedule.length-1];
            int changer = 0;
            for (int i = 0; i < newSchedule.length; i++) {
                if(schedule[i].equals(someCourse)) {
                    changer = 1;
                }
                newSchedule[i] = schedule[i+changer];
            }
            schedule = newSchedule.clone();
            return true;
        }
        return false;
    }
}