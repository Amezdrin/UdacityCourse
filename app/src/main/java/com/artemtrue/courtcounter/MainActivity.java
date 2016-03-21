package com.artemtrue.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int totalTeamA = 0;
    int totalTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // displayForTeamA(totalTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {

        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**метод вывода счёта команды В на экран*/
    public void displayForTeamB(int score) {

        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**добавляем +3 к счётчику команды А и вызываем метод вывода счёта на экран*/
    public void addThreeToA (View view) {

        totalTeamA = totalTeamA + 3;
        displayForTeamA(totalTeamA);
    }

    /**добавляем +2 к счётчику команды А*/
    public void addTwoToA (View view) {

        totalTeamA = totalTeamA + 2;
        displayForTeamA(totalTeamA);
    }

    /**добавляем +1 к счётчику команды А*/
    public void addOneToA (View view) {

        totalTeamA = totalTeamA + 1;
        displayForTeamA(totalTeamA);
    }

    /**добавляем +3 к счётчику команды B*/
    public void addThreeToB (View view) {

        totalTeamB = totalTeamB + 3;
        displayForTeamB(totalTeamB);
    }

    /**добавляем +2 к счётчику команды B*/
    public void addTwoToB (View view) {

        totalTeamB = totalTeamB + 2;
        displayForTeamB(totalTeamB);
    }

    /**добавляем +1 к счётчику команды B*/
    public void addOneToB (View view) {

        totalTeamB = totalTeamB + 1;
        displayForTeamB(totalTeamB);
    }


    /**метод сброса значений счётчиков команд в 0*/
    public void resetScore (View view) {

        totalTeamA = 0;
        totalTeamB = 0;
        displayForTeamA(totalTeamA);
        displayForTeamB(totalTeamB);
    }


}
