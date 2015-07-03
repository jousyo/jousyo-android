package jousyo.jousyo_android.db;

import android.content.Context;

import jousyo.jousyo_android.common.ExaminationDTO;

public class ExamController {

    DatabaseAccess dbAccess;

    public ExamController(Context context) {
        dbAccess = new DatabaseAccess(context);
    }

    private boolean validation(ExaminationDTO examination) {
        return true;
    }

    public void addExamination(ExaminationDTO examination) {

    }

    public ExaminationDTO getExamination(String category, int year, String season) {
        return null;
    }
}
