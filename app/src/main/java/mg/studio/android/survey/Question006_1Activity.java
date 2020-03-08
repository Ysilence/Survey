package mg.studio.android.survey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Question006_1Activity extends AppCompatActivity {

    public int i=0;
    public  static String one="";



    public void Next(){

        TextView title = findViewById(R.id.title1);
        TextView ques=findViewById(R.id.question1);
        RadioGroup options =findViewById(R.id.options1);

        final RadioButton q006_1,q006_2,q006_3,q006_4,q006_5,q006_6,q006_7;
         q006_1=findViewById(R.id.q0061_1);
         q006_2=findViewById(R.id.q0061_2);
         q006_3=findViewById(R.id.q0061_3);
         q006_4=findViewById(R.id.q0061_4);
         q006_5=findViewById(R.id.q0061_5);
         q006_6=findViewById(R.id.q0061_6);
         q006_7=findViewById(R.id.q0061_7);


        int j=i+1;
        title.setText("Question"+j+":");
        ques.setText(MainActivity.STitle[i]);

        q006_1.setText(MainActivity.SQuestion[i][0]);
        q006_2.setText(MainActivity.SQuestion[i][1]);
        q006_3.setText(MainActivity.SQuestion[i][2]);
        q006_4.setText(MainActivity.SQuestion[i][3]);
        q006_5.setText(MainActivity.SQuestion[i][4]);
        q006_6.setText(MainActivity.SQuestion[i][5]);
        q006_7.setText(MainActivity.SQuestion[i][6]);
        q006_1.setVisibility(View.VISIBLE);
        q006_2.setVisibility(View.VISIBLE);
        q006_3.setVisibility(View.VISIBLE);
        q006_4.setVisibility(View.VISIBLE);
        q006_5.setVisibility(View.VISIBLE);
        q006_6.setVisibility(View.VISIBLE);
        q006_7.setVisibility(View.VISIBLE);


        options.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId) {
                    case R.id.q0061_1:
                       one=MainActivity.SQuestion[i][0];
                        break;
                    case R.id.q0061_2:
                        one=MainActivity.SQuestion[i][1];

                        break;
                    case R.id.q0061_3:
                        one=MainActivity.SQuestion[i][2];

                        break;
                    case R.id.q0061_4:
                        one=MainActivity.SQuestion[i][3];

                        break;
                    case R.id.q0061_5:
                        one=MainActivity.SQuestion[i][4];

                        break;
                    case R.id.q0061_6:
                        one=MainActivity.SQuestion[i][5];

                        break;
                    case R.id.q0061_7:
                        one=MainActivity.SQuestion[i][6];

                        break;

                }

                Button btn006_1=findViewById(R.id.btn_006_1);
                btn006_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Question006_1Activity.this, Question006_2Activity.class);
                        startActivity(intent);
                    }

                });


            }
        });


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question006_1);

        set();
        Next();

    }





    void set(){

        MainActivity.SQuestion[i][0]="Iphone";
        MainActivity.SQuestion[i][1]="Samsung";
        MainActivity.SQuestion[i][2]="MI";
        MainActivity.SQuestion[i][3]="Lenovo";
        MainActivity.SQuestion[i][4]="Sony";
        MainActivity.SQuestion[i][5]="Nokia";
        MainActivity.SQuestion[i][6]="Others";
    }

}
















