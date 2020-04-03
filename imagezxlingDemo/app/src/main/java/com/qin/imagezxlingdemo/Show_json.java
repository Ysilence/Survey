package com.qin.imagezxlingdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Show_json extends AppCompatActivity {

    int flag=0;     //Used to determine how many questions to answer
    int flag1=0;
    int[] question_num=new int[100];  //Used to determine that there are several options in this question to limit the user's answers
    String [][]answer=new String[100][100]; //Holds options read from a file
    String []type=new String[100];  //Type of storage question
    String []question=new String[100];  //store questions

    TextView txt_question;
    RadioButton bt_1;
    RadioButton bt_2;
    RadioButton bt_3;
    RadioButton bt_4;
    RadioButton bt_5;

    CheckBox ck_1;
    CheckBox ck_2;
    CheckBox ck_3;
    CheckBox ck_4;
    CheckBox ck_5;

    Button bt_choose;


    Intent intent;
    String id;
    String len;

    public static String save_data="your answers are here你的答案:\n \n";  //User's answer
    private static final String ACTIVITY_TAG="LogDemo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_json);
        bt_1=(RadioButton)findViewById(R.id.choose_1);
        bt_2=(RadioButton)findViewById(R.id.choose_2);
        bt_3=(RadioButton)findViewById(R.id.choose_3);
        bt_4=(RadioButton)findViewById(R.id.choose_4);
        bt_5=(RadioButton)findViewById(R.id.choose_5);
        bt_choose=(Button)findViewById(R.id.bt_choose);
        txt_question=(TextView)findViewById(R.id.txt_questions);
        ck_1=(CheckBox)findViewById(R.id.mul1);
        ck_2=(CheckBox)findViewById(R.id.mul2);
        ck_3=(CheckBox)findViewById(R.id.mul3);
        ck_4=(CheckBox)findViewById(R.id.mul4);
        ck_5=(CheckBox)findViewById(R.id.mul5);





        //Read file
       try {
            String show_json=SActivity.result;
            JSONObject rootObject = new JSONObject(show_json);
            JSONObject surveyObject = rootObject.getJSONObject("survey");
            String id = surveyObject.getString("id");
            String len = surveyObject.getString("len");
            JSONArray questionsArray = surveyObject.getJSONArray("questions");
            for(int i=0;i<questionsArray.length();i++){
                JSONObject questionsObject = questionsArray.getJSONObject(i);
                type[i]=questionsObject.getString("type");
                question[i]=questionsObject.getString("question");
                JSONArray optionsArray=questionsObject.getJSONArray("options");
                for(int j=0;j<optionsArray.length();j++){
                    String number = String.valueOf(j+1);
                    JSONObject optionsObject = optionsArray.getJSONObject(j);
                    answer[i][j] = optionsObject.toString();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        String result="";
        for(int i=0;question[i]!=null;i++){
            result+="("+type[i]+")"+question[i]+"\n";
            for(int j=0;answer[i][j]!=null;j++){
                question_num[i]=j+1;
                result+=answer[i][j]+"\n";
            }
        }

    }




    void single(){
        if(question[flag]!=null) {
            if(flag1==0){
                for(int i=0;answer[flag][i]!=null;i++){
                    String temp;
                    temp="bt_"+(i+1);
                    switch (temp){
                        case "bt_1":
                            bt_1.setText(answer[0][i]);
                            bt_1.setVisibility(View.VISIBLE);
                            break;
                        case "bt_2":
                            bt_2.setText(answer[0][i]);
                            bt_2.setVisibility(View.VISIBLE);
                            break;
                        case "bt_3":
                            bt_3.setText(answer[0][i]);
                            bt_3.setVisibility(View.VISIBLE);
                            break;
                        case "bt_4":
                            bt_4.setText(answer[0][i]);
                            bt_4.setVisibility(View.VISIBLE);
                            break;
                        case "bt_5":
                            bt_5.setText(answer[0][i]);
                            bt_5.setVisibility(View.VISIBLE);
                            break;
                    }
                }
                txt_question.setText(question[0]);
                bt_choose.setText("CHOOSE  选择");
                flag1=1;
            }
            else {
                if(bt_1.isChecked()){
                    flag+=1;
                    save_data += "question" + flag + ":" + bt_1.getText().toString() + "\n";
                }
                if(bt_2.isChecked()){
                    flag+=1;
                    save_data += "question" + flag + ":" + bt_2.getText().toString() + "\n";
                }
                if(bt_3.isChecked()){
                    flag+=1;
                    save_data += "question" + flag + ":" + bt_3.getText().toString() + "\n";
                }
                if(bt_4.isChecked()){
                    flag+=1;
                    save_data += "question" + flag + ":" + bt_4.getText().toString() + "\n";
                }
                if(bt_5.isChecked()){
                    flag+=1;
                    save_data += "question" + flag + ":" + bt_5.getText().toString() + "\n";
                }
                if(question[flag]!=null){
                    txt_question.setText(question[flag]);
                }

                for(int i=0;answer[flag][i]!=null;i++){
                    String temp;
                    temp="bt_"+(i+1);
                    switch (temp){
                        case "bt_1":
                            bt_1.setText(answer[flag][i]);
                            bt_1.setVisibility(View.VISIBLE);
                            break;
                        case "bt_2":
                            bt_2.setText(answer[flag][i]);
                            bt_2.setVisibility(View.VISIBLE);
                            break;
                        case "bt_3":
                            bt_3.setText(answer[flag][i]);
                            bt_3.setVisibility(View.VISIBLE);
                            break;
                        case "bt_4":
                            bt_4.setText(answer[flag][i]);
                            bt_4.setVisibility(View.VISIBLE);
                            break;
                        case "bt_5":
                            bt_5.setText(answer[flag][i]);
                            bt_5.setVisibility(View.VISIBLE);
                            break;
                    }
                }
            }
            if(question[flag]== null){
                bt_choose.setText("confirm  确认");
            }
        }else{
            save_answer(save_data);
            Intent intent = new Intent(Show_json.this,
                    Report.class);
            startActivity(intent);



        }
        }



 /*   void multiple(){

        if(question[flag]!=null) {
            if(flag1==0){
                for(int i=0;answer[flag][i]!=null;i++){
                    String temp;
                    temp="ck_"+(i+1);
                    switch (temp){
                        case "ck_1":
                            ck_1.setText(answer[0][i]);
                            ck_1.setVisibility(View.VISIBLE);
                            break;
                        case "ck_2":
                            ck_2.setText(answer[0][i]);
                            ck_2.setVisibility(View.VISIBLE);
                            break;
                        case "ck_3":
                            ck_3.setText(answer[0][i]);
                            ck_3.setVisibility(View.VISIBLE);
                            break;
                        case "ck_4":
                            ck_4.setText(answer[0][i]);
                            ck_4.setVisibility(View.VISIBLE);
                            break;
                        case "ck_5":
                            ck_5.setText(answer[0][i]);
                            ck_5.setVisibility(View.VISIBLE);
                            break;
                    }
                }
                txt_question.setText(question[0]);
                bt_choose.setText("CHOOSE");
                flag1=1;
            }
            else {
                if(ck_1.isChecked()){
                    flag+=1;
                    save_data += "question" + flag + ":" + ck_1.getText().toString() + "\n";
                }
                if(ck_2.isChecked()){
                    flag+=1;
                    save_data += "question" + flag + ":" + ck_2.getText().toString() + "\n";
                }
                if(ck_3.isChecked()){
                    flag+=1;
                    save_data += "question" + flag + ":" + ck_3.getText().toString() + "\n";
                }
                if(ck_4.isChecked()){
                    flag+=1;
                    save_data += "question" + flag + ":" + ck_4.getText().toString() + "\n";
                }
                if(ck_5.isChecked()){
                    flag+=1;
                    save_data += "question" + flag + ":" + ck_5.getText().toString() + "\n";
                }
                if(question[flag]!=null){
                    txt_question.setText(question[flag]);
                }

                for(int i=0;answer[flag][i]!=null;i++){
                    String temp;
                    temp="ck_"+(i+1);
                    switch (temp){
                        case "ck_1":
                            ck_1.setText(answer[flag][i]);
                            ck_1.setVisibility(View.VISIBLE);
                            break;
                        case "ck_2":
                            ck_2.setText(answer[flag][i]);
                            ck_2.setVisibility(View.VISIBLE);
                            break;
                        case "ck_3":
                            ck_3.setText(answer[flag][i]);
                            ck_3.setVisibility(View.VISIBLE);
                            break;
                        case "ck_4":
                            ck_4.setText(answer[flag][i]);
                            ck_4.setVisibility(View.VISIBLE);
                            break;
                        case "ck_5":
                            ck_5.setText(answer[flag][i]);
                            ck_5.setVisibility(View.VISIBLE);
                            break;
                    }
                }
            }
            if(question[flag]== null){
                bt_choose.setText("confirm");
            }
        }else{

            Intent intent = new Intent(Show_json.this,
                    TimeActivity.class);
            startActivity(intent);

        }
    }


*/


    public void confirm(View view){
            single();

      /*  else
        {
            //multiple();
        }


       */
    }

   //多选的判断出问题了
   /*
    public void confirm(View view){
        if(question[flag]!=null) {
            if(flag1==0){
                for(int i=0;answer[flag][i]!=null;i++){
                    String temp;
                    temp="bt_"+(i+1);
                    switch (temp){
                        case "bt_1":
                            bt_1.setText(answer[0][i]);
                            bt_1.setVisibility(View.VISIBLE);
                            break;
                        case "bt_2":
                            bt_2.setText(answer[0][i]);
                            bt_2.setVisibility(View.VISIBLE);
                            break;
                        case "bt_3":
                            bt_3.setText(answer[0][i]);
                            bt_3.setVisibility(View.VISIBLE);
                            break;
                        case "bt_4":
                            bt_4.setText(answer[0][i]);
                            bt_4.setVisibility(View.VISIBLE);
                            break;
                        case "bt_5":
                            bt_5.setText(answer[0][i]);
                            bt_5.setVisibility(View.VISIBLE);
                            break;
                    }
                }
                txt_question.setText(question[0]);
                bt_choose.setText("CHOOSE");
                flag1=1;
            }
            else {
                if(bt_1.isChecked()){
                    flag+=1;
                    save_data += "question" + flag + ":" + bt_1.getText().toString() + "\n";
                }
                if(bt_2.isChecked()){
                    flag+=1;
                    save_data += "question" + flag + ":" + bt_2.getText().toString() + "\n";
                }
                if(bt_3.isChecked()){
                    flag+=1;
                    save_data += "question" + flag + ":" + bt_3.getText().toString() + "\n";
                }
                if(bt_4.isChecked()){
                    flag+=1;
                    save_data += "question" + flag + ":" + bt_4.getText().toString() + "\n";
                }
                if(bt_5.isChecked()){
                    flag+=1;
                    save_data += "question" + flag + ":" + bt_5.getText().toString() + "\n";
                }
                if(question[flag]!=null){
                    txt_question.setText(question[flag]);
                }

                for(int i=0;answer[flag][i]!=null;i++){
                    String temp;
                    temp="bt_"+(i+1);
                    switch (temp){
                        case "bt_1":
                            bt_1.setText(answer[flag][i]);
                            bt_1.setVisibility(View.VISIBLE);
                            break;
                        case "bt_2":
                            bt_2.setText(answer[flag][i]);
                            bt_2.setVisibility(View.VISIBLE);
                            break;
                        case "bt_3":
                            bt_3.setText(answer[flag][i]);
                            bt_3.setVisibility(View.VISIBLE);
                            break;
                        case "bt_4":
                            bt_4.setText(answer[flag][i]);
                            bt_4.setVisibility(View.VISIBLE);
                            break;
                        case "bt_5":
                            bt_5.setText(answer[flag][i]);
                            bt_5.setVisibility(View.VISIBLE);
                            break;
                    }
                }
            }
            if(question[flag]== null){
                bt_choose.setText("confirm");
            }
        }else{
            Toast.makeText(Show_json.this,"Please choose and click to record your location and the date:",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Show_json.this,
                    TimeActivity.class);
            startActivity(intent);

        }
    }



    */

    //Store user answers
    private  void save_answer(String msg) {
        //I/O
        //get SDcard
        File sdFile = getExternalFilesDir(null);
        File saveData = new File(sdFile, "results.json");
        File saveData1 = new File(sdFile, "results.txt");
        File saveData_internal = new File(Show_json.this.getFilesDir(), "results.json");

        try {
            FileOutputStream fout1 = new FileOutputStream(saveData1,true);
            FileOutputStream fout = new FileOutputStream(saveData,true);
            FileOutputStream fout_internal = new FileOutputStream(saveData_internal,true);
            fout.write(msg.getBytes());
            //Log.v("Log",msg );
            fout.flush();
            fout.close();
            fout_internal.write(msg.getBytes());
            fout_internal.flush();
            fout_internal.close();
            fout1.write(msg.getBytes());
            fout1.flush();
            fout1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Read JSON file
    public String getFileFromeSD(String path){
        String result="";
        try{
            FileInputStream f = new FileInputStream(path);
            BufferedReader bis = new BufferedReader(new InputStreamReader(f));
            String line="";
            while((line = bis.readLine())!=null){
                result += line;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
