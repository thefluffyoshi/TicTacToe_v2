package com.example.tictactoev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class AI_board extends AppCompatActivity {

    private tttAI AI = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_board);

        Intent intent = getIntent();
        int diff = intent.getIntExtra("difficulty", 1);

        AI = new tttAI(diff);
    }
}