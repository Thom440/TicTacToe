package com.example.tictactoe;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button[] btnArray;

    private final String PLAYER_X = "X";
    private final String PLAYER_O = "O";
    private String currentPlayer;
    private String instructionString;

    private int turnCount;

    private boolean gameComplete;

    private TextView instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Added a try catch because setDisplayShowHomeEnabled
        // could possibly throw a null pointer exception
        try {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setIcon(R.mipmap.ic_launcher_default);
        }
        catch (NullPointerException ex) {
            Toast.makeText(this, "Unable to load icon", Toast.LENGTH_SHORT).show();
        }

        gameComplete = false;

        turnCount = 0;

        btnArray = new Button[9];
        btnArray[0] = (Button)findViewById(R.id.btn1);
        btnArray[1] = (Button)findViewById(R.id.btn2);
        btnArray[2] = (Button)findViewById(R.id.btn3);
        btnArray[3] = (Button)findViewById(R.id.btn4);
        btnArray[4] = (Button)findViewById(R.id.btn5);
        btnArray[5] = (Button)findViewById(R.id.btn6);
        btnArray[6] = (Button)findViewById(R.id.btn7);
        btnArray[7] = (Button)findViewById(R.id.btn8);
        btnArray[8] = (Button)findViewById(R.id.btn9);

        currentPlayer = PLAYER_X;

        instructions = (TextView)findViewById(R.id.instructions);

        // Creating this string to clear a warning when using setText()
        instructionString = "Player " + currentPlayer + "'s Turn";
        instructions.setText(instructionString);
    }

    public void onClick(View v) {
        if (((Button)v).getText().equals("") && !gameComplete) {
            ((Button) v).setText(currentPlayer);
            if (currentPlayer.equals(PLAYER_X)) {
                turnCount++;
                if (turnCount >= 3 && checkForGameWinner()) {
                    declareWinner();
                    return;
                }
                else if (turnCount == 5) {
                    instructionString = "Tie Game";
                    instructions.setText(instructionString);
                    return;
                }
                currentPlayer = PLAYER_O;
            }
            else {
                if (turnCount >= 3 && checkForGameWinner()) {
                    declareWinner();
                    return;
                }
                currentPlayer = PLAYER_X;
            }
            instructionString = "Player " + currentPlayer + "'s Turn";
            instructions.setText(instructionString);
        }
    }

    public void newGameClick(View v) {
        for (Button button : btnArray) {
            button.setText("");
        }

        gameComplete = false;

        turnCount = 0;

        currentPlayer = PLAYER_X;

        instructionString = "Player " + currentPlayer + "'s Turn";
        instructions.setText(instructionString);
    }

    private void declareWinner() {
        gameComplete = true;

        instructionString = currentPlayer + " wins";
        instructions.setText(instructionString);
    }

    private boolean checkForGameWinner() {
        if (btnArray[0].getText().equals(currentPlayer) && btnArray[1].getText().equals(currentPlayer) &&
            btnArray[2].getText().equals(currentPlayer)) {
            return true;
        }
        else if (btnArray[3].getText().equals(currentPlayer) && btnArray[4].getText().equals(currentPlayer) &&
                btnArray[5].getText().equals(currentPlayer)) {
            return true;
        }
        else if (btnArray[6].getText().equals(currentPlayer) && btnArray[7].getText().equals(currentPlayer) &&
                btnArray[8].getText().equals(currentPlayer)) {
            return true;
        }
        else if (btnArray[0].getText().equals(currentPlayer) && btnArray[4].getText().equals(currentPlayer) &&
                btnArray[8].getText().equals(currentPlayer)) {
            return true;
        }
        else if (btnArray[2].getText().equals(currentPlayer) && btnArray[4].getText().equals(currentPlayer) &&
                btnArray[6].getText().equals(currentPlayer)) {
            return true;
        }
        else if (btnArray[0].getText().equals(currentPlayer) && btnArray[3].getText().equals(currentPlayer) &&
                btnArray[6].getText().equals(currentPlayer)) {
            return true;
        }
        else if (btnArray[1].getText().equals(currentPlayer) && btnArray[4].getText().equals(currentPlayer) &&
                btnArray[7].getText().equals(currentPlayer)) {
            return true;
        }
        else {
            return btnArray[2].getText().equals(currentPlayer) && btnArray[5].getText().equals(currentPlayer) &&
                    btnArray[8].getText().equals(currentPlayer);
        }
    }
}