package com.qin.imagezxlingdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class Report extends AppCompatActivity {
    public static List<Activity> activityList = new LinkedList();

    TextView txt_rep;
    String password;
    Intent intent;
    Button quit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Intent i = getIntent();
        password = i.getStringExtra("password");
        txt_rep=findViewById(R.id.txt_rep);
        txt_rep.setText(Show_json.save_data);
        quit=(Button)findViewById(R.id.btn_quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exit();
                //退出
            }
        });





    }
    public void exit() {

        Intent intent = new Intent();
        intent.setClass(Report.this, Choose.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //注意本行的FLAG设置
        startActivity(intent);  //注意，startActivity是异步执行，换句话说，startActivity是立即返回的，是不会阻塞的，因此下面的finish得意执行
        finish();//关掉自己
        ExitApplication.getInstance().exit(this);

/*
        for(Activity act:activityList){

            act.finish();

        }

        System.exit(0);



 */

    }
}
