package com.company;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class shoppingCart {

    public ArrayList<Article> shoppingList;

    public shoppingCart(){};

    // "считываем штрихкоды"
    public Article barCodeReader(String name, double pricePerUnit, String numBarCode, String unit, boolean typeShare) {
        Article article = new Article();
        article.setTypeShare(typeShare);
        article.setNumBarCode(numBarCode);
        article.setName(name);
        article.setPricePerUnit(pricePerUnit);
        article.setUnit(unit);

        return article;
    }

    public ArrayList<Article> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ArrayList<Article> shoppingList) {
        this.shoppingList = shoppingList;
    }


    // Расчёт цены корзины с товарами
    public double price(){
        int i = 0;
        double price = 0;
        String actName = "";
        for(Article shL:this.getShoppingList()){
            // в отсортированном по цене списке акционный товар всегда первый
            if(i == 0) {
                actName = shL.getName(); // запоминаем название акционного товара
                // если акционный товар один - действует только сезонная скидка:
                if(this.howItems(i)==1) {
                    price += shL.getPricePerUnit()*SeasonDiscount(shL.getPricePerUnit());
                    System.out.println("Вам сказочно повезло! На Ваш товар " + shL.getName() + " у нас сезонная скидка");
                }
            }
            // проверяем остальные акционные товары
            else if(actName == shL.getName()){
                // отлавливаем каждый третий акционный товар
                if(i>=2 && actName == shL.getName()&& this.howItems(i)%3 == 0 && this.howItems(i)>=3){
                    price += this.actionEveryThird(); // товары по одной копейке
                    System.out.println("Вам сказочно повезло! Каждый третий товар " + shL.getName() + " сегодня стоит всего 1 копейку!");
                }
                // если акционных товаров 2, и это - второй товар:
                else if(actName == shL.getName()&& i == 1 && this.howItems(i)==2){
                    price += this.actionEverySecond(shL.getPricePerUnit()); // товары со скидкой 50%
                    System.out.println("Вам сказочно повезло! Ваш товар " + shL.getName() + " сегодня дешевле в 2 раза");
                }
            }
            // остальные товары - по полной цене
            else{
                price += shL.getPricePerUnit();
            }
            i++;
        }
        return price;
    }

    // скидка на третий товар
    public double actionEveryThird(){
        return (0.01);
    }

    // скидка на второй товар
    public double actionEverySecond(double price){
        return price/2;
    }

    // расчёт сезонной цены на единицу товара
    public double SeasonDiscount(double price){
        double percent;
        if(checkSeason()==1) // зима
            percent = 0.7;
        else if(checkSeason()==2) // весна
            percent = 0.9;
        else if(checkSeason()==3) // лето
            percent = 0.8;
        else percent = 0.5; // осень

        return price*percent;
    }

    // проверка: какой сезон
    public int checkSeason(){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+2:00"));
        int numMonth = cal.get(Calendar.MONTH)+1;
        if(numMonth<= 11 && numMonth>=9)
            return 4; // осень
        else if(numMonth<= 5 && numMonth>=3)
            return 2; // весна
        else if(numMonth<= 8 && numMonth>=6)
            return 3; // лето
        else return 1; // зима
    }

    // сколько однотипного товара куплено
    public int howItems(int i){
        int k = 0;
        String Name = getShoppingList().get(i).getName();

        for(Article shL:getShoppingList()){
            if(shL.getName()== Name) k++;
        }
        return k;
    }

}
