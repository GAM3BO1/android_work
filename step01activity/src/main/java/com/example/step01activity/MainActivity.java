package com.example.step01activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main.xml 문서를 전개해서 화면 구성하기
        setContentView(R.layout.activity_main);
    }

    //count를 셀 필드
    private int count = 0;
    //버튼을 클릭했을 때 실행되는 메소드
    public void clicked(View v){
        //count 1 증가
        count++;
        //count 값을 TextView에 출력
        //res/layout/activity_main.xml 문서를 전개해서 구성한 레이아웃에서 TextView의 참조값 얻어오기
        TextView t = findViewById(R.id.textView);
        t.setText(Integer.toString(count));
    }

    public void reset(View v){
        count = 0;
        /*
        * 현재 활성화되어 있는 액티비티가 구성한 화면에서
        * textView라는 아이디를 가지고 있는 UI의 참조값 얻어내서
        * TextView type의 t라는 지역 변수에 담기
        *
        * */
        TextView t = findViewById(R.id.textView);
        t.setText(Integer.toString(count));
    }
}