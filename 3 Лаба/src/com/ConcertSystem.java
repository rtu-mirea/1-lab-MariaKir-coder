package com;

import java.util.*;

public class ConcertSystem {
    private static List<User> users = new ArrayList<>();
    private static int countOfSongs = 10;
    private static User currentUser;
    private static Scanner in = new Scanner(System.in);
    private static boolean end = false;
    public static void main(String[] args)
    {s
        users.add(new Admin("MK_Hacker", "admin", "1"));
        //fill();
        while(!end)
        {
            mainMenu();
            if (currentUser.getClass() == Fan.class)
            {
                Fan currentFan = (Fan) currentUser;
                fanMenu(currentFan);
            } else if (currentUser.getClass() == Admin.class)
            {
                adminMenu();
            }
        }
    }
    private static void fill(){
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
    private static void mainMenu(){
        boolean exit=false;
        while (!exit) {
            System.out.println("Do u want login(1) or sing in(2)?");
            int choice = in.nextInt();
            while (choice==1) {
                System.out.println("Enter exit to escape");
                String goBack = in.nextLine();
                if(goBack.equals("exit")){
                    break;
                }
                else {
                    System.out.println("Enter login: ");
                    String curLogin = in.nextLine();
                    System.out.println("Enter password: ");
                    String curPassword = in.nextLine();

                    User CurUser = findUser(curLogin, curPassword);
                    if (CurUser != null) {
                        currentUser = CurUser;
                        choice = 0;//exit
                        exit=true;
                    } else {
                        System.out.println("Try again.");
                    }
                }
            }
            if (choice==2){
                System.out.println("Enter name: ");
                String curName = in.nextLine();

                System.out.println("Enter login: ");
                String curLogin = in.nextLine();

                System.out.println("Enter password: ");
                String curPassword = in.nextLine();

                addUser(curName,curLogin,curPassword);

            }

        }

    }
    private static void fanMenu(Fan currentFan){
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter a command (add, show, exit)");
            String cm = in.nextLine();
            switch (cm) {
                case "add":
                    System.out.println("Enter name of the song: ");
                    String curSong = in.nextLine();
                    currentFan.addSong(curSong);
                    break;
                case "show":
                    ArrayList<String> list = (ArrayList<String>) currentFan.getSongs();
                    for(int i = 0; i<list.size();i++){
                        System.out.println(list.get(i));
                    }
                    break;
                case "exit":
                    exit=true;
                    break;
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }
    }
    private static void adminMenu(){
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter a command (stop, exit)");
            String cm = in.nextLine();
            switch (cm) {
                case "stop":
                    List<String> results = getResults();
                    for(int i=0;i<results.size();i++)
                    {
                        System.out.println((i+1)+". " + results.get(i));
                    }
                case "exit":
                    exit=true;
                    break;
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }
    }

    private static void addUser(String name, String login, String password)
    {
        User user = findUser(login,password);
        if(user==null){user = new Fan(name,login,password); users.add(user); System.out.println("New user was created");}
        else {System.out.println("This user is already exist");}
    }

    private static User findUser(String login, String password){
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).enter(login,password)){return users.get(i);}
        }
        System.out.println("Can't find this user");
        return null;
    }
    //private static void save(){}
    //private void load(){ }
    private static List <String> getResults()
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
