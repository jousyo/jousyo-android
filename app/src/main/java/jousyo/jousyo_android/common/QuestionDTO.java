package jousyo.jousyo_android.common;

import java.util.HashMap;

public class QuestionDTO {
    private int questionNumber;
    private String question;
    private HashMap<String, String> choices;
    private String answer;

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setChoices(String choiceA, String choiceI, String choiceU, String choiceE) {
        this.choices.put(Constants.CHOICE_A, choiceA);
        this.choices.put(Constants.CHOICE_I, choiceI);
        this.choices.put(Constants.CHOICE_U, choiceU);
        this.choices.put(Constants.CHOICE_E, choiceE);
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoiceA() {
        return choices.get(Constants.CHOICE_A);
    }

    public String getChoiceI() {
        return choices.get(Constants.CHOICE_I);
    }

    public String getChoiceU() {
        return choices.get(Constants.CHOICE_U);
    }

    public String getChoiceE() {
        return choices.get(Constants.CHOICE_E);
    }

    public String getAnswer() {
        return answer;
    }

    public boolean checkingAnswer(String answer) {
        if ( this.answer.equals(answer) )
            return true;
        else
            return false;
    }
}
