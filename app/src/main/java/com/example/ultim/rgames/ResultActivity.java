package com.example.ultim.rgames;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ResultActivity extends Activity {
    private int score, finalScore;
    private static final String EXTRA_SCORE = "com.example.ultim.rgames.score";
    private static final String EXTRA_NAME = "com.example.ultim.rgames.name";
    private static final String EXTRA_SCORE_FINAL = "com.example.ultim.rgames.finalScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        finalScore = getIntent().getIntExtra(EXTRA_SCORE_FINAL, 0);

        TextView textResult = (TextView) findViewById(R.id.textResult);
        score = getIntent().getIntExtra(EXTRA_SCORE, 0);
        textResult.setText("Your score is " + " " + score + ". Thanks for playing.");
        score += finalScore;
    }
    @Override
    public void onBackPressed() {
    }
    public void playagain(View o) {
        String name = getIntent().getStringExtra(EXTRA_NAME);
        Intent intent = new Intent(this, Options.class);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_SCORE, score);
        startActivity(intent);
        finish();
    }
}