package com.example.rlaqk.lab22;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Url;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Url=(EditText)findViewById(R.id.editText);//URL 입력 등록
        nextBtn=(Button)findViewById(R.id.button0);//버튼 등록

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myUrl=Url.getText().toString();
                Intent intent= new Intent(getApplicationContext(),NewActivity.class);//newacticity로 intent한다.
                intent.putExtra("Url",myUrl);//url data newactivity 보내기
                startActivity(intent);// intent 보내기
            }
        });
    }
}
