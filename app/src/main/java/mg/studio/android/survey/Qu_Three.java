package mg.studio.android.survey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Qu_Three extends AppCompatActivity {

    protected Button q3_btn;
    void q3_b() {
        q3_btn = findViewById(R.id.button4);

        RadioGroup q3_rg=findViewById(R.id.q3_rg);
        q3_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q3_1:
                        MyApp.q[3][1]=("2G");
                        break;
                    case R.id.q3_2:
                        MyApp.q[3][1]=("3G");
                        break;
                    case R.id.q3_3:
                        MyApp.q[3][1]=("4G");
                        break;
                    case R.id.q2_4:
                        MyApp.q[3][1]=("Others");
                        break;
                }
                q3_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Qu_Three.this, Qu_Four.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_three);
        q3_b();
    }
}
