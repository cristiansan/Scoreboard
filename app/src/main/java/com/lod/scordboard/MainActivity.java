package com.lod.scordboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreLeft = 0;
    int scoreRight = 0;
    int mainClockMin = 15;
    int secondaryClockSec = 10;


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
//MAIN CLOCK -------------------------------------------------------------

    public void add5(View v){
        mainClockMin =  5;
        mainClock(mainClockMin);
    }

    public void add10(View v){
        mainClockMin = 10;
        mainClock(mainClockMin);

    }


    public void mainClock(int score) {
        TextView scoreView = (TextView) findViewById(R.id.mainClockMin);
        scoreView.setText(String.valueOf(score));

    }

//SECONDARY CLOCK -------------------------------------------------------------
    public void add030(View v){
        secondaryClockSec = 30;
        secondaryClock(secondaryClockSec);

    }

    public void add010(View v){
        secondaryClockSec = 10;
        secondaryClock(secondaryClockSec);


    }

    public void secondaryClock (int score){
        TextView scoreView = (TextView)findViewById(R.id.secondaryClockSec);
        scoreView.setText(String.valueOf(score));
    }


//RESET -------------------------------------------------------------

    public void resetScore(View v) {
        scoreLeft = 0;
        scoreRight = 0;
        mainClockMin = 15;
        secondaryClockSec = 10;
        displayForLeft(scoreLeft);
        displayForRight(scoreRight);
        mainClock(mainClockMin);
        secondaryClock(secondaryClockSec);

    }
}
