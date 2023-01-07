package HighSchool.AP.Object_Lab;

public interface SportsProfessional {
    public static final int MAX_STAT = 10;
    public static final int MAX_PERFORM_VARIANCE = 2;

    void practice();
    int perform();
    String getName();
}