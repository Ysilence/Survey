package mg.studio.android.survey;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected Button w_btn,q1_btn,q2_btn,q3_btn,q4_btn,q5_btn,q6_btn,q7_btn,q8_btn
                       ,q9_btn,q10_btn,q11_btn,q12_btn,f_btn,r_sum;
    protected TextView r_q1,r_q2,r_q3,r_q4,r_q5,r_q6,r_q7,r_q8,r_q9,r_q10,r_q11,r_q12;
    protected String [][]q=new String[13][10];
    protected CheckBox w_b;

    void w_b(){
        w_btn=findViewById(R.id.button);
        w_b=findViewById(R.id.checkBox);

        w_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(w_b.isChecked()) {

                    setContentView(R.layout.question_one);
                    q1_b();
                }
            }
        });
    }

    void q1_b() {
        q1_btn = findViewById(R.id.button2);
        RadioGroup q1_rg=findViewById(R.id.q1_rg);
        q1_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q1_1:
                        q[1][1]=("Iphone");
                        break;
                    case R.id.q1_2:
                        q[1][1]=("Nokia");
                        break;
                    case R.id.q1_3:
                        q[1][1]=("Samsung");
                        break;
                    case R.id.q1_4:
                        q[1][1]=("MI");
                        break;
                    case R.id.q1_5:
                        q[1][1]=("Lenovo");
                        break;
                    case R.id.q1_6:
                        q[1][1]=("Sony");
                        break;
                    case R.id.q1_7:
                        q[1][1]=("Others");
                        break;
                }

                q1_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.question_two);
                        q2_b();
                    }
                });

            }
        });


    }

    void q2_b() {
        q2_btn = findViewById(R.id.button3);
        RadioGroup q2_rg=findViewById(R.id.q2_rg);
        q2_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q2_1:
                        q[2][1]=("Under 1000");
                        break;
                    case R.id.q2_2:
                        q[2][1]=("1000-1999");
                        break;
                    case R.id.q2_3:
                        q[2][1]=("2000-2999");
                        break;
                    case R.id.q2_4:
                        q[2][1]=("3000-3999");
                        break;
                    case R.id.q2_5:
                        q[2][1]=("more than 4000");
                        break;
                }

                q2_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.question_three);
                        q3_b();
                    }
                });
            }
        });
    }

    void q3_b() {
        q3_btn = findViewById(R.id.button4);

        RadioGroup q3_rg=findViewById(R.id.q3_rg);
        q3_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q3_1:
                        q[3][1]=("2G");
                        break;
                    case R.id.q3_2:
                        q[3][1]=("3G");
                        break;
                    case R.id.q3_3:
                        q[3][1]=("4G");
                        break;
                    case R.id.q2_4:
                        q[3][1]=("Others");
                        break;
                }
                q3_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.question_four);
                        q4_b();
                    }
                });
            }
        });

    }

    void q4_b() {
         q4_btn = findViewById(R.id.button5);
        q4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox q4_1,q4_2,q4_3,q4_4,q4_5,q4_6,q4_7;
                q4_1=findViewById(R.id.q4_1);
                q4_2=findViewById(R.id.q4_2);
                q4_3=findViewById(R.id.q4_3);
                q4_4=findViewById(R.id.q4_4);
                q4_5=findViewById(R.id.q4_5);
                q4_6=findViewById(R.id.q4_6);
                q4_7=findViewById(R.id.q4_7);
                if(q4_1.isChecked())
                    q[4][1]=("Music functions");
                if(q4_2.isChecked())
                    q[4][2]=("Photo functions");
                if(q4_3.isChecked())
                    q[4][3]=("Game functions");
                if(q4_4.isChecked())
                    q[4][4]=("Business functions(Word,Excel,ect.)");
                if(q4_5.isChecked())
                     q[4][5]=("GPS functions");
                if(q4_6.isChecked())
                    q[4][6]=("Data functions(Bluetooth,WLAN,ect.)");
                if(q4_7.isChecked())
                    q[4][7]=("Others");

                setContentView(R.layout.question_five);
                q5_b();
            }
        });
    }

    void q5_b() {
        q5_btn = findViewById(R.id.button6);
        q5_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox q5_1,q5_2,q5_3,q5_4,q5_5,q5_6,q5_7;
                q5_1=findViewById(R.id.q5_1);
                q5_2=findViewById(R.id.q5_2);
                q5_3=findViewById(R.id.q5_3);
                q5_4=findViewById(R.id.q5_4);
                q5_5=findViewById(R.id.q5_5);
                q5_6=findViewById(R.id.q5_6);
                q5_7=findViewById(R.id.q5_7);
                if(q5_1.isChecked())
                    q[5][1]=("Music functions");
                if(q5_2.isChecked())
                    q[5][2]=("Photo functions");
                if(q5_3.isChecked())
                    q[5][3]=("Game functions");
                if(q5_4.isChecked())
                    q[5][4]=("Business functions(Word,Excel,ect.)");
                if(q5_5.isChecked())
                    q[5][5]=("GPS functions");
                if(q5_6.isChecked())
                    q[5][6]=("Data functions(Bluetooth,WLAN,ect.)");
                if(q5_7.isChecked())
                    q[5][7]=("Others");

                setContentView(R.layout.question_six);
                q6_b();
            }
        });
    }

    void q6_b() {
        q6_btn = findViewById(R.id.button7);
        q6_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText q6_e;
                q6_e=findViewById(R.id.q6_edit);
                q[6][1]=q6_e.getText().toString();

                setContentView(R.layout.question_seven);
                q7_b();
            }
        });
    }

    void q7_b() {
        q7_btn = findViewById(R.id.button8);
        RadioGroup q7_rg=findViewById(R.id.q7_rg);
        q7_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q7_1:
                        q[7][1]=("When the old phone has been used for a year or two.(but it still works)");
                        break;
                    case R.id.q7_2:
                        q[7][1]=("When the old phone has been used for more than three years.(but it still works)");
                        break;
                    case R.id.q7_3:
                        q[7][1]=("When the old phone breaks down.");
                        break;
                    case R.id.q7_4:
                        q[7][1]=("When a new phone is released.");
                        break;
                    case R.id.q7_5:
                        q[7][1]=("Others");
                        break;
                }
                q7_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.question_eight);
                        q8_b();
                    }
                });

            }
        });
    }

    void q8_b() {
        q8_btn = findViewById(R.id.button9);
        RadioGroup q8_rg=findViewById(R.id.q8_rg);
        q8_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q8_1:
                        q[8][1]=("Iphone");
                        break;
                    case R.id.q8_2:
                        q[8][1]=("Nokia");
                        break;
                    case R.id.q8_3:
                        q[8][1]=("Samsung");
                        break;
                    case R.id.q8_4:
                        q[8][1]=("MI");
                        break;
                    case R.id.q8_5:
                        q[8][1]=("Lenovo");
                        break;
                    case R.id.q8_6:
                        q[8][1]=("Sony");
                        break;
                    case R.id.q8_7:
                        q[8][1]=("Others");
                        break;
                }
                q8_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.question_nine);
                        q9_b();
                    }
                });
            }
        });
    }

    void q9_b() {
        q9_btn = findViewById(R.id.button10);
        RadioGroup q9_rg=findViewById(R.id.q9_rg);
        q9_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q9_1:
                        q[9][1]=("Appearance");
                        break;
                    case R.id.q9_2:
                        q[9][1]=("Price");
                        break;
                    case R.id.q9_3:
                        q[9][1]=("Performance");
                        break;
                    case R.id.q9_4:
                        q[9][1]=("Others");
                        break;
                }
                q9_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.question_ten);
                        q10_b();
                    }
                });
            }
        });

    }

    void q10_b() {
        q10_btn = findViewById(R.id.button11);
        RadioGroup q10_rg=findViewById(R.id.q10_rg);
        q10_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q10_1:
                        q[10][1]=("Under 18");
                        break;
                    case R.id.q10_2:
                        q[10][1]=("19-25");
                        break;
                    case R.id.q10_3:
                        q[10][1]=("25-35");
                        break;
                    case R.id.q10_4:
                        q[10][1]=("beyond 35");
                        break;
                }
                q10_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.question_eleven);
                        q11_b();
                    }
                });
            }
        });
    }

    void q11_b() {
        q11_btn = findViewById(R.id.button12);
        RadioGroup q11_rg=findViewById(R.id.q11_rg);
        q11_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q11_1:
                        q[11][1]=("Male");
                        break;
                    case R.id.q11_2:
                        q[11][1]=("Female");
                        break;
                }
                q11_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.question_twelve);
                        q12_b();
                    }
                });
            }
        });

    }

    void q12_b() {
        q12_btn = findViewById(R.id.button13);
        RadioGroup q12_rg=findViewById(R.id.q12_rg);
        q12_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q12_1:
                        q[12][1]=("I haven't got a job");
                        break;
                    case R.id.q12_2:
                        q[12][1]=("Under 3000");
                        break;
                    case R.id.q12_3:
                        q[12][1]=("3000-5000");
                        break;
                    case R.id.q12_4:
                        q[12][1]=("5000-10000");
                        break;
                    case R.id.q12_5:
                        q[12][1]=("more than 10000");
                        break;
                }

                q1_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.question_two);
                        q2_b();
                    }
                });

            }
        });
        q12_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.finish_survey);
                f_b();
            }
        });
    }

    void  f_b(){
        f_btn = findViewById(R.id.button14);
        f_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.report_survey);
                R_s();
            }
        });
    }

    void R_s() {
        r_sum=findViewById(R.id.r_sum);
        r_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_q1=findViewById(R.id.r_q1);
                r_q2=findViewById(R.id.r_q2);
                r_q3=findViewById(R.id.r_q3);
                r_q4=findViewById(R.id.r_q4);
                r_q5=findViewById(R.id.r_q5);
                r_q6=findViewById(R.id.r_q6);
                r_q7=findViewById(R.id.r_q7);
                r_q8=findViewById(R.id.r_q8);
                r_q9=findViewById(R.id.r_q9);
                r_q10=findViewById(R.id.r_q10);
                r_q11=findViewById(R.id.r_q11);
                r_q12=findViewById(R.id.r_q12);

                r_q1.setText("Q1:"+q[1][1]);
                r_q2.setText("Q2:"+q[2][1]);
                r_q3.setText("Q3:"+q[3][1]);
                r_q4.setText("Q4:");
                for(int i=1;i<10;i++) {
                    if(q[4][i]!=null)
                        r_q4.setText(r_q4.getText().toString() + q[4][i] + " *** ");
                }
                r_q5.setText("Q5:");
                for(int i=1;i<10;i++) {
                    if(q[5][i]!=null)
                        r_q5.setText(r_q5.getText().toString() + q[5][i] + " *** ");
                }
                r_q6.setText("Q6:"+q[6][1]);
                r_q7.setText("Q7:"+q[7][1]);
                r_q8.setText("Q8:"+q[8][1]);
                r_q9.setText("Q9:"+q[9][1]);
                r_q10.setText("Q10:"+q[10][1]);
                r_q11.setText("Q11:"+q[11][1]);
                r_q12.setText("Q12:"+q[12][1]);
            }
        });
        Button r_exit;
        r_exit=findViewById(R.id.r_exit);
        r_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        w_b();
    }
}
