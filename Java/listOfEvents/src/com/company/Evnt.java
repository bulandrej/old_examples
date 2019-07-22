package com.company;

import java.util.GregorianCalendar;

public class Evnt implements Comparable<Evnt>{
    /*поля
    - дата события и
	- название мероприятия*/
    GregorianCalendar data;
    String name;

    public Evnt(GregorianCalendar data, String name) {
        this.data = data;
        this.name = name;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public String getName() {
        return name;
    }

    // сравнение по дате
    @Override
    public int compareTo(Evnt o) {
        return data.compareTo(o.getData());
    }

    @Override
    public String toString() {
        return "Evnt{" +
                "data=" + data +
                ", name='" + name + '\'' +
                '}';
    }
}
