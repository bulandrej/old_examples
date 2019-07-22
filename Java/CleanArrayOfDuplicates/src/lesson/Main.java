package lesson;

/*Дан массив, содержащий набор чисел в произвольном порядке.
Нам обещают, что все его значения различны.

Написать программу, которая проверяет, так ли это, и если не так -
удаляет из набора повторные вхождения чисел.                */

public class Main {

    private static int array[];

    public static void main(String[] args) {

        array = new int[]{1, -1, 2, 5, 7, 1, 1, -8, 3, 0, 1, 1, 1}; // задавать значения массива здесь

        System.out.println("Массив до обработки: " + Show(array) + "\n");
        findAndRemoveDuplicates();
        System.out.println("Массив после обработки: " + Show(array));
    }

    private static void findAndRemoveDuplicates(){

        int tmp;
        boolean mark = false;
        for (int k = 0; k < array.length; k++) {
            tmp = array[k];
            for (int i = 0; i < array.length; i++) {
                if (array[i] == tmp && i!= k) {
                    CopyToNewArray(i);
                    if(i < array.length)
                        mark = true;
                    break;
                }
            }
            if (mark) findAndRemoveDuplicates();
        }
    }

    private  static void CopyToNewArray(int n){
        int ar[] = new int[array.length-1];

        for (int i = 0; i < n; i++) {
               ar[i] = array[i];
        }
        for (int j = n; j < ar.length; j++){
            ar[j] = array[j+1];
        }
        array = null;
        array = ar;
    }

    private static String Show(int[] ar){
        String str="{ ";
        for (int i = 0; i < ar.length; i++) {
           if(i == ar.length - 1)
               str += ar[i]+" }";
           else
               str += ar[i]+", ";
        }
        return str;
    }
}
