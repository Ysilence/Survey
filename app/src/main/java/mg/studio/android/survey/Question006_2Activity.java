package mg.studio.android.survey;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Question006_2Activity extends AppCompatActivity {

    public  int i=0;

    public static  String[] Two=new String[10];


public void Next(){
    TextView title = findViewById(R.id.title2);
    TextView ques=findViewById(R.id.question2);

    final CheckBox q006_1,q006_2,q006_3,q006_4,q006_5,q006_6,q006_7;
    q006_1=findViewById(R.id.q0062_1);
    q006_2=findViewById(R.id.q0062_2);
    q006_3=findViewById(R.id.q0062_3);
    q006_4=findViewById(R.id.q0062_4);
    q006_5=findViewById(R.id.q0062_5);
    q006_6=findViewById(R.id.q0062_6);
    q006_7=findViewById(R.id.q0062_7);



    int j=i+1;
    title.setText("Question"+j+":");
    ques.setText(MainActivity.MTitle[i]);

    q006_1.setText(MainActivity.MQuestion[i][0]);
    q006_2.setText(MainActivity.MQuestion[i][1]);
    q006_3.setText(MainActivity.MQuestion[i][2]);
    q006_4.setText(MainActivity.MQuestion[i][3]);
    q006_5.setText(MainActivity.MQuestion[i][4]);
    q006_6.setText(MainActivity.MQuestion[i][5]);
    q006_7.setText(MainActivity.MQuestion[i][6]);
    q006_1.setVisibility(View.VISIBLE);
    q006_2.setVisibility(View.VISIBLE);
    q006_3.setVisibility(View.VISIBLE);
    q006_4.setVisibility(View.VISIBLE);
    q006_5.setVisibility(View.VISIBLE);
    q006_6.setVisibility(View.VISIBLE);
    q006_7.setVisibility(View.VISIBLE);



    Button btn006_2=findViewById(R.id.btn_006_2);
    btn006_2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean n=false;
            if(q006_1.isChecked()) {
                Two[0]=MainActivity.MQuestion[i][0];

                n=true;
            }
            if(q006_2.isChecked()){
                Two[1]=MainActivity.MQuestion[i][1];

                n=true;
            }

            if(q006_3.isChecked()){
                Two[2]=MainActivity.MQuestion[i][2];

                n=true;
            }
            if(q006_4.isChecked()){
                Two[3]=MainActivity.MQuestion[i][3];

                n=true;
            }
            if(q006_5.isChecked()){
                Two[4]=MainActivity.MQuestion[i][4];

            }
            if(q006_6.isChecked()){
                Two[5]=MainActivity.MQuestion[i][5];

                n=true;
            }
            if(q006_7.isChecked()){
                Two[6]=MainActivity.MQuestion[i][6];
                n=true;
            }

            if(n) {
                Intent intent = new Intent(Question006_2Activity.this, Finish_Sur.class);
                startActivity(intent);
            }
        }

    });



}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question006_2);

        set();
        Next();
    }



    void set(){

        MainActivity.MQuestion[i][0]="Music functions";
        MainActivity.MQuestion[i][1]="Photo functions";
        MainActivity.MQuestion[i][2]="Game functions";
        MainActivity.MQuestion[i][3]="Business functions(Word,Excel,etc.)";
        MainActivity.MQuestion[i][4]="GPS functions";
        MainActivity.MQuestion[i][5]="Data functions(Bluetooth,WLAN,etc.)";
        MainActivity.MQuestion[i][6]="Others";
    }
}

