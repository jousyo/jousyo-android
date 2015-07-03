package jousyo.jousyo_android.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import jousyo.jousyo_android.common.ExaminationDTO;
import jousyo.jousyo_android.common.ExaminationDTO;

import static jousyo.jousyo_android.common.Constants.*;

public class DatabaseAccess extends SQLiteOpenHelper {

    SQLiteDatabase db = this.getWritableDatabase();

    public DatabaseAccess(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" +
                SEASON + " INTEGER," +
                YEAR + " INTEGER," +
                QUESTION_NUMBER + " INTEGER," +
                CHOICE_A + " TEXT," +
                CHOICE_I + " TEXT," +
                CHOICE_U + " TEXT," +
                CHOICE_E + " TEXT," +
                ANSWER + " TEXT)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public synchronized void close() {
        super.close();
    }

    public void addExamination(ExaminationDTO examination) {
        ContentValues values = new ContentValues();

        for (int i = 1; examination.getQuestionCount() <= i; i++) {
            values.put(CATEGORY, examination.getCategory());
            values.put(SEASON, examination.getSeason());
            values.put(YEAR, examination.getYear());
            values.put(QUESTION_NUMBER, i);
            values.put(QUESTION, examination.getQuestion(i).getQuestion());
            values.put(CHOICE_A, examination.getQuestion(i).getChoiceA());
            values.put(CHOICE_I, examination.getQuestion(i).getChoiceI());
            values.put(CHOICE_U, examination.getQuestion(i).getChoiceU());
            values.put(CHOICE_E, examination.getQuestion(i).getChoiceE());
            values.put(ANSWER, examination.getQuestion(i).getAnswer());

            db.insert(TABLE_NAME, null, values);
        }
    }

    public ExaminationDTO getExamination(String category, int year, String season) {
        ExaminationDTO examination = new ExaminationDTO();
        examination.setCategory(category);
        examination.setYear(year);
        examination.setSeason(season);

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                        CATEGORY + "=? AND" +
                        SEASON + "=? AND " +
                        YEAR + "=?;";

        String where[] = {category, String.valueOf(year), season};

        Cursor cursor = db.rawQuery(sql, where);
        while (cursor.moveToNext()) {
            int indexQuestion = cursor.getColumnIndex(QUESTION);
            int indexChoiceA = cursor.getColumnIndex(CHOICE_A);
            int indexChoiceI = cursor.getColumnIndex(CHOICE_I);
            int indexChoiceU = cursor.getColumnIndex(CHOICE_U);
            int indexChoiceE = cursor.getColumnIndex(CHOICE_E);
            int indexAnswer = cursor.getColumnIndex(ANSWER);
            ExaminationDTO.Question question;
            question
            ExaminationDTO.Question question = new Question(
                    cursor.getString(indexQuestion),
                    cursor.getString(indexChoiceA),
                    cursor.getString(indexChoiceI),
                    cursor.getString(indexChoiceU),
                    cursor.getString(indexChoiceE),
                    cursor.getString(indexAnswer)
            );
            examination.setQuestions();
        }

        return examination;
    }
}
