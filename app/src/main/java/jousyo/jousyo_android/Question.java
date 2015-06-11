package jousyo.jousyo_android;

/**
 * Created by azama on 2015/06/11.
 */
public class Question {
    private int number;
    private String[] choices = new String[4];
    private String answer;

    Question(int number, String choices[], String answer) {
        this.number = number;
        this.choices = choices;
        this.answer = answer;
    }

    public int getNumber() {
        return number;
    }

    public String[] getChoices() {
        return choices;
    }

    public String getAnswer() {
        return answer;
    }
}
