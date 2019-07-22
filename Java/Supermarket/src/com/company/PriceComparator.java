package com.company;
import java.util.Comparator;

public class PriceComparator implements Comparator<Article> {
    public int compare(Article a1, Article a2) {
        if ((a1.getPricePerUnit() - a2.getPricePerUnit())>0) {
            return (1);
        } else if ((a1.getPricePerUnit() - a2.getPricePerUnit())<0) {
            return (-1);
        } else return (0);
    }
}