package com.example.rlaqk.lab3_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    public Button btnFrag1;
    public Button btnFrag2;
    Fragment1 fragment1;
    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();//초기값

        setListener();
    }

    public void setListener(){


        btnFrag1.setOnClickListener(new View.OnClickListener() {// 버튼에 대한 fragment1을 불러온다.
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
            }
        });

        btnFrag2.setOnClickListener(new View.OnClickListener() {// 버튼에 대한 fragment2를 불러온다.
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
            }
        });
    }

    public void init(){
        //버튼 변수를 선언합니다
        btnFrag1 = findViewById(R.id.buttonFrag1);
        btnFrag2 = findViewById(R.id.buttonFrag2);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
    }
}
