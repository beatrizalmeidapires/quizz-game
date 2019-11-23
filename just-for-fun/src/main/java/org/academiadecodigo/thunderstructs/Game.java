package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.thunderstructs.content.Questions;


public class Game {
    private Prompt prompt = new Prompt(System.in, System.out);


    public void init() {
        int points = 0;
        int wrongAnswers = 0;

        Questions questions = new Questions();
        questions.addQuestions();

        for (String string : questions.getQuestions().keySet()) {
            StringInputScanner scanner = new StringInputScanner();
            scanner.setMessage(string);
            String answer = prompt.getUserInput(scanner);

            if (answer.equals(questions.getQuestions().get(string))) {
                System.out.println("Well done! 1 point");
                points++;
            } else {
                System.out.println("Wrong answer, keep going!");
                wrongAnswers++;
            }
        }
        System.out.println("********************* End of game ********************* \n Total questions: " + questions.getQuestions().keySet().size() + "\n Your score: " + points + "\n Wrong answers: " + wrongAnswers);
    }



       /* Frame frame = new Frame();
        frame.setSize(1024,760);
        frame.setVisible(true);

        addQuestions();

        Font myFont = new Font("Serif",Font.BOLD,60);
        Label questionLabel = new Label(Messages.LISBON);
        questionLabel.setFont(myFont);
        questionLabel.setBounds(0,0,500,60);
        frame.add(questionLabel);

        Button answer1 = new Button("resposta");
        answer1.setBounds(0, 80, 120,60);
        frame.add(answer1);*/



}



