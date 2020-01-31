package com;

public class User {
    protected String name;
    protected  String login;
    protected char[] password;

    public User(){}

    public User(String name, String login, char[] password){
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public boolean enter(String login, char[] password) {
        if (this.login.equals(login) && this.password.equals(password))
        {
            return true;
        }
        //else if(!this.login.equals(login)){System.out.println("Wrong login"); return false;}
        //else if(!this.password.equals(password)){System.out.println("Wrong password"); return false;}
        //else{System.out.println("Unknown error"); return false;}
        else return false;
    }

    public String getName(){
        return name;
    }
    public char[] getPassword() { return password; }
    public String getLogin() { return login; }
}
