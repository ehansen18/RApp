package com.example.ultim.rgames;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class QuizHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 5;
    // Database Name
    private static final String DATABASE_NAME = "mathsone";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c
    private SQLiteDatabase dbase;
    public QuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sql);
        addQuestion();
// db.close();
    }
    private void addQuestion() {
        Question q1 = new Question("In 1991, R was created by Ross Ihaka and Robert Gentleman in the Department of Statistics at the University of _________",
                "California", "Auckland", "Harvard", "Auckland");
        this.addQuestion(q1);
        Question q2 = new Question("Finally, in _________ R version 1.0.0 was released to the public.",
                "2005", "2012", "2000", "2000");
        this.addQuestion(q2);
        Question q3 = new Question("Which of the following describes R language ?",
                "Paid", "Free", "Available for free trial only", "Free");
        this.addQuestion(q3);
        Question q4 = new Question("____ programming language is a dialect of S.", "R", "C", "K", "R");
        this.addQuestion(q4);
        Question q5 = new Question("In 2004, ________ purchased the S language from Lucent for $2 million.",
                "IBM", "Amazon", "Insightful", "Insightful");
        this.addQuestion(q5);
        Question q6 = new Question("R has how many atomic classes of objects ?", "1", "5", "4", "5");
        this.addQuestion(q6);
        Question q7 = new Question("Numbers in R are generally treated as _______ precision real numbers.",
                "double", "single", "real", "double");
        this.addQuestion(q7);
        Question q8 = new Question("Attributes of an object (if any) can be accessed using the ______ function.",
                "objects()", "attrib()", "attributes()", "attributes()");
        this.addQuestion(q8);
        Question q9 = new Question("The ___ function can be used to create vectors of objects by concatenating things together.",
                "cp()", "c()", "concat()", "c()");
        this.addQuestion(q9);
        Question q10 = new Question("Which of the following can be considered as object attribute ?",
                "dimensions", "length", "all of the mentioned", "all of the mentioned");
        this.addQuestion(q10);
        Question q11 = new Question("Which of the following is apply function in R ?",
                "tapply()", "apply()", "fapply()", "tapply()");
        this.addQuestion(q11);
        Question q12 = new Question("The syntax of the for loop is", "for ( $name in vector )\n" +
                "             statement1", "for loop( name in vector )\n" +
                "             statement1", "for ( name in vector )\n" +
                "            statement1", "for ( name in vector )\n" +
                "            statement1");
        this.addQuestion(q12);
        Question q13 = new Question("Functions are defined using the _________ directive and are stored as R objects",
                "functions()", "function()", "funct()", "function()");
        this.addQuestion(q13);
        Question q14 = new Question("Point out the wrong statement",
                "Functions provides an abstraction of the code to potential users",
                "The writing of a function allows a developer to create an interface to the code, that is explicitly specified with a set of parameters",
                "Functions in R are “second class objects”", "Functions in R are “second class objects”");
        this.addQuestion(q14);
        Question q15 = new Question("Which of the following code will print “Hello, world!” ?",
                ">  f <- function() {\n" +
                        "+              cat(\"Hello, World!\\n\")\n" +
                        "+ }\n" +
                        "> f()", "> f <- function() {\n" +
                "+              cat(\"Hello, world!\\n\")\n" +
                "+ }\n" +
                "> f()", "> f <- function() {\n" +
                "+             cat(\"Hello world!\\n\")\n" +
                "+ }\n" +
                "> f()", "> f <- function() {\n" +
                "+              cat(\"Hello, world!\\n\")\n" +
                "+ }\n" +
                "> f()");
        this.addQuestion(q15);
        Question q16 = new Question("________ loop over a list and evaluate a function on each element",
                "mapply()", "lapply()", "apply()", "apply()");
        this.addQuestion(q16);
        Question q17 = new Question("lappy functions takes _________ arguments in R language.",
                "4", "3", "5", "4");
        this.addQuestion(q17);
        Question q18 = new Question("Body of lapply function is :",
                "function (X, FUN, ...)\n" +
                        "{\n" +
                        "    FUN <- match.fun(FUN)\n" +
                        "    if (!is.vector(X) || is.object(X))\n" +
                        "       X <- as.list(X)\n" +
                        "    .Internal(lapply(X, FUN))\n" +
                        "}", "function (X, FUN, ...)\n" +
                "{\n" +
                "    FUN <- match.fun(FUN)\n" +
                "    if (!is.vector(X) | is.object(X))\n" +
                "      X <- as.list(X)\n" +
                "    .Internal(lapply(X, FUN))\n" +
                "}", "function (X, FUN, ...)\n" +
                "{\n" +
                "    FUN <- match.fun(FUN)\n" +
                "    if (is.vector(X) || is.object(X))\n" +
                "      X <- as.list(X)\n" +
                "    .Internal(lapply(X, FUN))\n" +
                "}", "function (X, FUN, ...)\n" +
                "{\n" +
                "    FUN <- match.fun(FUN)\n" +
                "    if (!is.vector(X) || is.object(X))\n" +
                "       X <- as.list(X)\n" +
                "    .Internal(lapply(X, FUN))\n" +
                "}");
        this.addQuestion(q18);
        Question q19 = new Question("What will be the output of following code ?\n" +
                "\n" +
                "> x <- list(a = 1:4, b = rnorm(10), c = rnorm(20, 1), d = rnorm(100, 5))\n" +
                "> sapply(x, mean)", "a b c d\n" +
                "3.500000 0.251483 1.481246 4.968715", "a b c d\n" +
                "2.500000 -0.251483 1.481246 4.968715", "a b c d\n" +
                "2.500000 -3.251483 2.481246 5.968715", "a b c d\n" +
                "2.500000 -0.251483 1.481246 4.968715");
        this.addQuestion(q19);
        Question q20 = new Question("The _____ function takes a vector or other objects and splits it into groups determined by a factor or list of factors.",
                "lsplit()", "split()", "mapply()", "split()");
        this.addQuestion(q20);
        Question q21 = new Question("The primary R system is available from the ______",
                "CRAN", "GNU", "CRWO", "CRAN");
        this.addQuestion(q21);
        Question q22 = new Question("Which of the following is “Recommended” package in R ?",
                "stats", "util", "spatial", "spatial");
        this.addQuestion(q22);
        Question q23 = new Question("How many packages exist in R language for statistics ?",
                "2000", "4000", "1000", "4000");
        this.addQuestion(q23);
        Question q24 = new Question("Advanced users can write ___ code to manipulate R objects directly.",
                "C", "C++", "Java", "C");
        this.addQuestion(q24);
        Question q25 = new Question("Which of the following is used for Statistical analysis in R language ?",
                "Heck", "Studio", "RStudio", "RStudio");
        this.addQuestion(q25);
// END
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
// Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
// SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
// Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_QUEST;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }
}