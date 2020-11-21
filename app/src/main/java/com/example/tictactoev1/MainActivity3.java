package com.example.tictactoev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

//        TextView winner = (TextView) findViewById(R.id.winnerTV);
//        winner.setText("X wins");
    }

    public void onClickPlayAgain(View view)
    {
        startActivity(new Intent(MainActivity3.this, MainActivity2.class));
    }
}