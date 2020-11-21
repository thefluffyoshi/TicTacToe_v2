package com.example.tictactoev1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];
    private boolean playerOneTurn = true;
    private int roundCount;
    private int xWins =0, yWins=0;
    private TextView xScore, yScore;

    private TextView playerOneDisplay;
    private TextView playerTwoDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xScore = findViewById(R.id.xScore);
        yScore = findViewById(R.id.yScore);
        xScore.setText("0");
        yScore.setText("0");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }
        if (playerOneTurn) {
            ((Button) view).setText("X");
            ((Button) view).setTextColor(getResources().getColor(R.color.black));
            //playerOneDisplay.setTextColor(getResources().getColor(R.color.black));
            //didn't work
//            EditText playerOne = findViewById(R.id.oWins);
//            playerOne.setBackgroundColor(000000);
        } else {
            ((Button) view).setText("O");
            ((Button)view).setTextColor(getResources().getColor(R.color.white));
            //playerTwoDisplay.setTextColor(getResources().getColor(R.color.white));
            //didn't work
//            EditText playerTwo = findViewById(R.id.xWins);
//            playerTwo.setBackgroundColor(000000);
        }
        roundCount++;
        if (checkForWin()) {
            if (playerOneTurn) {
                playerOneWins();
            } else {
                playerTwoWins();
            }
        } else if (roundCount == 9) {
            draw();
        } else {
            playerOneTurn = !playerOneTurn;
        }
    }

    public void onClickWinner(View view)
    {
        if (xWins > yWins)
        {
            startActivity(new Intent(MainActivity.this, MainActivity3.class));
        }
        else if (yWins > xWins)
        {
            startActivity(new Intent(MainActivity.this, MainActivity4.class));
        }
    }

    private boolean checkForWin() {
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }
        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }
        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return true;
        }
        return false;
    }

    private void playerOneWins() {
        // takes to screen where it says player one won
        Toast.makeText(MainActivity.this, ("X wins!"), Toast.LENGTH_SHORT).show();
        xWins++;
        xScore.setText(xWins +"");
        resetBoard();
    }
    private void playerTwoWins() {
        // takes to screen where it says player one won
        Toast.makeText(MainActivity.this, ("O wins!"), Toast.LENGTH_SHORT).show();
        yWins++;
        yScore.setText(yWins + "");
        resetBoard();
    }
    private void draw() {
        // takes to screen where it says player one won
        Toast.makeText(MainActivity.this, ("Tie"), Toast.LENGTH_SHORT).show();
        resetBoard();
    }
    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        roundCount = 0;
        playerOneTurn = true;
    }
    private void resetGame() {
        xWins = 0;
        yWins = 0;
        updatePlayerScore();
        resetBoard();
    }
    public void updatePlayerScore()
    {
        xScore.setText(Integer.toString(xWins));
        yScore.setText(Integer.toString(yWins));
    }


//    public void onClickPlayAgainTest(View view)
//    {
//        startActivity(new Intent(MainActivity.this, MainActivity3.class));
//    }

//    public void nextPage()
//    {
//        Intent lastPage = new Intent(MainActivity.this, MainActivity2.class);
//        lastPage.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(lastPage);
//        finish();
//    }
}
