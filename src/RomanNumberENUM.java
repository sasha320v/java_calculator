import java.util.Arrays;
import java.util.List;

public enum RomanNumberENUM {
  C(100),
  XC(90),
  L(50),
  XL(40),
  X(10),
  IX(9),
  V(5),
  IV(4),
  I(1);
  private final int arabicValue;
  RomanNumberENUM(int arabicValue) {
    this.arabicValue = arabicValue;
  }

  public int getArabicValue() {
    return this.arabicValue;
  }

  public static List<RomanNumberENUM> getValues() {
    return Arrays.asList(RomanNumberENUM.values());
  }
}
