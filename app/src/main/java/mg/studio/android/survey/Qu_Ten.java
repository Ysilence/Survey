package mg.studio.android.survey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Qu_Ten extends AppCompatActivity {

    protected Button q10_btn;
    void q10_b() {
        q10_btn = findViewById(R.id.button11);
        RadioGroup q10_rg=findViewById(R.id.q10_rg);
        q10_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q10_1:
                        MyApp.q[10][1]=("Under 18");
                        break;
                    case R.id.q10_2:
                        MyApp.q[10][1]=("19-25");
                        break;
                    case R.id.q10_3:
                        MyApp.q[10][1]=("25-35");
                        break;
                    case R.id.q10_4:
                        MyApp.q[10][1]=("beyond 35");
                        break;
                }
                q10_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Qu_Ten.this, Qu_Eleven.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_ten);
        q10_b();
    }
}
