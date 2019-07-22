package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1.\n" +
                "     Написать метод для подсчета суммы выигрыша на тотализаторе. \n" +
                "\n" +
                "     В качестве параметров метод принимает массив строк (имена лошадей), упорядоченный по результатам забега\n" +
                "\n" +
                "     и перечень ставок, заданный с помощью трех массивов равной длины: \n" +
                "     Первый массив — имя игрока, \n" +
                "     второй — кличка лошади, на которую он поставил \n" +
                "     и третий — сумма, которую игрок поставил на эту лошадь \n" +
                "     (то есть, игрок gamers[i] поставил на лошадь horses[i] сумму sums[i]). \n" +
                "\n" +
                "     Метод должен возвращать массив строк, где каждая строка содержит имя игрока-победителя и выигранную им сумму. \n" +
                "\n" +
                "     *Я не знаю, как рассчитывается выигрыш, поэтому буду считать, что в случае, если лошадь, на которую поставил игрок, \n" +
                "     пришла первой - ставка увеличивается в 1,5 раза, в противном случае - игрок теряет половину поставленных денег.\n\n" +
                "     ИНСТРУКЦИЯ: Просто нажимайте Shift + F10, и наблюдайте за результатами в консоли!\n\n"
        );

        // инициализируем лошадей:
        Horse Neiron = new Horse("Neiron"); // 1
        Horse Apollon = new Horse("Apollon"); // 2
        Horse Lord = new Horse("Lord"); // 3
        Horse Magistr = new Horse("Magistr"); // 4
        Horse Omar = new Horse("Omar"); // 5
        Horse Pirat = new Horse("Pirat"); // 6
        Horse Rafael = new Horse("Rafael"); // 7
        Horse Titan = new Horse("Titan"); // 8 - всего (пока что) 8 лошадей
        //Horse  = new Horse("");

        // создаём массив лошадей:
        Horse[] horses = {Neiron,Apollon,Lord,Magistr,Omar,Pirat,Rafael,Titan};
        // сортируем массив лошадей по результатам:

        System.out.println("\nНесортированный массив лошадей:");
        Show(horses);
        // сортируем массив:
        Arrays.sort(horses, new ResultRaceComparator());

        System.out.println("\nОтсортированный по результату забега массив лошадей:");
        Show(horses);
        // <---------------------------------------------------------------- отсортированный по забегам массив имён лошадей:
        String[] nameHorsesSort = new String[horses.length];
        nameHorsesSort = horsesSort(horses);
        // проверка инициализации лошадей:
        //System.out.println("Результат забега Apollon: " + Apollon.getResultRace() + "сек.");
        //System.out.println("Результат забега Titan: " + Titan.getResultRace() + "сек.");

        System.out.println("\nОтсортированный по результату забега массив ИМЁН лошадей:");
        Show(nameHorsesSort);

        // создаём массив игроков:
        Gamer g1 = new Gamer("Иванов");
        Gamer g2 = new Gamer("Петров");
        Gamer g3 = new Gamer("Сидоров");
        Gamer g4 = new Gamer("Мавроди"); // и как вы думаете, кто выиграет?
        Gamer g5 = new Gamer("Фёдоров");
        //Gamer  = new Gamer("");

        // <------------------------------------------------------------------------------------------- массив имён игроков:
        String[] gamers = {g1.getName(),g2.getName(),g3.getName(),g4.getName(),g5.getName()};

        // Neiron, Apollon, Lord, Magistr, Omar, Pirat, Rafael, Titan
        // <---------------------------------------------------------------- массив имён лошадей, на которых ставили игроки:
        String[] nameHorsesBet = {"Lord","Magistr","Apollon","Titan","Magistr"};
        // <----------------------------------------------------------------------------------------- массив ставок игроков:
        float[] betHorse = {g1.getBetting(),g2.getBetting(),g3.getBetting(),g4.getBetting(),g5.getBetting()};

        //amountTote(nameHorsesSort, gamers, nameHorsesBet, betHorse);
        System.out.println("\nСписок игроков-победителей с выигранной суммой:");
        Show(amountTote(nameHorsesSort, gamers, nameHorsesBet, betHorse));
    }

    public static void Show(Horse[] horses){
        for (Horse h:horses){
            System.out.println(h);
        }
    }

    public static void Show(String[] masStr ){
        for (String h:masStr){
            System.out.println(h);
        }
    }

    // метод подсчёта суммы выигрыша
    public static String[] amountTote(String[] nameHorsesSort, String[] gamers, String[] nameHorsesBet, float[] betHorse){
        int count = 0;
        int j = 0;
        List<String> listStr = new ArrayList<String>();
        System.out.println("Лошадь, победившая в забеге - "+nameHorsesSort[0]);
        for (int i=0;i<gamers.length;i++) {
            if (nameHorsesSort[0] == nameHorsesBet[i]) {
                count++;
                listStr.add("Игрок "+gamers[i]+" выиграл "+betHorse[i]*1.5+ " руб.");
            }
        }
        if (count==0)
            System.out.println(".. А на неё - никто не поставил! ");
        String[] winsGamers = null;
        // Создаем массив строк такого же размера, что и входной список ArrayList
        winsGamers = listStr.toArray(new String[listStr.size()]);
        return winsGamers;
    }

    public static String[] horsesSort(Horse[] horses){
        String[] sortedNameHorses = new String[horses.length];
        int i = 0;
        for (Horse h:horses){
            sortedNameHorses[i] = h.getName();
            i++;
        }
        return sortedNameHorses;
    }

    public String initBet(Horse[] horses){
    int numHorse = (int)(Math.random()*(horses.length-1)); // выбор лошади для ставки
    return (horses[numHorse].getName());
    }

}
