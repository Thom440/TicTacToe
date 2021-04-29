package com.example.tictactoe;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button[] btnArray;

    private final String PLAYER_X = "X";
    private final String PLAYER_O = "O";
    private String currentPlayer;

    private TextView instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher_default);

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

        instructions.setText("Player " + currentPlayer + "'s Turn");
    }

    public void onClick(View v) {
        if (((Button)v).getText().equals("")) {
            ((Button) v).setText(currentPlayer);
            if (currentPlayer == PLAYER_X) {
                currentPlayer = PLAYER_O;
            }
            else {
                currentPlayer = PLAYER_X;
            }
            instructions.setText("Player " + currentPlayer + "'s Turn");
        }
    }

    public void newGameClick(View v) {
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i].setText("");
        }

        currentPlayer = PLAYER_X;

        instructions.setText("Player " + currentPlayer + "'s Turn");
    }
}