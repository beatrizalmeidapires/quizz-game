package org.academiadecodigo.thunderstructs.enter;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.thunderstructs.Menu;

import java.util.HashMap;

public class UserRegister {

    private HashMap<String, String> users;
    private boolean isValid;
    private String newUsername;
    private Login login;


    public UserRegister() {
        this.login = new Login(this);
        this.users = new HashMap();
    }

    public void register() {
        chooseUsername();
        choosePassword();
    }


    public void chooseUsername() {
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage("Please choose a username: ");
        newUsername = login.getPrompt().getUserInput(scanner);

        for (String username : users.keySet()) {

            while (newUsername.equals(username)) {
                System.out.println("Username already taken, please choose another one.");
                StringInputScanner userScanner = new StringInputScanner();
                userScanner.setMessage("New Username: ");
                newUsername = login.getPrompt().getUserInput(userScanner);
            }
        }
        System.out.println(newUsername + " is a valid username.");
    }

    //OK
    public void choosePassword() {
        Menu menu = new Menu();

        StringInputScanner pass = new StringInputScanner();

        pass.setMessage("Please choose a password: ");

        String password = login.getPrompt().getUserInput(pass);

        while (!isValid) {
            char[] chars = password.toCharArray();

            for (char c : chars) {

                if (!Character.isDigit(c)) {
                    continue;
                }

                System.out.println("Valid password: " + password + "\nThank you for register.");
                isValid = true;
                users.put(newUsername, password);
                menu.createMenu();
                menu.menuChoice();
                break;
            }

            if (!isValid) {
                System.out.println("Invalid password. Your password must contain at least one number.");
                pass.setMessage("Please choose a new password: ");
                password = login.getPrompt().getUserInput(pass);
            }
        }
    }

    public void insertUsers(String username, String password) {
        users.put(username, password);
    }

    public HashMap<String, String> getUsers() {
        return users;
    }

}
