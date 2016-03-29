package com.example.yokoyama.hyouryouganbare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {


    TextView ResultMassView1,ResultMassView2,ResultRateView1,ResultRateView2,ResultSamView;
    String Ele1, Ele2;
    int Rate1,Rate2;
    int Ngenkei;
    int SamMass;

    //原子量が入る変数を宣言
    double Fe_atm;
    double Co_atm;
    //答えを入れる変数を宣言
    double Mass1,Mass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //値を受け取る
        Intent intent_to_sam = getIntent();
        Ngenkei = intent_to_sam.getIntExtra("NGENKEI", 4);
        Ele1 = intent_to_sam.getStringExtra("Ele1");
        Ele2 = intent_to_sam.getStringExtra("Ele2");
        Rate1 = intent_to_sam.getIntExtra("RATE1", 0);
        Rate2 = intent_to_sam.getIntExtra("RATE2", 0);
        SamMass = intent_to_sam.getIntExtra("SAMMASS", 0);

        //どうにかして元素種（Fe,Co,etc...)から原子量を引っ張る
        Fe_atm = 55.845;
        Co_atm = 58.933195;

        //計算する
        Mass1 = SamMass / ( 1 + ((Rate2 * Co_atm)/(Rate1 * Fe_atm)) );
        Mass2 = SamMass - Mass1;

        //表示の準備
        ResultMassView1 = (TextView) findViewById(R.id.sam_mass_1);
        ResultMassView1.setText(String.valueOf(Mass1) + "g");
        ResultMassView2 = (TextView) findViewById(R.id.sam_mass_2);
        ResultMassView2.setText(String.valueOf(Mass2) + "g");

        //表示の準備。あと変数がちゃんと運ばれてきたかチェック
        ResultRateView1 = (TextView) findViewById(R.id.rate1);
        ResultRateView1.setText(String.valueOf(Rate1) + "がFeの比");
        ResultRateView2 = (TextView) findViewById(R.id.rate2);
        ResultRateView2.setText(String.valueOf(Rate2) + "がCoの比");
        ResultSamView = (TextView) findViewById(R.id.sam_mass);
        ResultSamView.setText(String.valueOf(SamMass) + "gが合計質量");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
