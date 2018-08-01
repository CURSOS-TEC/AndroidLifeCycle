package com.example.user.lifecycleapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    private String mTestValue;
    private TextView mTextView;
    private SharedPreferences mSharedPref;
    private Date mDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        this.mSharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        this.mTestValue = this.mSharedPref.getString("variable","valor por defecto");
        Log.i("Value onCreate",(this.mTestValue));
        mTextView = findViewById(R.id.textview_value);
        mTextView.setText((this.mTestValue));
        setMessage("Value onCreate: " + (this.mTestValue));

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Test", "onStart");
        //this.mTestValue = "onStart";
        Log.i("Value Start", (this.mTestValue));
        setMessage("Value onStart: " + (this.mTestValue));


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Test", "onResume");
        Log.i("Value onResume", (this.mTestValue));
        setMessage("Value onResume: " + (this.mTestValue));
        mTextView.setText((this.mTestValue));

    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Test", "onPause");
        Log.i("Value onPause",(this.mTestValue));
        setMessage("Value onPause: " + (this.mTestValue));

    }
    @Override
    protected void onStop() {
        super.onStop();  // Always call the superclass method first

        Log.i("Test", "onStop");
        Log.i("Value onStop", (this.mTestValue));
        setMessage("Value onStop: " + (this.mTestValue));

    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        mDate = Calendar.getInstance().getTime();
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString("variable",mDate.toString());
        editor.commit();
        Log.i("Test", "onDestroy");
        Log.i("Value onDestroy",(this.mTestValue));
        setMessage("Value onDestroy: " + (this.mTestValue));

    }

    public void setMessage(String text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
