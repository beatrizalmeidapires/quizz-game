package org.academiadecodigo.thunderstructs;


public class Main {
    public static void main(String[] args) {

        App app = new App();
        app.insertUsers("Decio", "batata1");

        Menu menu = new Menu(app);

        menu.createMenu();
        menu.menuChoice();

    }
}
