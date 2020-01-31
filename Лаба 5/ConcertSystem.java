package com;
import java.util.*;

public class ConcertSystem {

    public static FanW fanW = new FanW();
    public static AdminW adminW = new AdminW();
    public static Signin signin = new Signin();
    public static Login login = new Login();

    public static void main(String[] args) {

        login.setVisible(true);
        Admin admin = new Admin("MK_Hacker", "admin", "1".toCharArray());
        login.users.add(admin);

    }

}
