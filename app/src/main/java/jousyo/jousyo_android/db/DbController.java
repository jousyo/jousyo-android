package jousyo.jousyo_android.db;

import android.content.Context;

public class DbController {

    DatabaseAccess dbAccess;

    public DbController(Context context) {
        dbAccess = new DatabaseAccess(context);
    }

    // FIXME: Azama
    private boolean validation(Question question) {


        return true;
    }

    public Question getQuestion(int season, int year, int question_number) {
        Question question = new Question(season, year, question_number);
        return dbAccess.getQuestion(question);
    }

    public void addQuestion(Question question) {
        dbAccess.addQuestion(question);
    }
}
