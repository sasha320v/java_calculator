import java.util.List;

class RomanConverter {
  static int romanToArabic(String input) {
    String inputRomanNumber = input.toUpperCase();
    List<RomanNumberENUM> romanNumbers = RomanNumberENUM.getValues();
    int result = 0;
    int i = 0;
    while (inputRomanNumber.length() > 0 && i < romanNumbers.size()) {
      RomanNumberENUM currentSymbol = romanNumbers.get(i);
      if (inputRomanNumber.startsWith(currentSymbol.name())) {
        result += currentSymbol.getArabicValue();
        inputRomanNumber = inputRomanNumber.substring(currentSymbol.name().length());
      } else {
        i++;
      }
    }

    if(inputRomanNumber.length() > 0) {
      return -1;
    }

    return result;
  }

  static String arabicToRoman(int inputNumber) throws Exception {
    if (inputNumber < 1) {
      throw new Exception("в римской системе нет отрицательных чисел и нуля");
    }

    List<RomanNumberENUM> romanNumbers = RomanNumberENUM.getValues();
    int i = 0;
    String result = "";
    while (inputNumber > 0 && i < romanNumbers.size()) {
      RomanNumberENUM currentSymbol = romanNumbers.get(i);
      if (currentSymbol.getArabicValue() <= inputNumber) {
        result += currentSymbol.name();
        inputNumber -= currentSymbol.getArabicValue();
      } else {
        i++;
      }
    }

    return result;
  }
}
