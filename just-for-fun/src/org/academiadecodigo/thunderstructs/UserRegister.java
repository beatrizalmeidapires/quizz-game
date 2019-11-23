package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class UserRegister {

    private boolean isValid;
    private String newUsername;
    private Login login;
    private App app;


    public UserRegister() {
        this.app = new App();
        this.login = new Login();
    }

    public void chooseUsername() {
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage("Please choose a username: ");
        newUsername = login.getPrompt().getUserInput(scanner);
        for (String username : app.getUsers().keySet()) {

            while (newUsername.equals(username)) {
                System.out.println("Username already taken, please choose another one.");
                StringInputScanner userScanner = new StringInputScanner();
                userScanner.setMessage("New Username: ");
                newUsername = login.getPrompt().getUserInput(userScanner);
            }
            System.out.println(newUsername + " is a valid username.");
        }
    }

    public void choosePassword() {
        Menu menu = new Menu(app);

        StringInputScanner pass = new StringInputScanner();
        pass.setMessage("Please choose a password: ");
        String password = login.getPrompt().getUserInput(pass);

        while (!isValid) {
            char[] chars = password.toCharArray();

            for (char c : chars) {

                if (!Character.isDigit(c)) {
                    continue;
                }

                System.out.println("Valid password: " + password + ". Thank you for register.");
                isValid = true;
                app.getUsers().put(newUsername, password);
                menu.createMenu();
                menu.menuChoice();
                break;
            }

            if(!isValid) {
                System.out.println("Invalid password. Your password must contain at least one number.");
                pass.setMessage("Please choose a new password: ");
                password = login.getPrompt().getUserInput(pass);
            }
        }
    }
}
