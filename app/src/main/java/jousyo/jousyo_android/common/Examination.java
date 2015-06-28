package jousyo.jousyo_android.common;

import java.util.HashMap;

public class Examination {

    private String classification;
    private int year;
    private String season;
    private HashMap<Integer, Question> questions;

    public Examination(String classification, int year, String season) {
        this.classification = classification;
        this.year = year;
        this.season = season;
    }

    public String getClassification() {
        return classification;
    }

    public String getYear() {
        return String.valueOf(year);
    }

    public String getSeason() {
        return season;
    }

    public Question getQuestion(int questionNumber) {
        return questions.get(questionNumber);
    }

    public void setQuestions(Question question) {

    }

    public int getQuestionCount() {
        return questions.size();
    }
}
