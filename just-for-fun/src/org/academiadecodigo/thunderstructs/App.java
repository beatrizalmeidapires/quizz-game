package org.academiadecodigo.thunderstructs;

import java.util.HashMap;

public class App {

    private HashMap<String, String> users;
    private boolean userExist;

    public App(){
        this.users = new HashMap();
    }

    public void insertUsers(String username, String password){
        users.put(username, password);
    }

    public void checkUser(String user){
        Menu menu = new Menu(this);
        for (String username : users.keySet()) {
            if(username.equals(user)){
                userExist = true;
                break;
            }
            System.out.println("User does not exist. Please create an account first...");
            userExist = false;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            menu.createMenu();
            menu.menuChoice();
        }
    }

    public boolean isUserExist() {
        return userExist;
    }

    public HashMap<String, String> getUsers() {
        return users;
    }
}
