package org.academiadecodigo.thunderstructs;


import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.thunderstructs.enter.Login;
import org.academiadecodigo.thunderstructs.enter.UserRegister;

public class Menu {

    private Prompt prompt;
    private UserRegister userRegister;
    private int answerIndex;
    private int initialAnswer;

    public Menu() {
        this.prompt = new Prompt(System.in, System.out);
    }

    public void init() {
        initialMenu();
        loginOrRegister();
        createMenu();
        menuChoice();
    }

    public void initialMenu() {
        String[] options = {"Register", "Login"};
        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Please choose one of the following options:");
        initialAnswer = prompt.getUserInput(menu);
    }


    public void loginOrRegister() {
        Login login = new Login(userRegister);

        switch (initialAnswer) {
            case 1:
                userRegister.register();
                break;
            case 2:
                login.doLogin();
                break;
        }
    }

    public int chooseGameLevel(){
        String[] options = {"Easy Peasy", "Medium", "Hard as fuck"};
        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Please choose one of the following options:");
        return answerIndex = prompt.getUserInput(menu);
    }

    public void createMenu() {
        String[] options = {"Play", "Instructions", "Quit"};
        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Please choose one of the following options:");
        answerIndex = prompt.getUserInput(menu);
    }

    public void goBackOption() {
        String[] option = {"Go Back"};
        MenuInputScanner menu = new MenuInputScanner(option);
        menu.setMessage("Please press 1 to go back to the main menu.");
        int answerIndex = prompt.getUserInput(menu);

        switch (answerIndex) {
            case 1:
                createMenu();
                break;
        }
    }

    public void pressPlay(){
        Game game = new Game();
        int answer = chooseGameLevel();
        switch (answer) {
            case 1:
                System.out.println("Starting the game, please wait...");
                System.out.println("-------------------------------------------------------------------------------");
                threadSleep(2000);
                game.init();
                System.exit(1);
                break;
            case 2:
                System.out.println("under construction");
                break;
            case 3:
                System.out.println("under construction");
                break;
        }
    }


    public void menuChoice() {
        switch (answerIndex) {
            case 1:
                pressPlay();
                break;
            case 2:
                System.out.println("=> The game is in English. \n" + "=> Answers are case sensitive, please remember to use uppercase letters on names of countries and cities. \n" +
                        "=> If you answer correctly you get one point, if you fail you don't get anything.");
                threadSleep(4000);
                goBackOption();
                break;
            case 3:
                System.exit(1);
                break;
        }
    }

    public static void threadSleep(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setUserRegister(UserRegister userRegister) {
        this.userRegister = userRegister;
    }
}

