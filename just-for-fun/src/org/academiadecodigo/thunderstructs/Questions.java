package org.academiadecodigo.thunderstructs;


import java.util.HashMap;

public class Questions {

    HashMap<String, String> questions = new HashMap<>();

    public static final String PORTUGAL = "What's the capital of Portugal?";
    public static final String UNITED_KINGDOM = "What's the capital of United Kingdom?";
    public static final String FRANCE = "What's the capital of France?";
    public static final String GERMANY = "What's the capital of Germany?";
    public static final String SPAIN = "What's the capital of Spain?";
    public static final String ITALY = "What's the capital of Italy?";
    public static final String SWITZERLAND = "What's the capital of Switzerland?";
    public static final String GREECE = "What's the capital of Greece?";
    public static final String NETHERLANDS = "What's the capital of Netherlands?";

    public void addQuestions() {

        questions.put(Questions.PORTUGAL, Answers.LISBON_ANSWER);
        questions.put(Questions.UNITED_KINGDOM, Answers.LONDON_ANSWER);
        questions.put(Questions.FRANCE, Answers.PARIS_ANSWER);
        questions.put(Questions.GERMANY, Answers.BERLIN_ANSWER);
        questions.put(Questions.GREECE, Answers.ATHENS_ANSWER);
        questions.put(Questions.ITALY, Answers.ROME_ANSWER);
        questions.put(Questions.NETHERLANDS, Answers.AMESTERDAM_ANSWER);
        questions.put(Questions.SPAIN, Answers.MADRID_ANSWER);
        questions.put(Questions.SWITZERLAND, Answers.ZURICH_ANSWER);
    }

    public HashMap<String, String> getQuestions() {
        return questions;
    }
}
