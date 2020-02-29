package mg.studio.android.survey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class Qu_Four extends AppCompatActivity {

    protected Button q4_btn;
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
                    MyApp.q[4][1]=("Music functions");
                if(q4_2.isChecked())
                    MyApp.q[4][2]=("Photo functions");
                if(q4_3.isChecked())
                    MyApp.q[4][3]=("Game functions");
                if(q4_4.isChecked())
                    MyApp.q[4][4]=("Business functions(Word,Excel,ect.)");
                if(q4_5.isChecked())
                    MyApp.q[4][5]=("GPS functions");
                if(q4_6.isChecked())
                    MyApp.q[4][6]=("Data functions(Bluetooth,WLAN,ect.)");
                if(q4_7.isChecked())
                    MyApp.q[4][7]=("Others");

                Intent intent=new Intent(Qu_Four.this, Qu_Five.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_four);
        q4_b();
    }
}
