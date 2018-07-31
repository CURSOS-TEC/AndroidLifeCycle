package com.example.user.lifecycleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private int mTestValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mTestValue = -1;
        Log.i("Value onCreate", Integer.toString(this.mTestValue));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Test", "onStart");
        this.mTestValue = 0;
        Log.i("Value Start", Integer.toString(this.mTestValue));

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Test", "onResume");
        Log.i("Value onResume", Integer.toString(this.mTestValue));

    }
    @Override
    protected void onPause() {
        super.onPause();
        super.onResume();
        Log.i("Test", "onResume");

    }
    @Override
    protected void onStop() {
        super.onStop();  // Always call the superclass method first
        Log.i("Test", "onStop");

    }

    @Override
    public void onDestroy() {
        Log.i("Test", "onDestroy");
        super.onDestroy();

    }

}
