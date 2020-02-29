package mg.studio.android.survey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Finish_Sur extends AppCompatActivity {

    protected Button f_btn,r_sum, r_exit;
    protected String [][]q=new String[13][10];
    protected TextView r_q1,r_q2,r_q3,r_q4,r_q5,r_q6,r_q7,r_q8,r_q9,r_q10,r_q11,r_q12;
    void  f_b(){
        f_btn = findViewById(R.id.button14);
        f_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Finish_Sur.this, Report_Sur.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_survey);
        f_b();
    }
}
