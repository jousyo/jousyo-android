package jousyo.jousyo_android.common;

import java.util.Map;

import static jousyo.jousyo_android.common.Constants.*;

public class Question {

    private int questionNumber;
    private String question;
    private Map<String, String> choices;
    private String answer;

    public Question(String question, String choiceA, String choiceI, String choiceU,
                    String choiceE, String answer) {
        this.question = question;
        this.choices.put(CHOICE_A, choiceA);
        this.choices.put(CHOICE_I, choiceI);
        this.choices.put(CHOICE_U, choiceU);
        this.choices.put(CHOICE_E, choiceE);
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoiceA() {
        return choices.get(CHOICE_A);
    }

    public String getChoiceI() {
        return choices.get(CHOICE_I);
    }

    public String getChoiceU() {
        return choices.get(CHOICE_U);
    }

    public String getChoiceE() {
        return choices.get(CHOICE_E);
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
