package com.example.yokoyama.hyouryouganbare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SamMassAct extends AppCompatActivity {

    String Ele1, Ele2;
    int Rate1,Rate2;
    int Ngenkei;
    int SamMass = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sam_mass);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent_to_sam = getIntent();
        Ngenkei = intent_to_sam.getIntExtra("NGENKEI", 4);
        Ele1 = intent_to_sam.getStringExtra("Ele1");
        Ele2 = intent_to_sam.getStringExtra("Ele2");
        Rate1 = intent_to_sam.getIntExtra("RATE1", 0);
        Rate2 = intent_to_sam.getIntExtra("RATE2", 0);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button ButtonToKindEleAct = (Button) findViewById(R.id.Button_To_Result);
        ButtonToKindEleAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_to_result = new Intent(getApplication(), Result.class);
                intent_to_result.putExtra("NGENKEI", Ngenkei);
                intent_to_result.putExtra("Ele1", "Fe");
                intent_to_result.putExtra("Ele2", "Co");
                intent_to_result.putExtra("RATE1",Rate1);
                intent_to_result.putExtra("RATE2",Rate2);
                intent_to_result.putExtra("SAMMASS",SamMass);
                startActivity(intent_to_result);
            }
        });
    }

}
