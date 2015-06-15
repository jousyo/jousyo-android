package jousyo.jousyo_android.db;

public class Question {

    private int season = 0;
    private int year = 0;
    private int qNum = 0;
    private String[] choices = new String[4];
    private String answer = "";

    public Question(int season, int year, int question_number) {
        this.season = season;
        this.year = year;
        this.qNum = question_number;
    }

    public Question(int season, int year, int question_number, String choices[], String answer) {
        this.season = season;
        this.year = year;
        this.qNum = question_number;
        this.choices = choices;
        this.answer = answer;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSeason() {
        return String.valueOf(season);
    }

    public String getYear() {
        return String.valueOf(year);
    }

    public String getQuestionNumber() {
        return String.valueOf(qNum);
    }

    public String[] getChoices() {
        return choices;
    }

    public String getAnswer() {
        return answer;
    }
}
