package com;

import java.util.*;

public class ConcertSystem {
    protected static List<User> users = new ArrayList<>();
    protected static User currentUser;
    protected static UI ui = new UI();
    protected static boolean end = false;

    protected int countOfSongs = 10;
    protected Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        users.add(new Admin("MK_Hacker", "admin", "1"));
        //fill();
        while(!end)
        {
            ui.mainMenu();
            if (currentUser.getClass() == Fan.class)
            {
                Fan currentFan = (Fan) currentUser;
                ui.fanMenu(currentFan);
            } else if (currentUser.getClass() == Admin.class)
            {
                ui.adminMenu();
            }
        }
    }
    protected void fill(){
        Fan fan = new Fan("Fan 1", "1", "1");
        fan.addSong("song 1");
        fan.addSong("song 2");
        users.add(fan);

        fan = new Fan("Fan 2", "2", "2");
        fan.addSong("song 1");
        users.add(fan);

        fan = new Fan("Fan 3", "3", "3");
        fan.addSong("song 2");
        users.add(fan);

        fan = new Fan("Fan 4", "4", "4");
        fan.addSong("song 2");
        users.add(fan);

        fan = new Fan("Fan 5", "5", "5");
        fan.addSong("song 2");
        users.add(fan);
    }

    protected void addUser(String name, String login, String password)
    {
        User user = findUser(login,password);
        if(user==null){user = new Fan(name,login,password); users.add(user); System.out.println("New user was created");}
        else {System.out.println("This user is already exist");}
    }

    protected User findUser(String login, String password){
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).enter(login,password)){return users.get(i);}
        }
        System.out.println("Can't find this user");
        return null;
    }

    protected List <String> getResults()
    {
        end = true;
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        List<String> result = new ArrayList<>();
        for (int i = 1; i < users.size(); i++)
        {
            Fan cur_fan = (Fan) users.get(i);
            List<String> curr_fan_songs = cur_fan.getSongs();
            for (int j = 0; j < curr_fan_songs.size(); j++)
            {
                if (dictionary.keySet().contains(curr_fan_songs.get(j)))
                {
                    int voices = dictionary.get(curr_fan_songs.get(j)) + 1;
                    dictionary.put(curr_fan_songs.get(j), voices);
                } else dictionary.put(curr_fan_songs.get(j), 1);
            }
        }
        while(!dictionary.isEmpty() && result.size() < countOfSongs)
        {
            int max = 0;
            String str = "";
            for (Map.Entry<String, Integer> entry : dictionary.entrySet())
            {
                if (entry.getValue() >= max)
                {
                    max = entry.getValue();
                    str = entry.getKey();
                }
            }
            result.add(str);
            dictionary.remove(str);
        }
        return result;
    }
}
