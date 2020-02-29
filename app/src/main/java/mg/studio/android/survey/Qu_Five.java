package mg.studio.android.survey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class Qu_Five extends AppCompatActivity {

    protected Button q5_btn;
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
                    MyApp.q[5][1]=("Music functions");
                if(q5_2.isChecked())
                    MyApp.q[5][2]=("Photo functions");
                if(q5_3.isChecked())
                    MyApp.q[5][3]=("Game functions");
                if(q5_4.isChecked())
                    MyApp.q[5][4]=("Business functions(Word,Excel,ect.)");
                if(q5_5.isChecked())
                    MyApp.q[5][5]=("GPS functions");
                if(q5_6.isChecked())
                    MyApp.q[5][6]=("Data functions(Bluetooth,WLAN,ect.)");
                if(q5_7.isChecked())
                    MyApp.q[5][7]=("Others");

                Intent intent=new Intent(Qu_Five.this, Qu_Six.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_five);
        q5_b();
    }
}
