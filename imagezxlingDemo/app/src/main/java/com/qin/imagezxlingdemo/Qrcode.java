package com.qin.imagezxlingdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Qrcode extends AppCompatActivity {
    private ImageView im1;  //imageview图片
    private int w,h;        //图片宽度w,高度h
    public static List<Activity> activityList = new LinkedList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        Button bt=(Button)findViewById(R.id.bt_make);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createImage(Questionmake.answer);
                //createQRcodeImage("{\"survey\":{\"id\":\"12344134\",\"len\":\"2\",\"questions\":[{\"type\":\"single\",\"question\":\"What mobile phone do you have?\",\"options\":[{\"1\":\"Iphone\"},{\"2\":\"Android\"}]},{\"type\":\"single\",\"question\":\"How effective is the teaching outside yur major at the univesrity?\",\"options\":[{\"1\":\"Extremetly effective\"},{\"2\":\"Very effective\"},{\"3\":\"Somewhat effective\"},{\"4\":\"Not so effective\"},{\"5\":\"Not at all effective\"}]}]}}\n");
            }
        });

        Button bt2=(Button)findViewById(R.id.bt_exit);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exit();


               //退出
            }
        });



    }
    public void exit(){

        Intent intent = new Intent();
        intent.setClass(Qrcode.this, Choose.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //注意本行的FLAG设置
        startActivity(intent);  //注意，startActivity是异步执行，换句话说，startActivity是立即返回的，是不会阻塞的，因此下面的finish得意执行
        finish();//关掉自己
        ExitApplication.getInstance().exit(this);

    }

    //转换成二维码QRcode的函数。参数为一个字符串
    public void createImage(String url)
    {
        im1=(ImageView)findViewById(R.id.imageView);
        w=im1.getWidth();
        h=im1.getHeight();
        try
        {
            //判断URL合法性
            if (url == null || "".equals(url) || url.length() < 1)
            {
                return;
            }
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            //图像数据转换，使用了矩阵转换
            BitMatrix bitMatrix = new QRCodeWriter().encode(url, BarcodeFormat.QR_CODE, w, h, hints);
            int[] pixels = new int[w * h];
            //下面这里按照二维码的算法，逐个生成二维码的图片，
            //两个for循环是图片横列扫描的结果
            for (int y = 0; y < h; y++)
            {
                for (int x = 0; x < w; x++)
                {
                    if (bitMatrix.get(x, y))
                    {
                        pixels[y * w + x] = 0xff000000;
                    }
                    else
                    {
                        pixels[y * w + x] = 0xffffffff;
                    }
                }
            }
            //生成二维码图片的格式，使用ARGB_8888
            Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, w, 0, 0, w, h);
            //显示到我们的ImageView上面
            im1.setImageBitmap(bitmap);
        }
        catch (WriterException e)
        {
            e.printStackTrace();
        }
    }





}
