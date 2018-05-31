package com.example.ultim.rgames;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuestionActivity extends Activity {
    List<Question> quesList;
    int score = 0;
    int qid = 0;
    Question currentQ;
    TextView txtQuestion, times, scored;
    private ImageView mExit;
    Button button1, button2, button3;
    private int mExitCounter = 0;
    private static final String EXTRA_SCORE = "com.example.ultim.rgames.score";
    private static final String EXTRA_NAME = "com.example.ultim.rgames.name";
    private static final String EXTRA_SCORE_FINAL = "com.example.ultim.rgames.finalScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        QuizHelper db = new QuizHelper(this); // my question bank class
        quesList = db.getAllQuestions(); // this will fetch all questions
        currentQ = quesList.get(qid); // the current question
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
// the textview in which the question will be displayed
// the three buttons,
// the idea is to set the text of three buttons with the options from question bank
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
// the textview in which score will be displayed
        scored = (TextView) findViewById(R.id.score);
// the timer
        times = (TextView) findViewById(R.id.timers);
// method which will set the things up for our game
        setQuestionView();
        times.setText("00:02:00");
// A timer of 60 seconds to play for, with an interval of 1 second (1000 milliseconds)
        CounterClass timer = new CounterClass(120000, 1000);
        timer.start();
// button click listeners
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// passing the button text to other method
// to check whether the anser is correct or not
// same for all three buttons
                getAnswer(button1.getText().toString());
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button2.getText().toString());
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button3.getText().toString());
            }
        });

        mExit = (ImageView) findViewById(R.id.exit);
        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mExitCounter == 1) {
                    finish();
                    System.exit(0);
                } else {
                    mExitCounter++;
                    Toast.makeText(getApplicationContext(), "Press again to exit", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void getAnswer(String AnswerString) {
        if (currentQ.getANSWER().equals(AnswerString)) {
// if conditions matches increase the int (score) by 1
// and set the text of the score view
            score += 10;
            scored.setText("Score : " + score);
        } else {
// if unlucky start activity and finish the game
            String name = getIntent().getStringExtra(EXTRA_NAME);
            int finalScore = getIntent().getIntExtra(EXTRA_SCORE_FINAL, 0);
            Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
            intent.putExtra(EXTRA_SCORE, score);
            intent.putExtra(EXTRA_NAME, name);
            intent.putExtra(EXTRA_SCORE_FINAL, finalScore);
            startActivity(intent);
            finish();
        }
        if (qid < quesList.size()) {
// if questions are not over then do this
            currentQ = quesList.get(qid);
            setQuestionView();
        } else {
// if over do this
            String name = getIntent().getStringExtra(EXTRA_NAME);
            int finalScore = getIntent().getIntExtra(EXTRA_SCORE_FINAL, 0);
            Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
            intent.putExtra(EXTRA_SCORE, score);
            intent.putExtra(EXTRA_NAME, name);
            intent.putExtra(EXTRA_SCORE_FINAL, finalScore);
            startActivity(intent);
            finish();
        }
    }
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
// TODO Auto-generated constructor stub
        }
        @Override
        public void onFinish() {
            times.setText("Time is up");
            String name = getIntent().getStringExtra(EXTRA_NAME);
            int finalScore = getIntent().getIntExtra(EXTRA_SCORE_FINAL, 0);
            Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
            intent.putExtra(EXTRA_SCORE, score);
            intent.putExtra(EXTRA_NAME, name);
            intent.putExtra(EXTRA_SCORE_FINAL, finalScore);
            startActivity(intent);
            finish();
        }
        @Override
        public void onTick(long millisUntilFinished) {
// TODO Auto-generated method stub
            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);
        }
    }

    @Override
    public void onBackPressed() {
    }

    private void setQuestionView() {
// the method which will put all things together
        txtQuestion.setText(currentQ.getQUESTION());
        button1.setText(currentQ.getOPTA());
        button2.setText(currentQ.getOPTB());
        button3.setText(currentQ.getOPTC());
        qid++;
    }
}