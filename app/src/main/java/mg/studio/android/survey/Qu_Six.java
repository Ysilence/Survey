package mg.studio.android.survey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Qu_Six extends AppCompatActivity {

    protected Button q6_btn;

    void q6_b() {
        q6_btn = findViewById(R.id.button7);
        q6_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText q6_e;
                q6_e=findViewById(R.id.q6_edit);
                MyApp.q[6][1]=q6_e.getText().toString();

                Intent intent=new Intent(Qu_Six.this, Qu_Seven.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_six);
        q6_b();
    }
}
