package com.example.ultim.rgames;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Options extends Activity {

    private Button btnSnake ,btnTac,btnTrivia, logout;
    TextView textViewName, textViewScore;
    private static final String EXTRA_NAME = "com.example.ultim.rgames.name";
    private static final String EXTRA_ID = "com.example.ultim.rgames.id";
    private static final String EXTRA_SCORE = "com.example.ultim.rgames.score";
    private static final String EXTRA_SCORE_FINAL = "com.example.ultim.rgames.finalScore";
    private String name, id;
    private int score, finalScore;
    private DatabaseReference rootReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_menu);

        btnSnake = (Button) findViewById(R.id.btnSnake);
        btnTrivia = (Button) findViewById(R.id.btnTrivia);
        btnTac = (Button) findViewById(R.id.btnTac);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewScore = (TextView) findViewById(R.id.textViewScore);
        logout = (Button) findViewById(R.id.endButton);

        name = getIntent().getStringExtra(EXTRA_NAME);
        id = getIntent().getStringExtra(EXTRA_ID);
        score = getIntent().getIntExtra(EXTRA_SCORE, 0);
        finalScore = score;

        textViewName.setText("Welcome " + name + " Choose your Game");
        textViewScore.setText("Your current score is " + Integer.toString(score) + " points");

        btnSnake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this, SnakeActivity.class);
                intent.putExtra(EXTRA_NAME, name);
                intent.putExtra(EXTRA_SCORE_FINAL, finalScore);
                startActivity(intent);
                finish();
            }
        });

        btnTrivia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this, QuestionActivity.class);
                intent.putExtra(EXTRA_NAME, name);
                intent.putExtra(EXTRA_SCORE_FINAL, finalScore);
                startActivity(intent);
                finish();
            }
        });

        btnTac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this, GameActivity.class);
                intent.putExtra(EXTRA_NAME, name);
                intent.putExtra(EXTRA_SCORE_FINAL, finalScore);
                startActivity(intent);
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
    }

    public static Intent newIntent(Context packageContext, String name, String id) {
        Intent intent = new Intent(packageContext, Options.class);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_ID, id);
        return intent;
    }
}