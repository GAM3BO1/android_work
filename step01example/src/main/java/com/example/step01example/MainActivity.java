package com.example.step01example;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendBtn = findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(this);

        //send2 버튼의 동작은 다른 형식으로 구현
        Button sendBtn2 = findViewById(R.id.sendBtn2);
        sendBtn2.setOnClickListener(view->{
            EditText text = findViewById(R.id.editText);

            TextView t = findViewById(R.id.textView);
            t.setText(text.getText().toString());
        });

    }

    @Override
    public void onClick(View view) {
        EditText text = findViewById(R.id.editText);

        TextView t = findViewById(R.id.textView);
        t.setText(text.getText().toString());
    }
}