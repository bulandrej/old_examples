package com.company;

public class Pet {

    private String type; // вид
    private String nickname; // кличка
    private int age;
    private String nameOwner;

    public Pet(){};

    public Pet(String type, String nickname, int age, String nameOwner) {
        this.type = type;
        this.nickname = nickname;
        this.age = age;
        this.nameOwner = nameOwner;
    }

    public String getType() {
        return type;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public String getNameOwner() {
        return nameOwner;
    }
}
