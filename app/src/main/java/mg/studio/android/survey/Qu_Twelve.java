package mg.studio.android.survey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Qu_Twelve extends AppCompatActivity {

    protected Button q12_btn;
    void q12_b() {
        q12_btn = findViewById(R.id.button13);
        RadioGroup q12_rg=findViewById(R.id.q12_rg);
        q12_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q12_1:
                        MyApp.q[12][1]=("I haven't got a job");
                        break;
                    case R.id.q12_2:
                        MyApp.q[12][1]=("Under 3000");
                        break;
                    case R.id.q12_3:
                        MyApp.q[12][1]=("3000-5000");
                        break;
                    case R.id.q12_4:
                        MyApp.q[12][1]=("5000-10000");
                        break;
                    case R.id.q12_5:
                        MyApp.q[12][1]=("more than 10000");
                        break;
                }

                q12_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Qu_Twelve.this, Finish_Sur.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_twelve);
        q12_b();
    }
}
