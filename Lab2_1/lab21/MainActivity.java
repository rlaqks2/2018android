package com.example.rlaqk.lab21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Age;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.editText1);//EditText data 저장
        Age = (EditText) findViewById(R.id.editText2);//Edit text 아이디 등록 후 사용
        button = (Button) findViewById(R.id.button1);// Button event id등록 후 사용


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=Name.getText().toString();//string 이름 받기
                String age=Age.getText().toString();//string 나이 받기
                Intent intent = new Intent(getApplicationContext(),NewActivity.class);//다른 activity로 보내기
                intent.putExtra("loginName", name);//put extra를 통해 다른 activity에서 사용 가능
                intent.putExtra("loginAge", age);//만약 putExtra를 하지 않으면 newactivity에서 null로 받을 것
                startActivity(intent);//intent시작
            }
        });
    }
}
