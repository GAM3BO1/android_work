package com.example.step02listview;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    List<String> names;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //res/layout/activity_main.xml 문서를 전개해서 화면 구성
        setContentView(R.layout.activity_main);

        //ListView의 참조값
        ListView listView = findViewById(R.id.listView);

        //ListView에 출력할 SampleData
        names = new ArrayList<>();
        names.add("홍길동");
        names.add("백호");
        names.add("한량");
        for(int i = 0; i < 100; i++){
            names.add("백수" + i);
        }

        //ListView에 연결할 adapter 객체
        //new ArrayAdapter<>(Context, layout resource, model)
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                names
        );
        //adapter를 ListView에 연결하기
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);

        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(view->{
            EditText inputName = findViewById(R.id.inputName);
            String name = inputName.getText().toString();
            names.add(name);
            adapter.notifyDataSetChanged();
            inputName.setText("");

            listView.smoothScrollToPosition(adapter.getCount());
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, names.get(i), Toast.LENGTH_SHORT).show();
    }

    //listView의 cell을 오래 클릭하면 호출되는 메소드
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        /*
        //알림창에 있는 버튼을 눌렀을 때 호출되는 메소드를 가지고 있는 리스너 객체
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int b) {
                if(b == DialogInterface.BUTTON_POSITIVE){   //yes 버튼 클릭시
                    //i번째 인덱스의 아이템 제거
                    names.remove(i);
                    //모델이 변경되었다고 adapter에 알리면 ListView가 업데이트
                    adapter.notifyDataSetChanged();
                }
            }
        };

        new AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("delete?")
                .setPositiveButton("yes", listener)
                .setNegativeButton("no", listener)
                .create()
                .show();
        */

        new AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("delete?")
                .setPositiveButton("yes", (a, b) ->{
                    //i번째 인덱스의 아이템 제거
                    names.remove(i);
                    //모델이 변경되었다고 adapter에 알리면 ListView가 업데이트
                    adapter.notifyDataSetChanged();
                })
                .setNegativeButton("no", null)
                .create()
                .show();

        return false;
    }

}