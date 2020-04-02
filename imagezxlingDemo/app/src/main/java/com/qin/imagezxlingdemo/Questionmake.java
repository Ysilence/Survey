package com.qin.imagezxlingdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class Questionmake extends AppCompatActivity {
    public static String answer="NONE";
    public String Json="NONE";
    public EditText option1;
    public EditText option2;
    public EditText option3;
    public EditText option4;
    public EditText question;
    public RadioButton single;
    public RadioButton mul;


    public String ques;
    public String an1;
    public String an2;
    public String an3;
    public String an4;
    public String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionmake);
        single=(RadioButton)findViewById(R.id.rbsingle);
        mul=(RadioButton)findViewById(R.id.rbmul);
        question = (EditText) findViewById(R.id.et_question);
        option1 = (EditText) findViewById(R.id.et_option1);
        option2 = (EditText) findViewById(R.id.et_option2);
        option3 = (EditText) findViewById(R.id.et_option3);
        option4 = (EditText) findViewById(R.id.et_option4);


    }

   public void next(View view)
   {
       ques=question.getText().toString();
        if(single.isChecked())
        {
            type="single";
        }
        if(mul.isChecked())
        {
            type="multiple";
        }

       an1=option1.getText().toString();
       an2=option2.getText().toString();
       an3=option3.getText().toString();
       an4=option4.getText().toString();


        if (an3==null) {
            Json = "{\"survey\":{\"id\":\"1\",\"len\":\"1\",\"questions\":[{\"type\":\""+type+"\",\"question\":\""+ques+"\",\"options\":[{\"1\":\""+an1+"\"},{\"2\":\""+an2+"\"}]}]}}\n";
        }
        else if(an4==null)
        {
            Json = "{\"survey\":{\"id\":\"1\",\"len\":\"1\",\"questions\":[{\"type\":\""+type+"\",\"question\":\""+ques+"\",\"options\":[{\"1\":\""+an1+"\"},{\"2\":\""+an2+"\"},{\"3\":\""+an3+"\"}]}]}}\n";
        }
        else
        {
            Json = "{\"survey\":{\"id\":\"1\",\"len\":\"1\",\"questions\":[{\"type\":\""+type+"\",\"question\":\""+ques+"\",\"options\":[{\"1\":\""+an1+"\"},{\"2\":\""+an2+"\"},{\"3\":\""+an3+"\"},{\"4\":\""+an4+"\"}]}]}}\n";
        }
        answer=Json;
       Intent intent = new Intent(this, Qrcode.class);
       startActivity(intent);
       ExitApplication.getInstance().exit(this);
   }
}
