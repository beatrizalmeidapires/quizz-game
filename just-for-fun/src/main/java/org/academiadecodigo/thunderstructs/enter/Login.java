package org.academiadecodigo.thunderstructs.enter;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.thunderstructs.Menu;

public class Login {

    private String username;
    private String password;
    private UserRegister userRegister;
    private boolean userExist;

    Prompt prompt = new Prompt(System.in, System.out);

    public Login(UserRegister userRegister) {
       this.userRegister = userRegister;
    }

    public void doLogin() {
        Menu menu = new Menu();
        String username = enterUsername();
        checkUser(username);

        if (!isUserExist()) {
            System.out.println("It looks like you don't have an account. Please create an account first.");
            menu.init();
        }

        String pass = userRegister.getUsers().get(username);
        String password = enterPassword();


        while (!pass.equals(password)) {
            System.out.println("Password incorrect. Please insert correct password.");
            password = enterPassword();
        }
    }


    public String enterUsername() {
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage("Please enter your username: ");
        username = prompt.getUserInput(scanner);
        return username;
    }

    public String enterPassword() {
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage("Please enter your password: ");
        password = prompt.getUserInput(scanner);
        return password;
    }


    public void checkUser(String user) {
        Menu menu = new Menu();

        for (String username : userRegister.getUsers().keySet()) {

            if (username.equals(user)) {
                userExist = true;
                System.out.println("cheguei aqui");
                break;
            }

            System.out.println("User does not exist. Please create an account first...");
            userExist = false;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            menu.init();
        }
    }

    public boolean isUserExist() {
        return userExist;
    }


    public Prompt getPrompt() {
        return prompt;
    }


}
