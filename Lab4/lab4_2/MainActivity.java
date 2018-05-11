package com.example.rlaqk.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    LinearLayout base_Area;
    LinearLayout sliding_Area;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        base_Area=(LinearLayout)findViewById(R.id.base_Area);
        sliding_Area=(LinearLayout)findViewById(R.id.sliding_Area);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//open button을 클릭하면 이벤트 발생
                sliding_Area.setVisibility(View.VISIBLE);//sliding area 영역의 보여준다.
                Animation slide_left= AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.translate);//translate 선언
                sliding_Area.startAnimation(slide_left);//왼족으로 sliding area가 이동해서 나타난다.
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//close button을 클릭하면 이벤트 발생
                Animation slide_right= AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.translate1);//translate 선언
                sliding_Area.startAnimation(slide_right);//오른쪽으로 sliding area가 이동해서 나타난다.
                sliding_Area.setVisibility(View.INVISIBLE);//마지막에 sliding area을 invisible해준다.
            }
        });
    }
}
