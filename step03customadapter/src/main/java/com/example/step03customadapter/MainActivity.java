package com.example.step03customadapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //필드
    List<CountryDto> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adapter에 연결할 모델 객체 생성
        countries = new ArrayList<>();
        //sample data
        countries.add(new CountryDto(R.drawable.austria,"오스트리아", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.belgium,"벨기에", "초콜릿"));
        countries.add(new CountryDto(R.drawable.brazil, "브라질", "축구"));
        countries.add(new CountryDto(R.drawable.france,"프랑스", "먼나라 이웃나라"));
        countries.add(new CountryDto(R.drawable.germany,"독일", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.greece,"그리스", "로마 신화"));
        countries.add(new CountryDto(R.drawable.israel,"이스라엘", "스라"));
        countries.add(new CountryDto(R.drawable.italy,"이탈리아", "핏짜"));
        countries.add(new CountryDto(R.drawable.japan,"일본", "옆나라 섬나라"));
        countries.add(new CountryDto(R.drawable.korea,"대한민국", "나랏말싸미뒹귝에달아"));
        countries.add(new CountryDto(R.drawable.poland,"폴란드", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.spain,"스페인", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.usa,"미국", "햄붜궐"));

        //ListView에 연결할 adapter 객체 생성
        CountryAdapter adapter = new CountryAdapter(this, R.layout.listview_cell, countries);

        //ListView의 참조값 얻어와서
        ListView listView = findViewById(R.id.listView);
        //adapter 연결
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //DetailActivity로 이동할 Intent 객체 생성하기
        Intent intent = new Intent(this, DetailActivity.class);

        //클릭한 셀에 있는 나라의 정보
        CountryDto dto = countries.get(i);
        //Intent 객체에 "dto"라는 key값으로 Serializable type인 CountryDto 객체의 참조값 전달하기
        intent.putExtra("dto", dto);

        //startActivity() 메소드 호출하면서 Intent 객체를 전달해서 Activity 시작시키기
        startActivity(intent);
    }
}