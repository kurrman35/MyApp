package com.example.myapp;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String LOG_TAG =" main " ;
    // int[] price= {43,59,66,53,32,24};
    EditText EdText1,EdText2,EdText3;
    Button btnSetting,btnStart;
    TextView tvText4,tvText5,tvText2;
    Handler updateConversationHandler;
    SharedPreferences sharedPreferences;
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);

        EdText1 =(EditText) findViewById(R.id.price);
        EdText2 =(EditText) findViewById(R.id.discount);
        btnSetting=(Button)findViewById(R.id.btnSetting);
        btnStart=(Button)findViewById(R.id.btnStart);
        tvText5=(TextView)findViewById(R.id.tvText5);
        updateConversationHandler = new Handler();
     }

    @Override
    public void onClick(View v) {
         switch (v.getId()) {
            case R.id.btnStart:
                Log.d(LOG_TAG, "btnStart = " );

                String s1= EdText1.getText().toString();
                String s2= EdText2.getText().toString();
                System.out.println(s1+"  s1  " +s2);

                int b []=FromString(s2);
                int price []=FromString(s1);
                int [] pr2=decryptData(price, b[0], b[1], b[2]);
                if(pr2!=null) {
                    StringBuilder sd = new StringBuilder();

                    for (int j = 0; j < pr2.length; j++) {
                        sd.append(pr2[j] + ",");
                    }
                    String s3 = sd.toString();
                    tvText5.setText(s3);
                    }
                break;
            case R.id.btnSetting:

                 break;
        }
    }

    public  int [] FromString(String str) {
        String[] subStr;
        String delimeter = ","; // Разделитель
        subStr = str.split(delimeter);
        System.out.println(subStr.length+" subStr.length   " +"/"+subStr[0]+"/");

        int [] b=new int[subStr.length];

        for(int i=0; i<subStr.length;i++ ){
        b[i]=Integer.valueOf(subStr[i]);
        }
        return b;
    }

    /**
     * Метод "скидка". Применяет скидку discount к цене price, начиная с позиции
     offset
     * на количество позиций readLength. Новые цены округляем “вниз”,
     * до меньшего целого числа.
     * @param price - исходные цены.
     * @param discount - % скидки, от 1 до 99.
     * @param offset - номер позиции, с которой нужно применить скидку.
     * @param readLength - количество позиций, к которым нужно применить скидку.
     * @return - массив новых цен.
     */
    public @Nullable     int[] decryptData(@NonNull int[] price,
                      @IntRange(from = 1,to=99) int discount,
                      @IntRange(from = 0) int offset,
                      @IntRange(from = 1) int readLength) {
        int []price2=new int[readLength];
        if((offset+readLength)>price.length) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    " неверные данные , введите заново  ",
                    Toast.LENGTH_SHORT);
            toast.show();
            System.err.println(" readLength > price.length");
            return null;
        }
        for (int i=0;i< readLength;i++) {
            price2[i]=	price[offset+i]*(100-discount)/100;
           }

        return price2;
    }
}

