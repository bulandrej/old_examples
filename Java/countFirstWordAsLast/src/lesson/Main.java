package lesson;

/*Определить количество предложений, в которых первое слово совпадает с последним.
Разделителями предложений считать ! ? точку и любую комбинацию этих символов.
Разделителями слов считать пробел, запятую, точку с запятой и любую комбинацию этих символов. */

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        String in = "Методы из класса StringTokenizer перечислены ниже:\n" +
                "int countTokens() - используя текущий набор разделителей, определяет количество лексем, которые осталось разобрать и возвратить в качестве результата." +
                "boolean hasМoreElements() - возвращает логическое значение true, если в символьной строке остается одна лексема или больше, а иначе - логическое значение false" +
                "boolean hasМoreTokens() - возвращает логическое значение true, если в символьной строке остается одна лексема или больше, а иначе - логическое значение false!" +
                "String nextToken() - возвращает следующую лексему в виде объекта типа String?!." +
                "String nextToken() - возвращает следующую лексему в виде объекта типа String?!." +
                "String nextToken() - возвращает следующую лексему в виде объекта типа String?!." +
                "String nextToken(String разделители) - возвращает следующую лексему в виде объекта типа Object и задает символьную строку разделителей в соответствии со значением параметра разделители.";

        System.out.println("Всего в тексте "+ countFirstEqLast(in, "!?.")+ " предложений, в которых первое и последнее слово совпадают.");
    }

    private static int CountSentencesAndOut(String str, String separator, boolean show){
        int i = 0;
        StringTokenizer st = new StringTokenizer(str, separator);
        while(st.hasMoreTokens()) {
            i++;
            String s = st.nextToken();
            if(show)
            System.out.println("строка " + i + ": \n"+ s + "\n");
        }
        return i;
    }

    private static boolean isWordEqual(String str){
        boolean b = false;
        String[] words = str.split("[,; ]+");
        if(words[0].equalsIgnoreCase(words[words.length-1])) return true;
        else return false;
    }

    private static int countFirstEqLast(String str, String separator){
        int n = 0;
        int size = CountSentencesAndOut(str, separator, false);
        StringTokenizer st = new StringTokenizer(str, separator);
        while(st.hasMoreTokens()) if(isWordEqual(st.nextToken())) n++;
        return n;
    }
}
