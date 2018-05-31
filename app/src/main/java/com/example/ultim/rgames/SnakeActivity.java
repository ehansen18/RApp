package com.example.ultim.rgames;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class SnakeActivity extends Activity {

    SnakeEngine snakeEngine;
    private static final String EXTRA_NAME = "com.example.ultim.rgames.name";
    private static final String EXTRA_SCORE_FINAL = "com.example.ultim.rgames.finalScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the pixel dimensions of the screen
        Display display = getWindowManager().getDefaultDisplay();

        // Initialize the result into a Point object
        Point size = new Point();
        display.getSize(size);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        int finalScore = getIntent().getIntExtra(EXTRA_SCORE_FINAL, 0);

        // Create a new instance of the SnakeEngine class
        snakeEngine = new SnakeEngine(this, size, name, finalScore);

        // Make snakeEngine the view of the Activity
        setContentView(snakeEngine);
    }

    // Start the thread in snakeEngine
    @Override
    protected void onResume() {
        super.onResume();
        snakeEngine.resume();
    }

    @Override
    public void onBackPressed() {
    }

    // Stop the thread in snakeEngine
    @Override
    protected void onPause() {
        super.onPause();
        snakeEngine.pause();
    }
}
