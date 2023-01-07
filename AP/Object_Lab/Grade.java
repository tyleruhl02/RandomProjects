package HighSchool.AP.Object_Lab;

/*public class Grade {
    private int grade;
    private boolean audit;
    private boolean honors;
    private Course course;

    public Grade(boolean honors, boolean audited, int grade, Course course) {
        this.honors = honors;
        this.audit = audited;
        this.course = course;
        this.grade = grade;
        if(grade < 0) {
            this.grade = 0;
        }
        if(grade > 1000) {
            this.grade = 1000; // + (honors ? 50 : 0);
        }
    }

    public int gradeValue() {
        return (int) (grade * (honors ? 1.05 : 1));
    }

    public boolean honors() {
        return honors;
    }

    public boolean audited() {
        return audit;
    }
}*/

/*public class Grade {
    private int grade;
    private boolean audit;
    private boolean honors;
    private Course course;

    public Grade(boolean honors, boolean audited, int grade, Course course) {
        this.honors = honors;
        this.audit = audited;
        this.course = course;
        this.grade = grade;
        if(grade < 0) {
            this.grade = 0;
        }
        if(grade > 1000) {
            this.grade = 1000;
        }
    }

    public int gradeValue() {
        return (int) Math.round(grade * (honors ? 1.05 : 1));
    }

    public boolean honors() {
        return honors;
    }

    public boolean audited() {
        return audit;
    }
}*/

public class Grade {
    int grade;
    boolean audit;
    boolean honors;
    Course course;

    public Grade(boolean honors, boolean audited, int grade, Course course) {
        this.honors = honors;
        this.audit = audited;
        this.grade = grade;
        this.course = course;

        if(this.grade < 0) {
            this.grade = 0;
        }
        if(this.grade > 1000) {
            this.grade = 1000;
        }
    }

    public int gradeValue() {
        if(honors) {
            return (int) Math.round(1.05*grade);
        }
        return grade;
    }

    public boolean honors() {
        return honors;
    }

    public boolean audited() {
        return audit;
    }
}