package com;

import java.util.ArrayList;
import java.util.List;

public class UI extends ConcertSystem
{
    public void mainMenu(){
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
    public void fanMenu(Fan currentFan){
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
    public void adminMenu(){
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
}
