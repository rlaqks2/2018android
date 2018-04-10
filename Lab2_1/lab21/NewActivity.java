package com.example.rlaqk.lab21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent passedIntent=getIntent();//intent 선언
        if(passedIntent!=null){
            String loginName= passedIntent.getStringExtra("loginName");
            String loginAge=passedIntent.getStringExtra("loginAge");
            Toast.makeText(getApplicationContext(), "Student info: "
                    + loginName + ", " + loginAge, Toast.LENGTH_LONG).show();//toast를 통해 사용자 이름과 나이 출력
        }
        Button button0 = (Button) findViewById(R.id.button2);//button이벤트
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });//버튼 누르면 바로 이전 activity
    }
}
