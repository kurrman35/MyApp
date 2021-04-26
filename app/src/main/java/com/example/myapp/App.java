package com.example.myapp;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

public class App extends Application {
    SharedPreferences sharedPreferences;
    int count;
     public final static String BROADCAST_ACTION="com.example.SS.servicebackbroadcast";
    public final static String Command="update";
    Intent intent = new Intent(App.BROADCAST_ACTION);

    public App(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        //   sharedPreferences = getPreferences(0);
        int count = sharedPreferences.getInt("numRun", 0);
        count++;
        sharedPreferences.edit().putInt("numRun", count).commit();

    if(count==3){
        Toast toast = Toast.makeText(getApplicationContext(),
                " Hello  ",
                Toast.LENGTH_SHORT);
        toast.show();
    }
        System.out.println(" Application  this "+count +"  "+this );

    }


    //@Override
    public void update(int s) {
        System.out.println(" Application  update ");

        // intent.putExtra(App.Command, "update"+s);
        intent.putExtra(App.Command, s);
        sendBroadcast(intent);
    }

}
