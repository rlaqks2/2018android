package com.example.rlaqk.lab3_2;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class NewActivity extends AppCompatActivity {
    Button button1;
    TextView name;
    TextView sex;
    TextView send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        button1=(Button)findViewById(R.id.btn);
        name=(TextView)findViewById(R.id.text1);//이름
        sex=(TextView)findViewById(R.id.text2);//성별
        send=(TextView)findViewById(R.id.text3);//수신
        Intent mainIntent=getIntent();//intent 얻어오기

        String str=mainIntent.getStringExtra("sex");//성별
        String str1=mainIntent.getStringExtra("send");//수신
        String str2=mainIntent.getStringExtra("name");// 이름
        name.setText(str2);//text 작성
        sex.setText(str);
        send.setText(str1);
        button1=(Button)findViewById(R.id.btn);//button 클릭시 끝내기
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
