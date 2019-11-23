package org.academiadecodigo.thunderstructs;


import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Menu {

    private Login login;
    private App app;
    private int answerIndex;


    public Menu(App app) {
        this.app = app;
        this.login = new Login();
    }

    public void login() {
        String username = login.doLogin();
        app.checkUser(username);

        String pass = app.getUsers().get(username);
        String password = login.enterPassword();

        if (!app.isUserExist()) {
            System.out.println("It looks like you don't have an account. Please create an account first.");
            createMenu();
            menuChoice();
        }

        while (!pass.equals(password)) {
            System.out.println("Password incorrect. Please insert correct password.");
            password = login.enterPassword();
        }
    }


    public void createMenu() {
        String[] options = {"Play", "Create an Account", "Instructions", "Quit", "Go Back"};
        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Please choose one of the following options:");
        answerIndex = login.getPrompt().getUserInput(menu);
    }


    public void menuChoice() {
        Game game = new Game();
        UserRegister userRegister = new UserRegister();

        switch (answerIndex) {
            case 1:
                login();
                System.out.println("Starting the game, please wait...");
                System.out.println("-------------------------------------------------------------------------------");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                game.start();
                break;
            case 2:
                userRegister.chooseUsername();
                userRegister.choosePassword();
                break;
            case 3:
                System.out.println("Under construction");
                break;
            case 4:
                System.exit(1);

        }
    }
}

