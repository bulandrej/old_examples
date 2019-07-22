package lesson;

public class CountDigitInString {


    public CountDigitInString() {}


    // подсчёт количества вхождений в строку указанной цифры
    public int countThisDigit(String str, int dig){
        int count = 0;
        for (int i = 0; i <str.length() ; i++) {
            if(Character.toString(str.charAt(i)).equals(((Integer)dig).toString())){//.equals
                count++;
            }
        }
        return count;
    }

    public void showCountDigit(String str){
        for (int i = 0; i <10 ; i++) {
            System.out.println("Цифра "+ i + " встречается в строке " + this.countThisDigit(str, i) + " раз.");
        }
    }
}
