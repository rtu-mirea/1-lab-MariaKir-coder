package com;

public class User {
    protected String name;
    protected  String login;
    protected  String password;

    public User(){}

    public User(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }

    boolean enter(String login, String password) {
        if (this.login.equals(login) && this.password.equals(password))
        {
            return true;
        }
        //else if(!this.login.equals(login)){System.out.println("Wrong login"); return false;}
        //else if(!this.password.equals(password)){System.out.println("Wrong password"); return false;}
        //else{System.out.println("Unknown error"); return false;}
        else return false;
    }

    String getName(){
        return name;
    }
}
