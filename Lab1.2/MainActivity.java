package com.example.rlaqk.tutorio1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {//ImageView 변수에 대한 id 설정
    public EditText edit_name;//TextView, button, EditText 변수선언
    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();//초기화
    }
    //변수에 id값을 넣어준다.
public void init(){
    edit_name = findViewById(R.id.editText);
    view_print = findViewById(R.id.label);
    btn_print = findViewById(R.id.PRINT);
    btn_clear = findViewById(R.id.CLEAR);

}
    //CLEAR버튼 눌렀을 시 초기화
   public void clearClicked(View v){
       edit_name.setText("");//이름 초기화
       view_print.setText("");//모든 이름 초기화
   }
//PRINT 눌렀을 시 이름 저장
   public void printClicked(View v){
       String text="";
       text=edit_name.getText().toString();//string으로 이름을 가져온다

       edit_name.setText("");//name 초기화
       view_print.setText(view_print.getText().toString()+"\n"+text);//이름 print
   }

}