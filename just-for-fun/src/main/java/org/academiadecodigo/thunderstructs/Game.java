package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.thunderstructs.contentLevel1.Questions;


public class Game {

    private Prompt prompt = new Prompt(System.in, System.out);
    private int points;
    private int wrongAnswers;
    private int questionsCounter;

    public Game() {
        this.points = 0;
        this.wrongAnswers = 0;
    }


    public void init() {

        Questions.addQuestions();

        MyThread myThread = new MyThread();
        myThread.start();

        for (String string : Questions.getQuestions().keySet()) {
            StringInputScanner scanner = new StringInputScanner();
            scanner.setMessage("\n".concat(string));
            questionsCounter++;
            String answer = prompt.getUserInput(scanner);

            if (answer.equals(Questions.getQuestions().get(string))) {
                System.out.println("Well done! 1 point");
                points++;
            } else {
                System.out.println("Wrong answer, keep going!");
                wrongAnswers++;
            }
        }
    }


    private class MyThread extends Thread {

        public void time() {
            for (int i = 0; i < 20; i++) {
                Menu.threadSleep(1000);
                if (i == 19) {
                    System.out.println("\n \n********************* TIME OUT ********************* \n \n Total questions answered: " + questionsCounter + "\n Your score: " + points + "\n Wrong answers: " + wrongAnswers);
                    System.exit(1);
                }
            }
        }

        @Override
        public void run() {
            time();
        }
    }
}



