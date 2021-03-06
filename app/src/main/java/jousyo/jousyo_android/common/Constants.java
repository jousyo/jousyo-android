package jousyo.jousyo_android.common;

public class Constants {

    // constants of database.
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "jousyo";
    public static final String TABLE_NAME = "questions";

    // Name of column.
    public static final String CATEGORY = "category";
    public static final String SEASON = "season";
    public static final String YEAR = "year";
    public static final String QUESTION_NUMBER = "question_number";
    public static final String QUESTION = "question";
    public static final String CHOICE_A = "choice_a";
    public static final String CHOICE_I = "choice_i";
    public static final String CHOICE_U = "choice_u";
    public static final String CHOICE_E = "choice_e";
    public static final String ANSWER = "answer";

    // Class of classification constants
    public static class Classification {
        public static final String FE = "FE";
        public static final String AP = "AP";
    }

    // Class of season constants
    public static class Season {
        public static final String SPRING = "spring";
        public static final String AUTUMN = "autumn";
    }
}
