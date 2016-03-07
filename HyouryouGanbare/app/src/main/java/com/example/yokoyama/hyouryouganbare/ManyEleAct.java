package com.example.yokoyama.hyouryouganbare;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManyEleAct extends AppCompatActivity {
    //使う変数を宣言
    TextView NgenkeiView, NgenkeiView2, textData2, resultData;
    Button moveButton;
    int Ngenkei = 2;
    int data2 = 2;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_many_ele);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button ButtonToKindEleAct = (Button) findViewById(R.id.Button_To_KindEleAct);
        ButtonToKindEleAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_to_kind = new Intent(getApplication(), KindEleAct.class);
                //intent_to_kindでNGENKEIにNgenkeiの値を入れて渡す
                intent_to_kind.putExtra("NGENKEI", Ngenkei);
                startActivity(intent_to_kind);
            }
        });
    }
}
