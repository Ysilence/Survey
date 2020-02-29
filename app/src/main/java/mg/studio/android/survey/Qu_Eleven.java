package mg.studio.android.survey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Qu_Eleven extends AppCompatActivity {

    protected Button q11_btn;
    void q11_b() {
        q11_btn = findViewById(R.id.button12);
        RadioGroup q11_rg=findViewById(R.id.q11_rg);
        q11_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.q11_1:
                        MyApp.q[11][1]=("Male");
                        break;
                    case R.id.q11_2:
                        MyApp.q[11][1]=("Female");
                        break;
                }
                q11_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Qu_Eleven.this, Qu_Twelve.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_eleven);
        q11_b();
    }
}
