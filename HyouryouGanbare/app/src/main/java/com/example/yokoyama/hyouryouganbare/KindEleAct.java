package com.example.yokoyama.hyouryouganbare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class KindEleAct extends AppCompatActivity {

    TextView NgenkeiView;
    int Ngenkei;
    String Ele1, Ele2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kind_ele);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //値を受け取る
        Intent intent_to_kind = getIntent();
        //受け取れなかった時の初期値を宣言?多分。今回のケースでは0
        Ngenkei = intent_to_kind.getIntExtra("NGENKEI", 0);
        NgenkeiView = (TextView) findViewById(R.id.n_genkei);
        NgenkeiView.setText(String.valueOf(Ngenkei) + "元系を選択しました");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button ButtonToKindEleAct = (Button) findViewById(R.id.Button_To_RateEleAct);
        ButtonToKindEleAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_to_rate = new Intent(getApplication(), RateEleAct.class);
                intent_to_rate.putExtra("NGENKEI", Ngenkei);
                intent_to_rate.putExtra("Ele1", "Fe");
                intent_to_rate.putExtra("Ele2", "Co");
                startActivity(intent_to_rate);


            }
        });
    }

}
