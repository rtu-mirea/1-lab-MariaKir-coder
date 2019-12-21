package com;

import java.util.ArrayList;
import java.util.List;

public class Fan extends User
{
    private List<String> songs = new ArrayList<String>();

    public Fan(){}

    public Fan(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public void addSong (String song){
        if(!songs.contains(song))
            songs.add(song);
        else System.out.println("Already added");
    }

    public List<String> getSongs(){
        return songs;
    }

}
