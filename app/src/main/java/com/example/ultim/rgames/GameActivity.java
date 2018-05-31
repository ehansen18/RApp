package com.example.ultim.rgames;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity
{
    private ImageView[] mBlocks = new ImageView[9];
    private TextView mDisplay;
    private ImageView mExit, mReplay;
    private enum TURN {CIRCLE, CROSS}
    private TURN mTurn;
    private int mExitCounter = 0, mStatusCounter = 0, score;
    private static final String EXTRA_SCORE = "com.example.ultim.rgames.score";
    private static final String EXTRA_NAME = "com.example.ultim.rgames.name";
    private static final String EXTRA_SCORE_FINAL = "com.example.ultim.rgames.finalScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initialize();
    }

    private void initialize() {
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

        score = 0;

        mDisplay = (TextView) findViewById(R.id.display_board);
        mReplay = (ImageView) findViewById(R.id.replay);
        mReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent starter = getIntent();
                finish();
                starter.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(starter);
            }
        });

        for (int position = 0; position < 9; position++) {
            int resId = getResources().getIdentifier("block_" + (position + 1), "id", getPackageName());
            mBlocks[position] = (ImageView) findViewById(resId);
            final int finalPosition = position;
            mBlocks[position].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchTurn(finalPosition);
                }
            });
        }
    }

    private void switchTurn(int position) {
        if (mTurn == TURN.CIRCLE) {
            mBlocks[position].setImageResource(R.drawable.python);
            mBlocks[position].setId(GameLogic.CIRCLE);
            mTurn = TURN.CROSS;
            mDisplay.setText("R's turn");
        } else {
            mBlocks[position].setImageResource(R.drawable.symbol);
            mBlocks[position].setId(GameLogic.CROSS);
            mTurn = TURN.CIRCLE;
            mDisplay.setText("PYTHON's turn");
        }
        mBlocks[position].setEnabled(false);
        mStatusCounter++;
        if (GameLogic.isCompleted(position + 1, mBlocks)) {
            mDisplay.setText(GameLogic.getWinner() + " won");
            displayStick(GameLogic.getSet());
            disableAll();
            if (GameLogic.getWinner().equals("CROSS"))
            {
                score += 20;
            }
            String name = getIntent().getStringExtra(EXTRA_NAME);
            int finalScore = getIntent().getIntExtra(EXTRA_SCORE_FINAL, 0);
            Intent intent = new Intent(GameActivity.this, ResultActivity.class);
            intent.putExtra(EXTRA_SCORE, score);
            intent.putExtra(EXTRA_NAME, name);
            intent.putExtra(EXTRA_SCORE_FINAL, finalScore);
            startActivity(intent);
            finish();
        }else if (mStatusCounter==9){
            mDisplay.setText("DRAW. Try again");
        }
    }

    private void displayStick(int stick) {
        View view;
        switch (stick) {
            case 1:
                view = findViewById(R.id.top_horizontal);
                break;
            case 2:
                view = findViewById(R.id.center_horizontal);
                break;
            case 3:
                view = findViewById(R.id.bottom_horizontal);
                break;
            case 4:
                view = findViewById(R.id.left_vertical);
                break;
            case 5:
                view = findViewById(R.id.center_vertical);
                break;
            case 6:
                view = findViewById(R.id.right_vertical);
                break;
            case 7:
                view = findViewById(R.id.left_right_diagonal);
                break;
            case 8:
                view = findViewById(R.id.right_left_diagonal);
                break;
            default://which will never happen
                view = findViewById(R.id.top_horizontal);
        }
        view.setVisibility(View.VISIBLE);
    }

    private void disableAll() {
        for (int i = 0; i < 9; i++)
            mBlocks[i].setEnabled(false);
    }

    @Override
    public void onBackPressed() {
    }
}