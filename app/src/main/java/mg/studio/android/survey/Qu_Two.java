package mg.studio.android.survey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Qu_Two extends AppCompatActivity {

    protected Button q2_btn;
    void q2_b() {
        q2_btn = findViewById(R.id.button3);
        RadioGroup q2_rg=findViewById(R.id.q2_rg);
        q2_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q2_1:
                        MyApp.q[2][1]=("Under 1000");
                        break;
                    case R.id.q2_2:
                        MyApp.q[2][1]=("1000-1999");
                        break;
                    case R.id.q2_3:
                        MyApp.q[2][1]=("2000-2999");
                        break;
                    case R.id.q2_4:
                        MyApp.q[2][1]=("3000-3999");
                        break;
                    case R.id.q2_5:
                        MyApp.q[2][1]=("more than 4000");
                        break;
                }

                q2_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Qu_Two.this, Qu_Three.class);
                        startActivity(intent);

                    }
                });
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_two);
        q2_b();
    }
}
