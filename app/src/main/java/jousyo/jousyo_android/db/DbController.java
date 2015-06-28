package jousyo.jousyo_android.db;

import android.content.Context;

import jousyo.jousyo_android.common.Examination;
import jousyo.jousyo_android.common.Question;

public class ExamController {

    DatabaseAccess dbAccess;

    public DatabasebController(Context context) {
        dbAccess = new DatabaseAccess(context);
    }

    private boolean validation(Question question) {
        return true;
    }

    public Question getExamination(int questionNumber) {
        Question question = new Question(questionNumber);
        return dbAccess.getQuestion(question);
    }

    public void addQuestion(Examination examination) {
        dbAccess.addExamination(examination);
    }
}
