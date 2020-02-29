package mg.studio.android.survey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Qu_Eight extends AppCompatActivity {

    protected Button q8_btn;
    void q8_b() {
        q8_btn = findViewById(R.id.button9);
        RadioGroup q8_rg=findViewById(R.id.q8_rg);
        q8_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q8_1:
                        MyApp.q[8][1]=("Iphone");
                        break;
                    case R.id.q8_2:
                        MyApp.q[8][1]=("Nokia");
                        break;
                    case R.id.q8_3:
                        MyApp.q[8][1]=("Samsung");
                        break;
                    case R.id.q8_4:
                        MyApp.q[8][1]=("MI");
                        break;
                    case R.id.q8_5:
                        MyApp.q[8][1]=("Lenovo");
                        break;
                    case R.id.q8_6:
                        MyApp.q[8][1]=("Sony");
                        break;
                    case R.id.q8_7:
                        MyApp.q[8][1]=("Others");
                        break;
                }
                q8_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Qu_Eight.this, Qu_Nine.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_eight);
        q8_b();
    }
}
