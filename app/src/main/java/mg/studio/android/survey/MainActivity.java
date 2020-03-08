package mg.studio.android.survey;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    protected Button w_btn;
    protected CheckBox w_b;

    public JSONArray Questions;

    public static String[] STitle=new String[20]; //single questions title
    public static String[] MTitle=new String[20]; //multiple questions title
    public static String[] FTitle=new String[20]; //fill questions title
    public static String[][] SQuestion=new String[20][20]; //single questions
    public static String[][] MQuestion=new String[20][20]; //multiple questions
    public static int QNum , SNum , MNum , FNum ;//  number of questions
    public int[] Sq=new int[20];
    public int i;

    void w_b() {
        w_btn = findViewById(R.id.button);
        w_b = findViewById(R.id.checkBox);

        w_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (w_b.isChecked()) {
                    Intent intent1=new Intent(MainActivity.this,Question006_1Activity.class);
                     startActivity(intent1);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        QNum = 0; SNum = 0; MNum = 0; FNum = 0;

        Questions = GetQuestions();
        int size = Questions.length();
        for(i=0;i<size;i++){

            try {
                getStr(Questions,i);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        w_b();
    }

    private JSONArray GetQuestions() {
        try {
            // read sample.json
            InputStreamReader inputReader = new InputStreamReader(
                    getAssets().open("Jsave.json"));
            BufferedReader buffReader = new BufferedReader(inputReader);
            String line = "";
            StringBuilder text = new StringBuilder();
            while ((line = buffReader.readLine()) != null) {
                text.append(line.trim());
            }
            inputReader.close();
            // analyse text
            JSONObject json = new JSONObject(text.toString());
            JSONObject survey = json.getJSONObject("survey");
            // return question json object list
            return survey.getJSONArray("questions");
        } catch (IOException ioe) {
            return null;
        } catch (JSONException je) {
            return null;
        }
    }

    public void getStr(JSONArray ques,int t_i) throws JSONException {
        int size = ques.length();

        //JSONObject jsonObject = new JSONObject(ques.toString());
        //JSONArray jsonArray = jsonObject.getJSONArray("type");

            JSONObject object = ques.getJSONObject(t_i);
            if (object.getString("type").equals("single")) {

                STitle[SNum] = object.getString("question");
                JSONArray jsonArray = object.getJSONArray("options");




                for (int j = 0; j < jsonArray.length(); j++) {

                    JSONObject object2 = jsonArray.getJSONObject(j);
                    int t=j+1;
                    String temp = j + "";

                    SQuestion[SNum][j] = object2.getString(temp);

                    //Toast.makeText(getApplicationContext(), SQuestion[SNum][0], Toast.LENGTH_SHORT).show();

                }
               //SNum++;
            }
            if (object.getString("type").equals("multiple")) {
                MTitle[MNum] = object.getString("question");

                JSONArray jsonArray = object.getJSONArray("options");

                for (int j = 0; j < jsonArray.length(); j++) {

                    JSONObject object2 = jsonArray.getJSONObject(j);
                    int t=j+1;
                    String temp = j + "";
                    MQuestion[MNum][j] = object2.getString(temp);
                }

                //MNum++;

            }

            //(object.getString("type").equals("fill"))

            else  {
                FTitle[FNum] = object.getString("question");

                FNum++;

            }

        }


}




