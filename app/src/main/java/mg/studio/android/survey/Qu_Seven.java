package mg.studio.android.survey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Qu_Seven extends AppCompatActivity {

    protected Button q7_btn;
    void q7_b() {
        q7_btn = findViewById(R.id.button8);
        RadioGroup q7_rg=findViewById(R.id.q7_rg);
        q7_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q7_1:
                        MyApp.q[7][1]=("When the old phone has been used for a year or two.(but it still works)");
                        break;
                    case R.id.q7_2:
                        MyApp.q[7][1]=("When the old phone has been used for more than three years.(but it still works)");
                        break;
                    case R.id.q7_3:
                        MyApp.q[7][1]=("When the old phone breaks down.");
                        break;
                    case R.id.q7_4:
                        MyApp.q[7][1]=("When a new phone is released.");
                        break;
                    case R.id.q7_5:
                        MyApp.q[7][1]=("Others");
                        break;
                }
                q7_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Qu_Seven.this, Qu_Eight.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_seven);
        q7_b();
    }
}
