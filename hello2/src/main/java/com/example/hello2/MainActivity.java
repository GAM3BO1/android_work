package com.example.hello2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/*
* 이 MainActivity는 hello2 앱이 실행(launch)될 때 최초로 사용자를 대면하는 Activity
* 대체로 Activity 하나는 화면 하나
* */
public class MainActivity extends AppCompatActivity {
    //Activity가 활성화될 때 최초 호출되는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //res/layout/activity_main.xml 문서를 전개(해석)해서 화면 구성
        setContentView(R.layout.activity_main);
    }

    //버튼을 클릭했을 때 호출되는 메소드(View 객체의 참조값이 매개변수에 전달)
    public void sendClicked(View v){
        Toast.makeText(this, "뿅", Toast.LENGTH_SHORT).show();
    }

    public void deleteClicked(View v){
        Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
    }
}