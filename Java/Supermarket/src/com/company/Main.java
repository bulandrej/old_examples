package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 2-3.\n" +
                "Супермаркету необходимо написать программу для кассового места. \n" +
                "В супермаркете есть различные товары, каждый товар имеет такие характеристики: \n" +
                "■ наименование товара; \n" +
                "■ цена за одну единицу измерения в рублях и копейках; \n" +
                "■ единица измерения (штуки, килограммы, граммы, литры); \n" +
                "■ номер штрих-кода; \n" +
                "■ тип акции.\n" +
                "\n" +
                "Наименование товара – название изделия, минимальная длина три символа, максимальная длина 250 символов. \n" +
                "Цена за единицу – минимальная цена товара 0.01 рубля, максимальная не ограничена. Цена должна быть всегда положительной. \n" +
                "Единица измерения – сокращенное название, длина не менее 2 символов и не более 5. \n" +
                "Номер штрих-кода – длина штрих-кода должна быть всегда 13 цифр. Может иметь нули в начале номера. \n" +
                "Типы акции – товар может участвовать или не участвовать в акциях супермаркета. \n" +
                "\n" +
                "В супермаркете есть несколько видов акций: \n" +
                "■ каждый третий купленный товар, участвующий в данной акции продается бесплатно (за 1 копейку); \n" +
                "■ на второй товар, участвующий в этой акции, 50% скидка, на третий товар – 100% скидка. \n" +
                "  Скидка должна даваться на самый дешевый товар из чека. Дается только одна скидка. \n" +
                "  Т.е., если куплено три акционных товара, два более дорогих идут по полной цене, \n" +
                "  третий – наиболее дешевый – по 1 копейке.\n" +
                "■ сезонная скидка на товар – действует в определенный период, указывается в процентах. \n" +
                " \n" +
                "Программа должна уметь:\n" +
                "■ считывая номера штрих-кодов товаров, вносить их в корзину покупок; \n" +
                "■ рассчитывать общую сумму по чеку, учитывая скидки на акционные товары.\n"
        );
        // единицы измерения товара
        String[] unitList = {"метр.","кг","литр.","упак.","шт."};
        // наименования продуктов
        String[] nameProduct = {"молоко","мороженое","йогурт","ткань","сахар","соль","мука","спички"};
        // массив покупок:
        ArrayList<Article> articles = new ArrayList<>();
        shoppingCart shCart = new shoppingCart();
        articles.add(shCart.barCodeReader(nameProduct[0], 1.05, "ert0567894325", unitList[2], false));
        articles.add(shCart.barCodeReader(nameProduct[1], 1.98, "0000578545545", unitList[3], false));
        articles.add(shCart.barCodeReader(nameProduct[4], 2.05, "0000117894325", unitList[1], false));
        articles.add(shCart.barCodeReader(nameProduct[7], 0.51, "0001342194325", unitList[3], false)); // акционный товар 1
        articles.add(shCart.barCodeReader(nameProduct[3], 19.04, "0018678947154", unitList[0], false));
        articles.add(shCart.barCodeReader(nameProduct[7], 0.51, "0001342194325", unitList[3], false)); // акционный товар 2
        articles.add(shCart.barCodeReader(nameProduct[7], 0.51, "0001342194325", unitList[3], false)); // акционный товар 3

        // List в массив:
        Article[] arrArts = articles.toArray(new Article[articles.size()]);
        // сортируем массив:
        Arrays.sort(arrArts, new PriceComparator());

        System.out.println("\nОтсортированный по цене массив товаров:");
        Show(arrArts);

        System.out.print("\nЦена за все товары: \n");

        shoppingCart shc = new shoppingCart();
        ArrayList<Article> sortListArrays = new ArrayList<Article>(Arrays.asList(arrArts));
        shc.setShoppingList(sortListArrays);

        System.out.printf("Заплатите %.2f рублей и будьте счастливы!",shc.price());

    }

    public static void Show(Article[] arrArts){
        for(Article a: arrArts)
            a.ShowArticle();
    }
}
