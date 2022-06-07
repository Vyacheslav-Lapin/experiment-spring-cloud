package ru.vlapin.experiments.card.common;

import java.util.Random;
import lombok.experimental.UtilityClass;
import lombok.val;

@UtilityClass
public class CardNumberGenerator {

  Random random = new Random(System.currentTimeMillis());

  public String generate() {

    val builder = new StringBuilder();

    for (int i = 0; i < 15; i++)
      builder.append(random.nextInt(10));

    builder.append(getCheckDigit(builder.toString()));
    return builder.toString();
  }

  private Integer getCheckDigit(String number) {
    var sum = 0;
    for (int i = 0; i < number.length(); i++) {
      var digit = Integer.parseInt(number.substring(i, (i + 1)));
      if ((i % 2) == 0) {
        digit = digit * 2;
        if (digit > 9)
          digit = (digit / 10) + (digit % 10);
      }
      sum += digit;
    }
    val mod = sum % 10;
    return ((mod == 0) ? 0 : 10 - mod);
  }
}
