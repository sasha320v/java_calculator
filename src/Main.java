import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String input = getInput();
    try {
      String result = calc(input);
      System.out.println(result);
    } catch (Exception error) {
      System.out.println(error.getMessage());
    }
  }

  private static String getInput() {
    Scanner in = new Scanner(System.in);
    System.out.println("введите выражение: ");
    String expression = in.nextLine().trim();
    in.close();

    return expression;
  }
  public static String calc(String input) throws Exception {
    String[] allowedOperators = {"+", "-", "/", "*"};
    int indexOperator = -1;
    int countOperators = 0;
    for (String allowedOperator:allowedOperators) {
      int index = input.indexOf(allowedOperator);
      if (index != -1) {
        indexOperator = index;
        countOperators++;
      }
    }

    if (indexOperator == -1) {
      throw new Exception("несуществующий оператор");
    }
    if (countOperators > 1) {
      throw new Exception("формат выражения не удовлетворяет условию один оператор");
    }

    String inputA = input.substring(0, indexOperator);
    String inputB = input.substring(indexOperator + 1);
    String operator = String.valueOf(input.charAt(indexOperator));

    boolean isRoman = true;
    int a = RomanConverter.romanToArabic(inputA);
    int b = RomanConverter.romanToArabic(inputB);
    int countRomanNumbers = 0;
    if (a != -1) {
      countRomanNumbers++;
    }
    if (b != -1) {
      countRomanNumbers++;
    }
    if (countRomanNumbers == 1) {
      throw new Exception("используются одновременно разные системы счисления");
    }
    if (countRomanNumbers == 0) {
      try {
        a = Integer.parseInt(inputA);
        b = Integer.parseInt(inputB);
        isRoman = false;
      } catch (NumberFormatException e) {
        throw new Exception("некорректные операнды");
      }
    }

    if (a < 1 || a > 10) {
      throw new Exception("первый операнд должен быть от 1 до 10");
    }
    if (b < 1 || b > 10) {
      throw new Exception("второй операнд должен быть от 1 до 10");
    }

    int result = switch (operator) {
      case "+" -> a + b;
      case "-" -> a - b;
      case "*" -> a * b;
      case "/" -> a / b;
      default -> 0;
    };

    return isRoman ? RomanConverter.arabicToRoman(result) : Integer.toString(result);
  }
}
