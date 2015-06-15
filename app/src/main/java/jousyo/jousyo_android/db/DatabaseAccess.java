package jousyo.jousyo_android.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public synchronized void close() {
        super.close();
    }

    public void addQuestion(Question question) {
        ContentValues values = new ContentValues();

        values.put(SEASON, question.getSeason());
        values.put(YEAR, question.getYear());
        values.put(QUESTION_NUMBER, question.getQuestionNumber());
        values.put(CHOICE_A, question.getChoices()[0]);
        values.put(CHOICE_I, question.getChoices()[1]);
        values.put(CHOICE_U, question.getChoices()[2]);
        values.put(CHOICE_E, question.getChoices()[3]);
        values.put(ANSWER, question.getAnswer());

        db.insert(TABLE_NAME, null, values);
    }

    public Question getQuestion(Question question) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                        SEASON + "=? AND " +
                        YEAR + "=? AND " +
                        QUESTION_NUMBER + "=?;";

        String where[] = {
                question.getSeason(),
                question.getYear(),
                question.getQuestionNumber()
        };

        Cursor cursor = db.rawQuery(sql, where);
        if (cursor.moveToNext()) {
            int indexChoiceA = cursor.getColumnIndex(CHOICE_A);
            int indexChoiceI = cursor.getColumnIndex(CHOICE_I);
            int indexChoiceU = cursor.getColumnIndex(CHOICE_U);
            int indexChoiceE = cursor.getColumnIndex(CHOICE_E);
            int indexAnswer = cursor.getColumnIndex(ANSWER);
            question.setChoices(
                    new String[]{
                            cursor.getString(indexChoiceA),
                            cursor.getString(indexChoiceI),
                            cursor.getString(indexChoiceU),
                            cursor.getString(indexChoiceE)
                    });
            question.setAnswer(cursor.getString(indexAnswer));
        }

        return question;
    }
}
