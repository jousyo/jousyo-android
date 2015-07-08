package jousyo.jousyo_android.db;

import android.content.Context;

import jousyo.jousyo_android.common.ExaminationDTO;

public class ExamController {

    Context context;
    DatabaseAccess dbAccess;

    public ExamController(Context context) {
        this.context = context;
        dbAccess = new DatabaseAccess(this.context);
    }

    private boolean validation(ExaminationDTO examination) {
        return true;
    }

    public void checkUpdates() {
        String repositoryURL = "https://";
    }

    public void addExamination(ExaminationDTO examination) {

    }

    public ExaminationDTO getExamination(String category, int year, String season) {
        return dbAccess.getExamination(category, year, season);
    }
}
