package HighSchool.CnData.lab1;

public class Ex12_6 {
  /** Main method */
  public static void main(String[] args) {
      try {
          if (hexToDecimal("F53A") == 62778)
              System.out.println("Passed 1");
          else
              System.out.println("Failed 1: Incorrect conversion result.");
      }
      catch (NumberFormatException ex) {
          System.out.println("Failed 1: Unexpected exception.");
      }
      try {
          if (hexToDecimal("ba") == 186)
              System.out.println("Passed 2");
          else
              System.out.println("Failed 2: Incorrect conversion result.");

      }
      catch (NumberFormatException ex) {
          System.out.println("Failed 2: Unexpected exception.");
      }

      try {
          hexToDecimal("G3");
          System.out.println("Failed 3: Did not catch illegal format.");
      }
      catch (NumberFormatException ex) {
          System.out.println("Passed 3.");
      }

      try {
          hexToDecimal("g9");
          System.out.println("Failed 4: Did not catch illegal format.");
      }
      catch (NumberFormatException ex) {
          System.out.println("Passed 4.");
      }

      try {
          hexToDecimal("2*");
          System.out.println("Failed 5: Did not catch illegal format.");
      }
      catch (NumberFormatException ex) {
          System.out.println("Passed 5.");
      }

      try {
          hexToDecimal(">5");
          System.out.println("Failed 6: Did not catch illegal format.");
      }
      catch (NumberFormatException ex) {
          System.out.println("Passed 6.");
      }
  }


  public static int hexToDecimal(String hex) {
    char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    hex = hex.toUpperCase();
    int decimalValue = 0;
    boolean valid = false;
    for (int i = 0; i < hex.length(); i++) {
        valid = false;
      char hexChar = hex.charAt(i);
        for (int j = 0; j < 16; j++) {
            if(hexChar == hexChars[j]) {
                valid = true;
                break;
            }
        }
      decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        if(!valid) {
            throw new NumberFormatException();
        }
    }

    if(!valid) {
        throw new NumberFormatException();
    }

    return decimalValue;
  }

  public static int hexCharToDecimal(char ch) {
    if (ch >= 'A' && ch <= 'F')
      return 10 + ch - 'A';
    else // ch is '0', '1', ..., or '9'
      return ch - '0';
  }
}
