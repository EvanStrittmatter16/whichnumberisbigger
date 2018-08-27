package com.example.whichnumberisbigger;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //

    private Button buttonLeft;
    private Button buttonRight;
    private TextView textViewScore;
    private int score;
    private int leftnumber;
    private int rightnumber;

    public static final int Max_num= 1000;
    public static final int Min_num= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        updateDisplay();

    }

    @SuppressLint("SetTextI18n")
    private void updateDisplay() {

        textViewScore.setText((String)getResources().getText(R.string.main_score) + score);

        randomizthemunbers();
        buttonRight.setText(String.valueOf(rightnumber));
        buttonLeft.setText(String.valueOf(leftnumber));

    }

    private void randomizthemunbers() {
        int range = Max_num - Min_num + 1;
        leftnumber = (int)(Math.random() * range) + Min_num;
        rightnumber = (int)(Math.random() * range) + Min_num;
        if(rightnumber == leftnumber){

            rightnumber ++;
        }
    }

    private void wireWidgets()
    {
        buttonLeft = findViewById(R.id.button_main_left);
        buttonRight = findViewById(R.id.button_main_right);
        textViewScore = findViewById(R.id.textView_main_score);
    }

    public void onRightClick(View view) {
        checkanswer(false);
    }

    private void checkanswer(boolean leftPressed) {
        String message;
        if(rightnumber < leftnumber && leftPressed || rightnumber > leftnumber && !leftPressed ){
            score++;
            message = "Correct!";
        }
        else{
            score-=100;
            message = "U suck!";
        }
        updateDisplay();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onLeftClick(View view) {
        checkanswer(true);
    }
}
