package jousyo.jousyo_android.common;

import java.util.HashMap;

import static jousyo.jousyo_android.common.Constants.CHOICE_A;
import static jousyo.jousyo_android.common.Constants.CHOICE_E;
import static jousyo.jousyo_android.common.Constants.CHOICE_I;
import static jousyo.jousyo_android.common.Constants.CHOICE_U;

public class ExaminationDTO {

    private String category;
    private int year;
    private String season;
    private HashMap<Integer, Question> questions;

    public class Question {

        private int questionNumber;
        private String question;
        private HashMap<String, String> choices;
        private String answer;

        public void setQuestionNumber(int questionNumber) {
            this.questionNumber = questionNumber;
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

    public String getCategory() {
        return category;
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

    public void setCategory(String category) {
        this.category = category;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setQuestions(Question question) {

    }

    public int getQuestionCount() {
        return questions.size();
    }

}
