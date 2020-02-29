package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    protected Button w_btn;
    protected CheckBox w_b;
    void w_b(){
        w_btn=findViewById(R.id.button);
        w_b=findViewById(R.id.checkBox);

        w_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(w_b.isChecked()) {
                    Intent intent1=new Intent(MainActivity.this, Qu_One.class);
                    startActivity(intent1);
                }
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        w_b();
    }
}
