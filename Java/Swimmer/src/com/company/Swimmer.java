package com.company;

public class Swimmer {

    // вычисляем, в какой день пловец теоретически проплывёт более dist
    public int swimDay(double interval){
        // инициализация величин для первого дня:
        double dist = 3000;
        int day = 1;

        do{
            if(day>1)
                dist += dist*0.1;
            System.out.println("день "+day+" - дистанция "+dist/1000+" км.");

            if (dist >=  interval)
                return day;

            day++;
        }while(dist <=  interval);
        return day;
    }

    //  вычисляем, к какому дню пловец суммарно проплывет более interval
    public int swimSum(double interval){
        // инициализация величин для первого дня:
        int day = 1;
        double dist = 3000;
        double sum = dist;

        do{
            if(day>1) {
                dist += dist*0.1;
                sum += dist;
                System.out.println("день "+day+" - "+sum/1000+" км.");
            }

            if (sum >=  interval)
                return day;

            day++;
        }while(sum<=interval);

        return day;
    }

}
