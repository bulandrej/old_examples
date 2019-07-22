package com.company;

//  класс "Товар"
public class Article {
    private String name; // название изделия, мин. длина 3 символа, макс. 250 симв.
    private double pricePerUnit; // мин. цена товара 0.01 руб, макс. не ограничен.
    // Цена всегда положительная.
    private String numBarCode;  // длина штрих-кода всегда 13 цифр. М.б. нули в начале номера.
    private String unit; // единицы измерения товара - от 2 до 5 символов
    boolean typeShare; // есть или нет акция на товар


    public Article(){};

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public String getNumBarCode() {
        return numBarCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public void setNumBarCode(String numBarCode) {
        if(numBarCode.length()==13) {
            String regex = "\\d+";
            if(numBarCode.matches(regex)){
                this.numBarCode = numBarCode;
            }else{
                this.numBarCode = "ошибочный штрих-код";
            }
        }
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setTypeShare(boolean typeShare) {
        this.typeShare = typeShare;
    }

    public void ShowArticle(){
        System.out.println(this.getNumBarCode()+", "+ this.getName()+", "+ this.getPricePerUnit());
    }

}
