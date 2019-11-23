package org.academiadecodigo.thunderstructs;


import org.academiadecodigo.thunderstructs.enter.UserRegister;

public class Main {
    public static void main(String[] args) {


        UserRegister userRegister = new UserRegister();
        userRegister.insertUsers("Beatriz", "batata2");

        Menu menu = new Menu();
        menu.setUserRegister(userRegister);
        menu.init();


    }
}
