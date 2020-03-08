package mg.studio.android.survey;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;

public class JsonToaGet {
    public  String getQ="{\"survey\":" +
            "{\"id\":\"12344134\",\"len\":\"2\"," +
            "\"questions\":[{\"type\":\"single\"," +
            "\"question\":\"How well do the professors teach at this university?\"," +
            "\"options\":[{\"1\":\"Extremely well\"},{\"2\":\"Very well\"}]}," +
            "{\"type\":\"single\",\"question\":" +
            "\"How effective is the teaching outside yur major at the univesrity?\"," +
            "\"options\":[{\"1\":\"Extremetly effective\"},{\"2\":\"Very effective\"}," +
            "{\"3\":\"Somewhat effective\"},{\"4\":\"Not so effective\"},{\"5\":" +
            "\"Not at all effective\"}]}]}}\n";

    public static String q1_t="How well do the professors teach at this university?";
    public static String q1_1="Extremely well";
    public static String q1_2="Very well";
    public static String q2_t="How effective is the teaching outside yur major at the univesrity?";
    public static String q2_1="Extremetly effective";
    public static String q2_2="Very effective";
    public static String q2_3="Somewhat effective";
    public static String q2_4="Not so effective";
    public static String q2_5="Not at all effective";

    public void JsonToaGet()
    {
        try {
            JSONArray array = new JSONArray(getQ);
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < 2; i++) {
                JSONObject object = array.getJSONObject(i);
                if(i==0)
                {

                }
                if(i==1)
                {

                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





}
