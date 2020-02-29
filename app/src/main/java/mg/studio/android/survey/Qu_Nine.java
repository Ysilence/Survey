package mg.studio.android.survey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Qu_Nine extends AppCompatActivity {

    protected Button q9_btn;
    void q9_b() {
        q9_btn = findViewById(R.id.button10);
        RadioGroup q9_rg=findViewById(R.id.q9_rg);
        q9_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q9_1:
                        MyApp.q[9][1]=("Appearance");
                        break;
                    case R.id.q9_2:
                        MyApp.q[9][1]=("Price");
                        break;
                    case R.id.q9_3:
                        MyApp.q[9][1]=("Performance");
                        break;
                    case R.id.q9_4:
                        MyApp.q[9][1]=("Others");
                        break;
                }
                q9_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Qu_Nine.this, Qu_Ten.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_nine);
        q9_b();
    }
}
