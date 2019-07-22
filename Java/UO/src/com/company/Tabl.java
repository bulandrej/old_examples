package com.company;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Locale;
import java.util.Date;

public class Tabl {

    public void Top(){
        System.out.println("-------------------------------------------------------------");
        System.out.println("|    УО    |Возраст|  Название    | Дополнительные сведения |");
        System.out.println("-------------------------------------------------------------");
    }

    public void Bot(){
        System.out.println("-------------------------------------------------------------");
    }

    public void ShowLine(UO[] uo, int i){

        if(uo[i].getVid()=="ВУЗ"){
            System.out.printf("|%-10s|%-7d|%-14s|%-25s|",uo[i].getVid(),yearConstruct(uo[i]),uo[i].getName(),uo[i].dop());
        }
        else if(uo[i].getVid()=="Школа"){
            System.out.printf("|%-10s|%-7d|%-13s|%-25s|",uo[i].getVid(),yearConstruct(uo[i]),uo[i].getName(),uo[i].dop());
        }
        System.out.println();
    }
    // получение текущего года
    public static int getCurrentYear()
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        calendar.setTime(new Date());
        return calendar.get(Calendar.YEAR);
    }

    public int yearConstruct(UO uo){
        int yearConstruct = 0;
        if(uo instanceof GodZaDva) {
            yearConstruct = (getCurrentYear() - uo.getAge()) * 2;
        }
        else
            yearConstruct = getCurrentYear() - uo.getAge();
        return yearConstruct;
    }
}
