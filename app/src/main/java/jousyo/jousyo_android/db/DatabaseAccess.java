package jousyo.jousyo_android.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import jousyo.jousyo_android.common.ExaminationDTO;

import jousyo.jousyo_android.common.Constants;
import jousyo.jousyo_android.common.QuestionDTO;

public class DatabaseAccess extends SQLiteOpenHelper {

    SQLiteDatabase db = this.getWritableDatabase();

    public DatabaseAccess(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + Constants.TABLE_NAME + " (" +
                Constants.SEASON + " INTEGER," +
                Constants.YEAR + " INTEGER," +
                Constants.QUESTION_NUMBER + " INTEGER," +
                Constants.CHOICE_A + " TEXT," +
                Constants.CHOICE_I + " TEXT," +
                Constants.CHOICE_U + " TEXT," +
                Constants.CHOICE_E + " TEXT," +
                Constants.ANSWER + " TEXT)";

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
            values.put(Constants.CATEGORY, examination.getCategory());
            values.put(Constants.SEASON, examination.getSeason());
            values.put(Constants.YEAR, examination.getYear());
            values.put(Constants.QUESTION_NUMBER, i);
            values.put(Constants.QUESTION, examination.getQuestion(i).getQuestion());
            values.put(Constants.CHOICE_A, examination.getQuestion(i).getChoiceA());
            values.put(Constants.CHOICE_I, examination.getQuestion(i).getChoiceI());
            values.put(Constants.CHOICE_U, examination.getQuestion(i).getChoiceU());
            values.put(Constants.CHOICE_E, examination.getQuestion(i).getChoiceE());
            values.put(Constants.ANSWER, examination.getQuestion(i).getAnswer());

            db.insert(Constants.TABLE_NAME, null, values);
        }
    }

    public ExaminationDTO getExamination(String category, int year, String season) {
        ExaminationDTO examination = new ExaminationDTO();
        examination.setCategory(category);
        examination.setYear(year);
        examination.setSeason(season);

        String sql = "SELECT * FROM " + Constants.TABLE_NAME + " WHERE " +
                Constants.CATEGORY + "=? AND" +
                Constants.SEASON + "=? AND " +
                Constants.YEAR + "=?;";

        String where[] = {category, String.valueOf(year), season};

        Cursor cursor = db.rawQuery(sql, where);
        while (cursor.moveToNext()) {
            int indexQuestionNumber = cursor.getColumnIndex(Constants.QUESTION_NUMBER);
            int indexQuestion = cursor.getColumnIndex(Constants.QUESTION);
            int indexChoiceA = cursor.getColumnIndex(Constants.CHOICE_A);
            int indexChoiceI = cursor.getColumnIndex(Constants.CHOICE_I);
            int indexChoiceU = cursor.getColumnIndex(Constants.CHOICE_U);
            int indexChoiceE = cursor.getColumnIndex(Constants.CHOICE_E);
            int indexAnswer = cursor.getColumnIndex(Constants.ANSWER);

            QuestionDTO question = new QuestionDTO();
            question.setQuestionNumber(Integer.getInteger(cursor.getString(indexQuestionNumber)));
            question.setQuestion(cursor.getString(indexQuestion));
            question.setChoices(cursor.getString(indexChoiceA),
                    cursor.getString(indexChoiceI),
                    cursor.getString(indexChoiceU),
                    cursor.getString(indexChoiceE));
            question.setAnswer(cursor.getString(indexAnswer));

            examination.setQuestions(question);
        }

        return examination;
    }
}
