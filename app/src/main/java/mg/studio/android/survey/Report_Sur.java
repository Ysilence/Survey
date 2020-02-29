package mg.studio.android.survey;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.RandomAccess;
import java.util.zip.DeflaterInputStream;

public class Report_Sur extends AppCompatActivity {

    protected Button f_btn,r_sum, r_exit;
    protected String [][]q=new String[13][10];
    protected  String Json_txt="{";
    protected TextView r_q1,r_q2,r_q3,r_q4,r_q5,r_q6,r_q7,r_q8,r_q9,r_q10,r_q11,r_q12;
    public Context mContext;
    public String filename = "saveda.txt";

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

                r_q1.setText("Q1:\'"+MyApp.q[1][1]+"\'");

                r_q2.setText("Q2:\'"+MyApp.q[2][1]+"\'");
                r_q3.setText("Q3:\'"+MyApp.q[3][1]+"\'");
                r_q4.setText("Q4:\'");
                for(int i=1;i<10;i++) {
                    if(MyApp.q[4][i]!=null)
                        r_q4.setText(r_q4.getText().toString() + MyApp.q[4][i] + " *** ");
                }
                r_q4.setText(r_q4.getText().toString()+"\'");
                r_q5.setText("Q5:\'");
                for(int i=1;i<10;i++) {
                    if(MyApp.q[5][i]!=null)
                        r_q5.setText(r_q5.getText().toString() + MyApp.q[5][i] + " *** ");
                }
                r_q5.setText(r_q5.getText().toString()+"\'");
                r_q6.setText("Q6:\'"+MyApp.q[6][1]+"\'");
                r_q7.setText("Q7:\'"+MyApp.q[7][1]+"\'");
                r_q8.setText("Q8:\'"+MyApp.q[8][1]+"\'");
                r_q9.setText("Q9:\'"+MyApp.q[9][1]+"\'");
                r_q10.setText("Q10:\'"+MyApp.q[10][1]+"\'");
                r_q11.setText("Q11:\'"+MyApp.q[11][1]+"\'");
                r_q12.setText("Q12:\'"+MyApp.q[12][1]+"\'");

                Json_txt=Json_txt+r_q1.getText().toString()+r_q2.getText().toString()+r_q3.getText().toString()
                        +r_q4.getText().toString()+r_q5.getText().toString()+r_q6.getText().toString()+
                        r_q7.getText().toString()+r_q8.getText().toString()+r_q9.getText().toString()+
                        r_q10.getText().toString()+r_q11.getText().toString()+r_q12.getText().toString()+"}\n";
            }
        });

        r_exit=findViewById(R.id.r_exit);
        r_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

                        File sd=getExternalFilesDir(null);
                        File save=new File(sd,filename);
                        FileOutputStream output = new FileOutputStream(save,true);
                        output.write(Json_txt.getBytes());
                        output.flush();
                        output.close();
                    }
                    else
                        Toast.makeText(mContext, "SD卡不存在或者不可读写", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "数据写入成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "数据写入失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_survey);
        R_s();

    }
}
