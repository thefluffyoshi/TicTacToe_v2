package com.example.tictactoev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    SeekBar diffbar = findViewById(R.id.diffseekbar);
    TextView diffname = findViewById(R.id.diffname);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        diffbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch(progress) {
                    case 0:
                        diffname.setText("Easy");
                        break;
                    case 1:
                        diffname.setText("Medium");
                        break;
                    case 2:
                        diffname.setText("Hard");
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void onClickPage2(View view)
    {
        startActivity(new Intent(MainActivity2.this, MainActivity.class));
    }

    public void onVsAI(View view)
    {
        Intent aiintent = new Intent(MainActivity2.this, AI_board.class);
        aiintent.putExtra("difficulty", diffbar.getProgress());
        startActivity(aiintent);
    }
}

//three horizontal buttons