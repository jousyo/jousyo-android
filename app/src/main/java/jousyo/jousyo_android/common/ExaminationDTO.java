package jousyo.jousyo_android.common;

import java.util.HashMap;

public class ExaminationDTO {

    private String category;
    private int year;
    private String season;
    private HashMap<Integer, QuestionDTO> questions;

    public String getCategory() {
        return category;
    }

    public String getYear() {
        return String.valueOf(year);
    }

    public String getSeason() {
        return season;
    }

    public QuestionDTO getQuestion(int questionNumber) {
        return questions.get(questionNumber);
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setQuestions(QuestionDTO question) {
        questions.put(question.getQuestionNumber(), question);
    }

    public int getQuestionCount() {
        return questions.size();
    }

}
