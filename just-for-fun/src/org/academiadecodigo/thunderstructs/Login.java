package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;


public class Login {

    private String username;
    private String password;
    Prompt prompt = new Prompt(System.in, System.out);


    public String doLogin() {

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


    public Prompt getPrompt() {
        return prompt;
    }
}
