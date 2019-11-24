package org.academiadecodigo.thunderstructs;


import org.academiadecodigo.thunderstructs.enter.UserRegister;

public class Main {
    public static void main(String[] args) {


        //frame();
        UserRegister userRegister = new UserRegister();
        userRegister.insertUsers("Beatriz", "batata2");

        Menu menu = new Menu();
        menu.setUserRegister(userRegister);
        menu.init();



    }
    /*    public static void frame() {

            Frame frame = new Frame();
            frame.setSize(1024, 760);
            frame.setVisible(true);

            Font myFont = new Font("Serif", Font.BOLD, 60);
            Label questionLabel = new Label(Questions.FRANCE);
            questionLabel.setFont(myFont);
            questionLabel.setBounds(0, 0, 500, 60);
            frame.add(questionLabel);

            Button answer1 = new Button("resposta");
            answer1.setBounds(0, 80, 120, 60);
            frame.add(answer1);
        }*/
}
