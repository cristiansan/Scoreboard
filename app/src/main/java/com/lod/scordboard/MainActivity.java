package com.lod.scordboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreLeft = 0;
    int scoreRight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//LEFT -------------------------------------------------------------

    public void removeOneLeftA(View v){
        scoreLeft = scoreLeft -1;
        displayForLeft(scoreLeft);
    }

    public void addOneRightA(View v){
        scoreLeft = scoreLeft +1;
        displayForLeft(scoreLeft);
    }


    public void displayForLeft(int score){
        TextView scoreView = (TextView)findViewById(R.id.score_left);
        scoreView.setText(String.valueOf(score));
    }

//RIGHT -------------------------------------------------------------

    public void removeOneLeftB(View v){
        scoreRight = scoreRight -1;
        displayForRight(scoreRight);
    }

    public void addOneRightB(View v){
        scoreRight = scoreRight +1;
        displayForRight(scoreRight);
    }


    public void displayForRight(int score){
        TextView scoreView = (TextView)findViewById(R.id.score_right);
        scoreView.setText(String.valueOf(score));
    }

//RESET -------------------------------------------------------------

    public void resetScore(View v) {
        scoreLeft = 0;
        scoreRight = 0;
        displayForLeft(scoreLeft);
        displayForRight(scoreRight);
    }
}
