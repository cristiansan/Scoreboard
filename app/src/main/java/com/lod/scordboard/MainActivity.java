package com.lod.scordboard;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity{

    int scoreLeft = 0;
    int scoreRight = 0;
    int gameClock = 00;
    int breakClock = 10;

    ImageView btnStart;
    ImageView btnStop;
    TextView textViewTime;
    private ImageView btnBuzzer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (ImageView) findViewById(R.id.btnStartTime);
        btnStop = (ImageView) findViewById(R.id.btnStopTime);
        btnBuzzer = (ImageView) findViewById(R.id.buzzer);
        textViewTime = (TextView) findViewById(R.id.gameClock);

//BUZZER -----------------------------------------------------------------
        ImageView sound = (ImageView)this.findViewById(R.id.buzzer);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.bikehorn);
        sound.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                mp.start();

            }
        });


//GAME CLOCK -------------------------------------------------------------

        textViewTime.setText("07:00");
        final CounterClass timer = new CounterClass(420000, 1000);  // milliseconds
        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                timer.start();
                timer.onFinish();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                timer.cancel();
            }
        });

        btnBuzzer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                timer.cancel();
                mp.start();
            }
        });

    }

    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String ms = String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(ms);
            textViewTime.setText(ms);
        }

        @Override
        public void onFinish() {
            // TODO Auto-generated method stub
            textViewTime.setText("00:00");
        }



    }

//SCORE LEFT -------------------------------------------------------------

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

//SCORE RIGHT -------------------------------------------------------------

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



    //BREAK CLOCK -------------------------------------------------------------
    public void add30sec(View v) {
        breakClock = 30;
        displayBreakClock(breakClock);

    }

    public void add10sec(View v) {
        breakClock = 10;
        displayBreakClock(breakClock);

    }

    public void add5sec(View v) {
        breakClock = 5;
        displayBreakClock(breakClock);

    }
    public void displayBreakClock(int score) {
        TextView scoreView = (TextView) findViewById(R.id.breakClock);
        scoreView.setText(String.valueOf(score));
    }


//RESET BUTTON-------------------------------------------------------------

    public void resetScore(View v) {
        scoreLeft = 0;
        scoreRight = 0;
        gameClock = 00;
        breakClock = 10;
        displayForLeft(scoreLeft);
        displayForRight(scoreRight);
        displayGameClock(gameClock);
        displayBreakClock(breakClock);

    }
    public void displayGameClock(int score) {
        TextView scoreView = (TextView) findViewById(R.id.gameClock);
        scoreView.setText(String.valueOf(score));
    }

}
