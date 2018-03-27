package com.example.rlaqk.tutorio1;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;//imageview 변수 저장
    ImageView imageView2;
    int imageIndex = 0;//그림판별
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);//맞는 그림id 저장
        imageView2 = (ImageView) findViewById(R.id.imageView2);
            }
public void onButton1Clicked(View v){//클릭 눌렀을 때 이벤트 발생
        this.changeImage();
}
private void changeImage() {
    if (imageIndex == 0) {//index가 0 이면 imageView 사진이 보이고 imageView2는 안보인다.
        imageView.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
        imageIndex = 1;
    }
    else if (imageIndex == 1) {
        imageView.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.VISIBLE);
        imageIndex = 0;
    }
}}

