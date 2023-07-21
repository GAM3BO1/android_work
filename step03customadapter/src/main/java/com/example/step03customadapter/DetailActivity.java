package com.example.step03customadapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //DetailActivity가 활성화되기 위해서 전달된 Intent 객체의 참조값 얻어내기
        Intent intent = getIntent();
        //"dto"라는 key값으로 담긴 Serializable type의 참조값을 얻어내서 CountryDto type으로 casting
        CountryDto dto = (CountryDto) intent.getSerializableExtra("dto");

        //선택된 cell에 해당하는 CountryDto를 위에서 얻어내서
        //아래의 ImageView와 TextView에 해당 정보 출력
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(dto.getResId());
        TextView textView = findViewById(R.id.textView);
        textView.setText(dto.getContent());

        //확인 버튼을 눌렀을 때 Activity 종료시키기
        Button confirmBtn = findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(view -> {
            //finish() 메소드를 호출하면 Activity가 종료된다
            finish();
        });
    }
}