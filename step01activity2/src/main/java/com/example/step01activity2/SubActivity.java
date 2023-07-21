package com.example.step01activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //debugging log 출력하기 => Log.d("꼬리표", "메세지")
        Log.d("SubActivity", "onCreate() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SubActivity", "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SubActivity", "onResume() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("SubActivity", "onRestart() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SubActivity", "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SubActivity", "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SubActivity", "onDestory() called");
    }
}