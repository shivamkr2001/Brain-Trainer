package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button start,option1,option2,option3,option4,playAgain;
    TextView timer,score,info,question;
    Random rand = new Random();
    int num1,num2,max=25,min=1,ans,box1,box2,box3,box4,box;
    int correct=0,total=0;
    CountDownTimer count;

    public  void displayQuestion(){
          num1 = rand.nextInt(max-min+1)+min;
          num2 = rand.nextInt(max-min+1)+min;
          box = rand.nextInt(4-1+1)+1;
          ans = num1+num2;
          question.setText(Integer.toString(num1)+"+"+Integer.toString(num2));
          box1 = rand.nextInt(2*max-2*min+1)+2*min;
          box2 = rand.nextInt(2*max-2*min+1)+2*min;
          box3 = rand.nextInt(2*max-2*min+1)+2*min;
          box4 = rand.nextInt(2*max-2*min+1)+2*min;
          if(box==1) box1 = ans;
          else if(box==2)box2 = ans;
          else if(box==3)box3 = ans;
          else if(box==4)box4 = ans;
          option1.setText(Integer.toString(box1));
          option2.setText(Integer.toString(box2));
          option3.setText(Integer.toString(box3));
          option4.setText(Integer.toString(box4));
          option1.setVisibility(View.VISIBLE);
          option2.setVisibility(View.VISIBLE);
          option3.setVisibility(View.VISIBLE);
          option4.setVisibility(View.VISIBLE);
          question.setVisibility(View.VISIBLE);


    }

    public void checkAnswer(View view){
        if(view.getId()==R.id.answer1 && box1 == ans){correct++;info.setText("CORRECT");}
        else if(view.getId()==R.id.answer2 && box2 == ans){correct++;info.setText("CORRECT");}
        else if(view.getId()==R.id.answer3 && box3 == ans){correct++;info.setText("CORRECT");}
        else if(view.getId()==R.id.answer4 && box4 == ans){correct++;info.setText("CORRECT");}
        else{info.setText("WRONG");}
        total++;
        score.setText(Integer.toString(correct)+"/"+Integer.toString(total));
        info.setVisibility(View.VISIBLE);
        displayQuestion();
    }

    public void game(){
        timer.setText("30s");
        score.setText("0/0");
        total=0;
        correct=0;
        info.setVisibility(View.INVISIBLE);
        displayQuestion();
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);
        count = new CountDownTimer(31000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                    timer.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                info.setText("Your Score: "+Integer.toString(correct)+"/"+Integer.toString(total));
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
                info.setVisibility(View.VISIBLE);
                playAgain.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void startGame(View view){
        start.setVisibility(View.INVISIBLE);
        timer.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        game();

    }

    public void playAgain(View view){

        playAgain.setVisibility(View.INVISIBLE);
        game();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = (TextView)findViewById(R.id.timer);
        score = (TextView)findViewById(R.id.score);
        info = (TextView)findViewById(R.id.info);
        question = (TextView) findViewById(R.id.question);
        start = (Button) findViewById(R.id.start);
        playAgain = (Button)findViewById(R.id.playAgain);
        option1=(Button) findViewById(R.id.answer1);
        option2=(Button) findViewById(R.id.answer2);
        option3=(Button) findViewById(R.id.answer3);
        option4=(Button) findViewById(R.id.answer4);
        start.setVisibility(View.VISIBLE);
        option1.setVisibility(View.INVISIBLE);
        option2.setVisibility(View.INVISIBLE);
        option3.setVisibility(View.INVISIBLE);
        option4.setVisibility(View.INVISIBLE);
        playAgain.setVisibility(View.INVISIBLE);
        timer.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);
        info.setVisibility(View.INVISIBLE);
        question.setVisibility(View.INVISIBLE);


    }
}