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

public class RateEleAct extends AppCompatActivity {

    TextView NgenkeiView, Ele1View, Ele2View;
    String Ele1, Ele2;
    int Ngenkei;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_ele);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent_to_rate = getIntent();
        Ngenkei = intent_to_rate.getIntExtra("NGENKEI", 4);
        NgenkeiView = (TextView) findViewById(R.id.n_genkei);
        NgenkeiView.setText(String.valueOf(Ngenkei) + "元系を選択しました");
        Ele1 = intent_to_rate.getStringExtra("Ele1");
        Ele1View = (TextView) findViewById(R.id.ele1);
        Ele1View.setText(String.valueOf(Ele1) + "を選択");
        Ele2 = intent_to_rate.getStringExtra(Ele2);
        Ele2View = (TextView) findViewById(R.id.ele2);
        Ele2View.setText(String.valueOf(Ele2) + "を選択");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button ButtonToKindEleAct = (Button) findViewById(R.id.Button_To_SamMassAct);
        ButtonToKindEleAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), SamMassAct.class);
                startActivity(intent);
            }
        });
    }

}
