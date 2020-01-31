package com;
//Интерфейс администратора (указание основных параметров концерта:
//название, цена билетов, место проведения, из которых нас интересует
//только число песен).
public class Admin extends User {
    private String nameOfConcert="Hot Tarusa Fest";
    private double price=100;
    private String position="Tarusa City, main square";
    private int surprise=3;

    public Admin(){}

    public Admin(String name, String login, char[] password){
        this.name = name;
        this.login = login;
        this.password = password;
    }
}
