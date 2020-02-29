package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

class MyApp extends AppCompatActivity {
    public static String [][]q=new String[13][10];
    public static MyApp instance;
    public static MyApp getInstance(){
        return instance;
    }


    public static void setOne(String str,int one,int two){
        q[one][two]=str;
    }

    public static void setsome(String [][]str,int one)
    {
        for(int i=1;str[one][i]==null;i++)
            q[one][i]=str[one][i];
    }

    public static String[][] getStr()
    {
        return q;
    }

    public void onCreate(){
        onCreate();
        instance = this;
    }

}

