package com.lod.scordboard;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.lod.scordboard.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity{

    int scoreLeft = 0;
    int scoreRight = 0;
    int mainClockMin = 00;
    int secondaryClockSec = 10;

    ImageView btnStart;
    ImageView btnStop;
    TextView textViewTime;
    TextView textViewTimeMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (ImageView) findViewById(R.id.btnStartTime);
        btnStop = (ImageView) findViewById(R.id.btnStopTime);
        textViewTime = (TextView) findViewById(R.id.mainClockSec);

        textViewTime.setText("15:00");
       /* textViewTimeMin.setText("10:00"); */
        final CounterClass timer = new CounterClass(900000, 1000);
        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timer.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timer.cancel();
            }
        });

    }

    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);
            textViewTime.setText(hms);
        }

        @Override
        public void onFinish() {
            // TODO Auto-generated method stub
            textViewTime.setText("00:00");
        }

    }

//LEFT -------------------------------------------------------------

    public void removeOneLeftA(View v) {
        scoreLeft = scoreLeft - 1;
        displayForLeft(scoreLeft);
    }

    public void addOneRightA(View v) {
        scoreLeft = scoreLeft + 1;
        displayForLeft(scoreLeft);
    }


    public void displayForLeft(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_left);
        scoreView.setText(String.valueOf(score));
    }

//RIGHT -------------------------------------------------------------

    public void removeOneLeftB(View v) {
        scoreRight = scoreRight - 1;
        displayForRight(scoreRight);
    }

    public void addOneRightB(View v) {
        scoreRight = scoreRight + 1;
        displayForRight(scoreRight);
    }

    public void displayForRight(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_right);
        scoreView.setText(String.valueOf(score));

    }
//MAIN CLOCK -------------------------------------------------------------

    public void add5(View v) {
        mainClockMin = 5;
        mainClock(mainClockMin);
    }

    public void add10(View v) {
        mainClockMin = 10;
        mainClock(mainClockMin);

    }


    public void mainClock(int score) {
        TextView scoreView = (TextView) findViewById(R.id.mainClockSec);
        scoreView.setText(String.valueOf(score));

    }

    //SECONDARY CLOCK -------------------------------------------------------------
    public void add030(View v) {
        secondaryClockSec = 30;
        secondaryClock(secondaryClockSec);

    }

    public void add010(View v) {
        secondaryClockSec = 10;
        secondaryClock(secondaryClockSec);


    }

    public void secondaryClock(int score) {
        TextView scoreView = (TextView) findViewById(R.id.secondaryClockSec);
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




