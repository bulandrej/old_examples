package lesson;

import java.util.StringTokenizer;

/* Сформировать строку StringBuilder из предложений, в которых содержатся автомобильные номера.
Разделителями предложений считать ! ? точку и любую комбинацию этих символов.
Разделителями слов считать пробел, запятую, точку с запятой и любую комбинацию этих символов.
Для поиска номеров использовать регулярное выражение.
Пример автомобильного номера: 2135 ЕМ-3               */

public class Main {

  public static void main(String[] args) {

    String in = "Номерной знак легковых автомобилей\n" +
            "Содержит четыре цифры, две буквы серии, дефис и код региона." +
            "Пример знака: 1234 АВ-7!?." +
            "1234 АВ-7. Двухрядный номерной знак легковых автомобилей, прицепов и полуприцепов." +
            "Устанавливается на автомобили американского производства, а также на прицепы и полуприцепы" +
            " с установочным местом для советских двухрядных знаков стандарта 1977 г.\n" +
            "Номер содержит две буквы серии, дефис и код региона в нижнем ряду и четыре цифры - в верхнем." +
            "Пример знака: 1234 АО-7." +
            "Ещё пример автомобильного номера: 2135 ЕМ-3";

    System.out.println("Результирующая строка: \n" + RetStringBuf(in, "!?.").toString());
  }

  private static int CountSentencesAndOut(String str, String separator, boolean show) {
    int i = 0;
    StringTokenizer st = new StringTokenizer(str, separator);
    while (st.hasMoreTokens()) {
      i++;
      String s = st.nextToken();
      if (show)
        System.out.println("строка " + i + ": \n" + s + "\n");
    }
    return i;
  }

  private static boolean isAutonumExist(String str) {
    boolean b = false;
    String[] words = str.split("[,; ]+");
    for (int i = 0; i < words.length; i++) {
      //System.out.println(words[i]);
      String regularFirstPart = "[\\d]{4}";
      String regularSecondPart = "[А-Я]{2}[\\-]{1}[\\d]{1}";
      if (i <= words.length - 1)
        if (words[i].matches(regularFirstPart))
          if (words[i + 1].matches(regularSecondPart))
          b = true;
    }
    return b;
  }

  private static StringBuffer RetStringBuf(String str, String separator) {
    StringBuffer sb = new StringBuffer("");
    int size = CountSentencesAndOut(str, separator, false);
    StringTokenizer st = new StringTokenizer(str, separator);
    while (st.hasMoreTokens()) {
      String s = st.nextToken();
      if (isAutonumExist(s))
        sb.append(s + ".\n");
    }
    return sb;
  }
}
