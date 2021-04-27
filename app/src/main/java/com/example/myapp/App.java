package com.example.myapp;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

public class App extends Application {
    SharedPreferences sharedPreferences;
   
    public App(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
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


  

}
