package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Qu_One extends AppCompatActivity {

    protected Button q1_btn;
    void q1_b() {
        q1_btn = findViewById(R.id.button2);
        RadioGroup q1_rg=findViewById(R.id.q1_rg);
        q1_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q1_1:
                        MyApp.q[1][1]=("Iphone");
                        break;
                    case R.id.q1_2:
                        MyApp.q[1][1]=("Nokia");
                        break;
                    case R.id.q1_3:
                        MyApp.q[1][1]=("Samsung");
                        break;
                    case R.id.q1_4:
                        MyApp.q[1][1]=("MI");
                        break;
                    case R.id.q1_5:
                        MyApp.q[1][1]=("Lenovo");
                        break;
                    case R.id.q1_6:
                        MyApp.q[1][1]=("Sony");
                        break;
                    case R.id.q1_7:
                        MyApp.q[1][1]=("Others");
                        break;
                }

                q1_btn.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Qu_One.this, Qu_Two.class);
                        startActivity(intent);
                    }
                }));

            }
        });


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_one);
        q1_b();
    }
}
