package com.route.friday_basics_c41;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class GameBoardActivity extends AppCompatActivity {
    int counter = 0;
    String[] board = {"", "", "",
            "", "", "",
            "", "", "",};
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
        constraintLayout = findViewById(R.id.buttonsContainer);
    }

    public void onPlayerClick(View view) {
        Button clickedButton = (Button) view;
        if (!clickedButton.getText().toString().isEmpty()) return;
        String symbol = counter % 2 == 0 ? "O" : "X";
        int index = Integer.parseInt((String) clickedButton.getTag());
        clickedButton.setText(symbol);
        board[index] = symbol;
        if (checkWinner(symbol)) {
            resetBoard();
            return;
        }
        counter++;
    }

    private void resetBoard() {
        counter = 0;
        board = new String[]{"", "", "",
                "", "", "",
                "", "", "",};
        for (int i = 0; i < constraintLayout.getChildCount(); i++) {
            View view = constraintLayout.getChildAt(i);
            if (view instanceof Button) {
                ((Button) view).setText("");
            }
        }
    }

    public boolean checkWinner(String symbol) {
        ///Rows
        if (board[0].equals(symbol) && board[1].equals(symbol) && board[2].equals(symbol)) {
            return true;
        }
        if (board[3].equals(symbol) && board[4].equals(symbol) && board[5].equals(symbol)) {
            return true;
        }
        if (board[6].equals(symbol) && board[7].equals(symbol) && board[8].equals(symbol)) {
            return true;
        }
        //Columns
        if (board[0].equals(symbol) && board[3].equals(symbol) && board[6].equals(symbol)) {
            return true;
        }
        if (board[1].equals(symbol) && board[4].equals(symbol) && board[7].equals(symbol)) {
            return true;
        }
        if (board[2].equals(symbol) && board[5].equals(symbol) && board[8].equals(symbol)) {
            return true;
        }
        //Diagonals
        if (board[0].equals(symbol) && board[4].equals(symbol) && board[8].equals(symbol)) {
            return true;
        }
        return board[2].equals(symbol) && board[4].equals(symbol) && board[6].equals(symbol);
    }
}