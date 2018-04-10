package com.example.rlaqk.lab22;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    TextView textView;
    Button goBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView=(TextView)findViewById(R.id.text);
        goBtn=(Button)findViewById(R.id.button1);
        backBtn=(Button)findViewById(R.id.button2);

        final Intent passedIntent=getIntent();//intent 받기
        final String  passedUrl=passedIntent.getStringExtra("Url");//url string
        textView.setText(passedUrl);

        goBtn.setOnClickListener(new View.OnClickListener() {//go 버튼을 눌렀을 경우
            @Override
            public void onClick(View v) {
                if(passedUrl.isEmpty()!=true){//만약 URL이 비어있지 않으면 사이트에 들어간다.
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+passedUrl));
                    startActivity(intent);
                }
                else{//URL string이 없으면 주소를 다시 입력하게 toast를 띄어준다.
                    Toast.makeText(getApplication(), "주소를 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {//back 버튼을 눌렀을 경우
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),"뒤로가기버튼을 눌렀습니다.",Toast.LENGTH_LONG).show();//뒤로가기 버튼을 눌렀을 떄 toast를 띄어준다.
                finish();
            }
        });
    }
}
