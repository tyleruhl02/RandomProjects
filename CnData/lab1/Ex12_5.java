package HighSchool.CnData.lab1;

public class Ex12_5 {
  public static void main(String[] args) {
    try {
      Triangle triangle = new Triangle(1, 1.5, 1);
      System.out.println("Passed 1");
    }
    catch (Exception ex) {
      System.out.println("Failed 1 - there should be no exception");
    }

    try {
      Triangle triangle = new Triangle(2.5, 1.5, 1);
      System.out.println("Failed 2 - exception missing");
    }
    catch (Exception ex) {
      if (ex.toString().contains("IllegalTriangleException")) {
        System.out.println("Passed 2");
      }
      else {
        System.out.println("Failed 2 - exception caught, wrong type.");
      }
    }

    try {
      Triangle triangle = new Triangle(2.5, 1.5, 10);
      System.out.println("Failed 3 - exception missing");
    }
    catch (Exception ex) {
      if (ex.toString().contains("IllegalTriangleException")) {
        System.out.println("Passed 3");
      }
      else {
        System.out.println("Failed 32 - exception caught, wrong type.");
      }
    }

    try {
      Triangle triangle = new Triangle(2.5, 5.5, 3);
      System.out.println("Failed 4 - exception missing");
    }
    catch (Exception ex) {
      if (ex.toString().contains("IllegalTriangleException")) {
        System.out.println("Passed 4");
      }
      else {
        System.out.println("Failed 4 - exception caught, wrong type.");
      }
    }
  }
}
