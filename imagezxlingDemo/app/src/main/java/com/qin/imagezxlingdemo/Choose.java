package com.qin.imagezxlingdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Choose extends AppCompatActivity {
    private Button fill,make;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);


        fill=findViewById(R.id.bt_do);
        make=findViewById(R.id.bt_make);
        fill.setOnClickListener(this::fill);
        make.setOnClickListener(this::make);


    }





    public void make (View view){

        Intent intent = new Intent(Choose.this,
                Questionmake.class);
        startActivity(intent);
        ExitApplication.getInstance().exit(this);
    }

    public void fill (View view){

        Intent intent = new Intent(Choose.this,
                SActivity.class);
        startActivity(intent);
        ExitApplication.getInstance().exit(this);
    }
}
